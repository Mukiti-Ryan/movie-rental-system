package com.example.moviespringauth.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.moviespringauth.Entities.Role;
import com.example.moviespringauth.Entities.Staff;
import com.example.moviespringauth.Filters.CustomAuthorizationFilter;
import com.example.moviespringauth.Service.StaffService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class StaffResource {

    private final StaffService staffService;

    @GetMapping("/staffs")
    public ResponseEntity<List<Staff>>getStaffs() {
        return ResponseEntity.ok().body(staffService.getStaffs());
    }

    @PostMapping("/staff/save")
    public ResponseEntity<Staff>saveStaff(@RequestBody Staff staff) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(staffService.saveStaff(staff));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role>saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(staffService.saveRole(role));
    }

    @PostMapping("/role/addToUser")
    public ResponseEntity<?>saveRole(@RequestBody RoleToUserForm form) {
        staffService.addRoleToStaff(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

    @GetMapping("token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        Check the header
        String authorizationHeader = request.getHeader(AUTHORIZATION);
//        Check that the header is not null and starts with the word Bearer
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
//                Get the refresh token and remove bearer
                String refresh_token = authorizationHeader.substring("Bearer ".length());
//                Get the algorithm
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
//                Verify the algorithm
                JWTVerifier verifier = JWT.require(algorithm).build();
//                Decode the token
                DecodedJWT decodedJWT = verifier.verify(refresh_token);
//                Get the username
                String username = decodedJWT.getSubject();
//                Find the staff in the system
                Staff staff = staffService.getStaff(username);
//                Use the staff to create the token
                String access_token = JWT.create()
//                        Pass the username
                        .withSubject(staff.getUsername())
//                        Give the token an expiry date
                        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
//                        Make sure issuer is you
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", staff.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
//                        Sign token with the same algorithm used above
                        .sign(algorithm);
//                Create the token
                Map<String, String> tokens = new HashMap<>();
//                Parse the access_token and refresh_token
                tokens.put("access_token", access_token);
                tokens.put("refresh_token", refresh_token);
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            } catch (Exception exception) {
//                Call the response
                CustomAuthorizationFilter.responseHeader(response, exception);
            }
        } else {
            throw new RuntimeException("Refresh Token is missing");
        }
    }
}

@Data
class RoleToUserForm {
    private String username;
    private String roleName;
}

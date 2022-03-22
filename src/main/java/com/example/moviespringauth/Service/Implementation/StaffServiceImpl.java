package com.example.moviespringauth.Service.Implementation;

import com.example.moviespringauth.Entities.Role;
import com.example.moviespringauth.Entities.Staff;
import com.example.moviespringauth.Repositories.RoleRepository;
import com.example.moviespringauth.Repositories.StaffRepository;
import com.example.moviespringauth.Service.Interface.StaffService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class StaffServiceImpl implements StaffService, UserDetailsService {

    private final StaffRepository staffRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Staff user = staffRepository.findByUsername(username);
        if (user == null) {
            log.error("Staff not found in the database");
            throw new UsernameNotFoundException("Staff not found in the database");
        } else {
            log.info("Staff found in database: {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public Staff saveStaff(Staff staff) {
        log.info("Saving new user {} to the database", staff.getUsername());
        staff.setPassword(passwordEncoder.encode(staff.getPassword()));
        return staffRepository.save(staff);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToStaff(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName, username);
        Staff staff = staffRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        staff.getRoles().add(role);
    }

    @Override
    public Staff getStaff(String username) {
        log.info("Fetching user {}", username);
        return staffRepository.findByUsername(username);
    }

    @Override
    public List<Staff> getStaffs() {
        log.info("Fetching all users {}");
        return staffRepository.findAll();
    }
}

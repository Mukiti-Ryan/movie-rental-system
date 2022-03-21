package com.example.moviespringauth.Service;

import com.example.moviespringauth.Entities.Role;
import com.example.moviespringauth.Entities.Staff;

import java.util.List;

public interface StaffService {
    Staff saveStaff(Staff staff);
    Role saveRole(Role role);
    void addRoleToStaff(String username, String roleName);
    Staff getStaff(String username);
    List<Staff> getStaffs();
}

package com.SpringBootProject.EmployeeManagementSystem.Services;

import com.SpringBootProject.EmployeeManagementSystem.Models.Employee;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EmpUser implements UserDetails {


    private static final long serialVersionUID = 1L;

    private Employee employee;

    public EmpUser(Employee employee) {

        super();
        this.employee=employee;


    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {


        List<GrantedAuthority> grantedAuthorities=new ArrayList<GrantedAuthority>();
        grantedAuthorities.add(new SimpleGrantedAuthority("EMPLOYEE"+this.employee.getEmpFName().toUpperCase()));
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {

        return this.employee.getPassword();
    }

    @Override
    public String getUsername() {

        return this.employee.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    @Override
    public boolean isAccountNonLocked() {

        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {

        return true;
    }

    @Override
    public boolean isEnabled() {

        return true;
    }

    public Employee getUserDetails() {
        return employee;
    }

}

package com.example.springsecurity.utils;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.springsecurity.utils.ApplicationUserPermissions.COURSE_READ;
import static com.example.springsecurity.utils.ApplicationUserPermissions.STUDENT_READ;

public enum ApplicationUserRole {

    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(ApplicationUserPermissions.values())),
    ADMINTRAINEE(Sets.newHashSet(STUDENT_READ,COURSE_READ));

    private Set<ApplicationUserPermissions> permissionsSet;

    ApplicationUserRole(Set<ApplicationUserPermissions> permissionsSet) {
        this.permissionsSet = permissionsSet;
    }

    private Set<ApplicationUserPermissions> getPermissionsSet() {
        return permissionsSet;
    }

    public Set<SimpleGrantedAuthority> getSimpleGrantedAuthorities(){

        Set<SimpleGrantedAuthority> permissionAuthorities = getPermissionsSet()
                .stream().map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());

        permissionAuthorities.add(new SimpleGrantedAuthority("ROLE_"+this.name()));

        return permissionAuthorities;
    }
}

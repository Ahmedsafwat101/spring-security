package com.example.springsecurity.utils;

import com.google.common.collect.Sets;

import java.util.Set;

public enum ApplicationUserRole {
    STUDENT(Sets.newHashSet(ApplicationUserPermissions.values())),
    ADMIN(Sets.newHashSet());

    private Set<ApplicationUserPermissions> permissionsSet;

    ApplicationUserRole(Set<ApplicationUserPermissions> permissionsSet) {
        this.permissionsSet = permissionsSet;
    }

    public Set<ApplicationUserPermissions> getPermissionsSet() {
        return permissionsSet;
    }
}

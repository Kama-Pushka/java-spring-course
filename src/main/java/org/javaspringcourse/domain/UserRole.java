package org.javaspringcourse.domain;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    ADMIN,
    SUPPORT;

    @Override
    public String getAuthority() {
        return this.name();
    }
}

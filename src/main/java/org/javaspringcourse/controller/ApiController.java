package org.javaspringcourse.controller;

import org.javaspringcourse.dto.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/public/api")
    public String publicApi() {
        return "Hello World";
    }

    @GetMapping("/admin/api")
    public UserInfo getAdminInfo(@AuthenticationPrincipal UserDetails user) {
        return new UserInfo(user.getUsername(), user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList());
    }

    @GetMapping("/support/api")
    public UserInfo getSupportUserInfo(@AuthenticationPrincipal UserDetails user) {
        return new UserInfo(user.getUsername(), user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList());
    }
}

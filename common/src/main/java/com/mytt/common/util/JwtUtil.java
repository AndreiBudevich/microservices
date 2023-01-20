package com.mytt.common.util;

import com.mytt.common.model.Role;
import com.mytt.common.web.JwtUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class JwtUtil {

    public static JwtUser createJwtUser(Jwt jwt) {
        log.debug("create JwtUser for '{}'", jwt.getSubject());
        int id = ((Long) jwt.getClaims().get("id")).intValue();
        String rawRoles = (String) jwt.getClaims().get("roles");
        Set<Role> roles = Arrays.stream(rawRoles.split(" "))
                .map(Role::valueOf)
                .collect(Collectors.toSet());
        return new JwtUser(jwt, roles, id);
    }
}

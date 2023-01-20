package com.mytt.authorizationservice.util;

import com.mytt.authorizationservice.model.User;
import com.mytt.authorizationservice.to.UserTo;
import com.mytt.authorizationservice.web.AuthUser;
import com.mytt.common.model.Role;
import lombok.experimental.UtilityClass;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;

import java.util.stream.Collectors;

import static com.mytt.authorizationservice.config.LoginSecurityConfiguration.PASSWORD_ENCODER;

@UtilityClass
public class UserUtil {

    public static void addUserDetails(JwtClaimsSet.Builder builder, AuthUser authUser) {
        User user = authUser.getUser();
        String roles = user.getRoles().stream()
                .map(Enum::name).collect(Collectors.joining(" "));
        builder.subject(user.getEmail())
                .claim("id", user.id())
                .claim("roles", roles);
    }

    public static User createNewFromTo(UserTo userTo) {
        return new User(null, userTo.getName(), userTo.getEmail().toLowerCase(), userTo.getPassword(), Role.USER);
    }

    public static User updateFromTo(User user, UserTo userTo) {
        user.setName(userTo.getName());
        user.setEmail(userTo.getEmail().toLowerCase());
        user.setPassword(userTo.getPassword());
        return user;
    }

    public static User prepareToSave(User user) {
        user.setPassword(PASSWORD_ENCODER.encode(user.getPassword()));
        user.setEmail(user.getEmail().toLowerCase());
        return user;
    }
}
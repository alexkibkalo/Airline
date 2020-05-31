package com.fly.service.user.role;

import com.fly.persistence.entity.user.User;
import com.fly.persistence.entity.user.UserRole;

public class RoleUtils {

    public static boolean isUser(User user) {
        return user.getAuthorities().contains(UserRole.USER);
    }

    public static boolean isManager(User user) {
        return user.getAuthorities().contains(UserRole.MANAGER);
    }

    public static boolean isAdmin(User user) {
        return user.getAuthorities().contains(UserRole.ADMIN);
    }
}

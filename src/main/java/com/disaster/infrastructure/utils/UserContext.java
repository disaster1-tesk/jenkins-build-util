package com.disaster.infrastructure.utils;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.stp.StpUtil;
import com.disaster.domain.aggregate.User;

public class UserContext {
    public static User getCurrentUser() {
        if (StpUtil.isLogin()) {
            return StpUtil.getSession().get("user", User::new);
        } else {
            throw new NotLoginException("您还未登录，无法获取当前用户信息！！", NotLoginException.NOT_TOKEN, NotLoginException.NOT_TOKEN);
        }
    }
}

package com.disaster.resource;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.SaLoginModel;
import cn.dev33.satoken.stp.StpUtil;
import com.disaster.domain.aggregate.User;
import com.disaster.domain.share.Result;
import com.disaster.infrastructure.props.EnvProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.UUID;

@RestController
@RequestMapping("/api/operation/platform/account")
public class AccountResource {

    @Autowired
    private EnvProperties envProperties;


    /**
     * 登录接口
     *
     * @param userName
     * @param passWord
     * @return
     */
    @GetMapping("/login")
    public Result login(@RequestParam("userName") @NonNull String userName, @RequestParam("passWord") @NonNull String passWord) {
        if (envProperties.getUsername().equals(userName) && envProperties.getPassword().equals(passWord)) {
            StpUtil.login(userName);
            SaSession session = StpUtil.getSession();
            User user = User.builder()
                    .token(StpUtil.getTokenInfo().getTokenValue())
                    .userName(userName)
                    .passWord(passWord).build();
            session.set("user", user);
            return Result.success(user);
        }
        return Result.fail("login fail");
    }
}

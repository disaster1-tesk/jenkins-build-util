package com.disaster.infrastructure.config;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import cn.dev33.satoken.stp.StpUtil;
import com.disaster.domain.share.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

/**
 * 全局异常处理
 */
@RestControllerAdvice
@Slf4j
@Order(-100)
public class SaTokenExceptionHandler {

    // 全局异常拦截（拦截项目中的NotLoginException异常）
    @ExceptionHandler(NotLoginException.class)
    public Result handlerNotLoginException(NotLoginException nle)
            throws Exception {

        // 打印堆栈，以供调试
        nle.printStackTrace();

        // 判断场景值，定制化异常信息
        String message = "";
        Integer code = -1;
        if (nle.getType().equals(NotLoginException.NOT_TOKEN)) {
            message = "请您先进行登录";
            code = 501;
        } else if (nle.getType().equals(NotLoginException.INVALID_TOKEN)) {
            message = "token无效，请确保您已正确登录";
            code = 502;
        } else if (nle.getType().equals(NotLoginException.TOKEN_TIMEOUT)) {
            message = "您长时间未操作，系统已自动将您退出登录";
            code = 503;
        } else if (nle.getType().equals(NotLoginException.BE_REPLACED)) {
            message = "您的账号已在其他地方登录";
            code = 504;
        } else if (nle.getType().equals(NotLoginException.KICK_OUT)) {
            message = "您已被管理员下线";
            code = 505;
        } else {
            message = "您还未登录";
            code = 506;
        }

        // 返回给前端
        return Result.fail(code, message);
    }



}

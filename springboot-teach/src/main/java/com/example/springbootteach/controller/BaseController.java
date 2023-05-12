package com.example.springbootteach.controller;/*
 * @Author snoopy
 * @Date $ $
 * @Param $

 */


import com.example.springbootteach.common.JsonResult;
import com.example.springbootteach.service.exception.SeException;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {
    public static final int OK = 200;//操作成功状态码

    @ExceptionHandler({SeException.class,DataAccessException.class})
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> result = new JsonResult<Void>(e);
        if (e instanceof DataAccessException) {
            result.setState(4001);
            result.setMessage("违反了数据库的完整性约束");
        }
        if (e instanceof SeException) {
            result.setState(4002);
            result.setMessage(e.getMessage());
        }

        return result;
    }
}

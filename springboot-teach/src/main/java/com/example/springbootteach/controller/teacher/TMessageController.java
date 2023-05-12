package com.example.springbootteach.controller.teacher;/*
 * @Author snoopy
 * @Date $ $
 * @Param $

 */

import com.example.springbootteach.common.JsonResult;
import com.example.springbootteach.controller.BaseController;
import com.example.springbootteach.entity.TClass;
import com.example.springbootteach.entity.TMessage;
import com.example.springbootteach.service.ITMessageService;
import com.example.springbootteach.service.exception.SeException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/springbootteach/t-teacher")
@Api(value = "教师-留言接口", tags = {"教师-留言接口"})
public class TMessageController extends BaseController {
@Autowired
    ITMessageService itMessageService;

    @PostMapping("/mess-resp/{tId}")
    @ApiOperation("教师回复留言")
    public JsonResult<Void> messageResponse(@PathVariable String tId,String responseMessage, HttpSession session) {
        Object tid = session.getAttribute("tid");
        if (tid == null) {
            throw new SeException("请先登录账号");
        }
        //判断是否存在
        TMessage rows = itMessageService.getById(tId);
        if (rows == null) {
            throw new SeException("该留言不存在");
        }
        rows.setResponseMess(responseMessage);
        if (itMessageService.updateById(rows) == true) {
            return new JsonResult<>(OK);
        } else {
            throw new SeException("回复留言失败");
        }
    }
}

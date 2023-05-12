package com.example.springbootteach.controller.student;/*
 * @Author snoopy
 * @Date $ $
 * @Param $

 */

import com.example.springbootteach.common.JsonResult;
import com.example.springbootteach.controller.BaseController;
import com.example.springbootteach.entity.TMessage;
import com.example.springbootteach.service.ITMessageService;
import com.example.springbootteach.service.exception.SeException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/springbootteach/t-student")
@Api(value = "学生-家教留言接口", tags = {"学生-家教留言接口"})
public class SMessageController extends BaseController {
    @Autowired
    ITMessageService itMessageService;

    @PostMapping("/mssage-insert")
    @ApiOperation("预约家教")
    public JsonResult<Void> MessageInsert(TMessage tMessage, HttpSession session) {
        Object sid = session.getAttribute("sid");
        if (sid == null) {
            throw new SeException("请先登录账号");
        }
        tMessage.setSId((Long)sid);
        itMessageService.messageInsert(tMessage);
        return new JsonResult<>(OK);
    }
}

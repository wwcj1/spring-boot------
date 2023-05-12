package com.example.springbootteach.controller.teacher;/*
 * @Author snoopy
 * @Date $ $
 * @Param $

 */

import com.example.springbootteach.common.JsonResult;
import com.example.springbootteach.controller.BaseController;
import com.example.springbootteach.service.ITAppointmentService;
import com.example.springbootteach.service.exception.SeException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/springbootteach/t-teacher")
@Api(value = "教师-预约接口", tags = {"教师-预约接口"})
public class TAppointController extends BaseController {
    @Autowired
    ITAppointmentService itAppointmentService;

    @PostMapping("/appoitment-dispose")
    @ApiOperation("老师处理预约-1为接受-2为拒绝")
    public JsonResult<Void> disposeAppointment(String status,Long appointmentId, HttpSession session) {
        Object tid = session.getAttribute("tid");
        if (tid == null) {
            throw new SeException("请先登录账号");
        }
        itAppointmentService.disposeAppointment((Long)tid,appointmentId,status);
        return new JsonResult<>(OK);
    }
}

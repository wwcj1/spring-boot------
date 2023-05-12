package com.example.springbootteach.controller.student;/*
 * @Author snoopy
 * @Date $ $
 * @Param $

 */

import com.example.springbootteach.common.JsonResult;
import com.example.springbootteach.controller.BaseController;
import com.example.springbootteach.entity.TClass;
import com.example.springbootteach.service.ITClassService;
import com.example.springbootteach.service.exception.SeException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/springbootteach/t-student")
@Api(value = "学生-课程信息接口", tags = {"学生-课程信息接口"})
public class SClassController extends BaseController {
    @Autowired
    ITClassService itClassService;

    @PostMapping("/class-select")
    @ApiOperation("查询全部课程")
    public JsonResult<List<TClass>> selectAllClass(HttpSession session){
        Object sid = session.getAttribute("sid");
        if (sid == null) {
            throw new SeException("请先登录账号");
        }
        JsonResult<List<TClass>> listJsonResult = new JsonResult<>();
        listJsonResult.setData(itClassService.list());
        listJsonResult.setState(OK);
        return listJsonResult;
    }

    @PostMapping("/class-selectMy")
    @ApiOperation("查询学生已经预约课程")
    public JsonResult<List<TClass>> selectMyClass(HttpSession session){
        Object sid = session.getAttribute("sid");
        if (sid == null) {
            throw new SeException("请先登录账号");
        }
        List<TClass> list = itClassService.selectMyClass((Long)sid) ;
        JsonResult<List<TClass>> listJsonResult = new JsonResult<>();
        listJsonResult.setState(OK);
        listJsonResult.setData(list);
        return  listJsonResult;
    }


}

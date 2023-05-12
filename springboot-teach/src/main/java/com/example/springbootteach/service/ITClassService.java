package com.example.springbootteach.service;

import com.example.springbootteach.entity.TAppointment;
import com.example.springbootteach.entity.TClass;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author snoppy
 * @since 2023-05-09
 */
public interface ITClassService extends IService<TClass> {
    public Void updateClass(TClass tClass);    //查询课程

    public List<TClass> selectMyClass(Long sid);    //查询学生的预约课程

    public Void classInsert(TClass tClass);//老师发布课程

    public List<TClass> selectTeacherClass(Long tid);
}

package com.example.springbootteach.service;

import com.example.springbootteach.entity.TTeacher;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author snoppy
 * @since 2023-05-09
 */
public interface ITTeacherService extends IService<TTeacher> {
    public boolean getByName(String name);//根据名字判断是否存在
    public Void updateTeacher(TTeacher tTeacher);//修改老师
    public List<TTeacher> selectMyTeacher(Long sid);//查看已经预约的老师
    public void login(String name, String password , HttpSession session);//教师登录
    public void register(TTeacher tTeacher);//教师注册

}

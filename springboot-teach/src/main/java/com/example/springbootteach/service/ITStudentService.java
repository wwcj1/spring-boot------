package com.example.springbootteach.service;

import com.example.springbootteach.entity.TStudent;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootteach.entity.TTeacher;

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
public interface ITStudentService extends IService<TStudent> {
  public boolean getByName(String name);//根据名字判断是否存在
  public void updateStudent(TStudent tStudent);//修改学生
  public void login(String name, String password , HttpSession session);//学生登录
  public void register(TStudent tStudent);//学生注册
  public List<TStudent> selectMyStudent(Long tid);
}

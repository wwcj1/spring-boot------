package com.example.springbootteach.service.impl;

import com.example.springbootteach.entity.TAppointment;
import com.example.springbootteach.entity.TStudent;
import com.example.springbootteach.entity.TTeacher;
import com.example.springbootteach.mapper.TAppointmentMapper;
import com.example.springbootteach.mapper.TStudentMapper;
import com.example.springbootteach.service.ITStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootteach.service.exception.SeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author snoppy
 * @since 2023-05-09
 */
@Service
public class TStudentServiceImpl extends ServiceImpl<TStudentMapper, TStudent> implements ITStudentService {
    @Autowired
    TStudentMapper tStudentMapper;
    @Autowired
    TAppointmentMapper tAppointmentMapper;
    //根据用户名查看学生是否存在
    @Override
    public boolean getByName(String name) {
        TStudent rows = tStudentMapper.getByName(name);
        if(rows!=null){
            return true;
        }
        return false;
    }

    //修改学生信息
    @Override
    public void updateStudent(TStudent tStudent) {
        TStudent rows= getById(tStudent.getId());
        if(rows==null){
            throw new SeException("该用户不存在");
        }else {
            Integer integer = tStudentMapper.updateById(tStudent);
            if(integer!=1){
                throw new SeException("修改学生异常");
            }
        }
    }

    //学生登录功能
    @Override
    public void login(String name, String password, HttpSession session) {
        TStudent result = tStudentMapper.getByName(name);
        if(result==null){
            throw new SeException("该用户不存在");
        }
        if(password.equals(result.getPassword())){
            session.setAttribute("sid",result.getId());
        }else{
            throw new SeException("密码错误");
        }
    }

    @Override
    public void register(TStudent tStudent) {
        String name = tStudent.getName();
        TStudent byName = tStudentMapper.getByName(name);
        if(byName!=null){
            throw new SeException("用户名已经存在");
        }
        int insert = tStudentMapper.insert(tStudent);
        if(insert!=1){
            throw  new SeException("注册失败");
        }
    }

    @Override
    public List<TStudent> selectMyStudent(Long tid) {
        List<TAppointment> tAppointments = tAppointmentMapper.selectByTId(tid);
        List<TStudent> listStudent=new ArrayList<>();
        for (TAppointment tAppointment : tAppointments) {
            Long sId = tAppointment.getSId();
            TStudent tStudent = tStudentMapper.selectById(sId);
            listStudent.add(tStudent);
        }
        return listStudent;
    }
}

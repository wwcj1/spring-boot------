package com.example.springbootteach.service.impl;

import com.example.springbootteach.entity.TAppointment;
import com.example.springbootteach.entity.TClass;
import com.example.springbootteach.entity.TStudent;
import com.example.springbootteach.mapper.TAppointmentMapper;
import com.example.springbootteach.mapper.TClassMapper;
import com.example.springbootteach.mapper.TStudentMapper;
import com.example.springbootteach.service.ITAppointmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootteach.service.exception.SeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author snoppy
 * @since 2023-05-09
 */
@Service
public class TAppointmentServiceImpl extends ServiceImpl<TAppointmentMapper, TAppointment> implements ITAppointmentService {
    @Autowired
    TAppointmentMapper tAppointmentMapper;
    @Autowired
    TClassMapper tClassMapper;
    @Override
    public void appointmentInsert(TAppointment tAppointment) {
        Long cId = tAppointment.getCId();
        //修改课程的状态为已预约
        TClass tClass = tClassMapper.selectById(cId);
        tClass.setStatus("1");
        tClassMapper.updateById(tClass);
        //根据课程id获得老师id
        Long tId = tClass.getTId();
        tAppointment.setTId(tId);
        int insert = tAppointmentMapper.insert(tAppointment);
        if(insert!=1){
            throw new SeException("预约家教失败");
        }

    }

    @Override
    public void disposeAppointment(Long tId,Long appointmentId,String status) {
        TAppointment tAppointment = tAppointmentMapper.selectById(appointmentId);
        tAppointment.setStatus(status);
        int i = tAppointmentMapper.updateById(tAppointment);
        if(i!=1){
            throw new SeException("出现教师处理预约异常");
        }
    }
}

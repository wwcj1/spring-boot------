package com.example.springbootteach.service;

import com.example.springbootteach.entity.TAppointment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootteach.entity.TStudent;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author snoppy
 * @since 2023-05-09
 */
public interface ITAppointmentService extends IService<TAppointment> {
   public void appointmentInsert(TAppointment tAppointment);//发布预约
   public void disposeAppointment(Long tId,Long appointmentId,String status);//老师处理学生预约
}

package com.example.springbootteach.service;

import com.example.springbootteach.entity.TMessage;
import com.example.springbootteach.entity.TMessage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author snoppy
 * @since 2023-05-09
 */
public interface ITMessageService extends IService<TMessage> {
    public void messageInsert(TMessage tMessage);

}

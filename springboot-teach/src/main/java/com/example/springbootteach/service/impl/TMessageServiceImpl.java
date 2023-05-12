package com.example.springbootteach.service.impl;

import com.example.springbootteach.entity.TMessage;
import com.example.springbootteach.entity.TMessage;
import com.example.springbootteach.mapper.TMessageMapper;
import com.example.springbootteach.mapper.TMessageMapper;
import com.example.springbootteach.service.ITMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootteach.service.exception.SeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author snoppy
 * @since 2023-05-09
 */
@Service
public class TMessageServiceImpl extends ServiceImpl<TMessageMapper, TMessage> implements ITMessageService {
    @Autowired
    TMessageMapper tMessageMapper;

    @Override
    public void messageInsert(TMessage tMessage) {
        int insert = tMessageMapper.insert(tMessage);
        if(insert!=1){
            throw new SeException("留言失败");
        }

    }

}

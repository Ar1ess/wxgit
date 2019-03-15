package com.softlab.wx.service.impl;

import com.softlab.wx.core.mapper.TimeMapper;
import com.softlab.wx.core.model.vo.Time;
import com.softlab.wx.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeServiceImpl implements TimeService {
    @Autowired
    private TimeMapper timeMapper;

    @Override
    public Time selectAllByUsername(String userName){
        return timeMapper.selectAllByUsername(userName);
    }

    @Override
    public int selectByUsername(String userName) {

        return timeMapper.selectByUsername(userName);
    }

    @Override
    public void insert(Time time) {
        timeMapper.insert(time);
    }
}

package com.softlab.wx.service;

import com.softlab.wx.core.model.vo.Time;

public interface TimeService {

    Time selectAllByUsername(String userName);

    int selectByUsername(String userName);

    void insert(Time time);
}

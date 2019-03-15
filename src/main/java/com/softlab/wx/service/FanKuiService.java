package com.softlab.wx.service;

import com.softlab.wx.core.model.vo.FanKui;

public interface FanKuiService {
    /**
     * 添加反馈数据
     * @param fanKui
     * @return
     */
    boolean addFanKui(FanKui fanKui);
}

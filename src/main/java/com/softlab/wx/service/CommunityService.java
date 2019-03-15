package com.softlab.wx.service;

import com.softlab.wx.common.WxException;
import com.softlab.wx.core.model.vo.Community;

import java.util.List;
import java.util.Map;

public interface CommunityService {
    /**
     * 根据文章systemId获取文章详情
     *
     */
    Map<String, Object> getCommunityDetailByCommunitySystemId(Community community) throws WxException;

    /**
     *打印出所有文章
     *
     */
    List<Map<String, Object>> getAllCommunity() throws WxException;

    /**
     * 发布文章
     *
     */

    boolean insertCommunity(Community community) throws  WxException;


}

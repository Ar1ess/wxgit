package com.softlab.wx.service.impl;

import com.softlab.wx.common.WxException;
import com.softlab.wx.core.mapper.CommunityMapper;
import com.softlab.wx.core.model.vo.Community;
import com.softlab.wx.service.CommunityService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommunityServiceImpl implements CommunityService {

    private final CommunityMapper communityMapper;

    public CommunityServiceImpl (CommunityMapper communityMapper) {
        this.communityMapper = communityMapper;
    }

    @Override
    public Map<String, Object> getCommunityDetailByCommunitySystemId(Community community) throws WxException {
        Map<String, Object> map = new HashMap<>(8);
        if (null != community && null != community.getSystemId()){
            List<Community> communityList = communityMapper.selectCommunityByCondition(community);
            if (null != communityList && 1 == communityList.size()){
                community = communityList.get(0);
                map.put("systemId", community.getSystemId());
                map.put("title", community.getTitle());
                map.put("writer", community.getWriter());
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                map.put("time", formatter.format(community.getTime()));
                map.put("content", community.getContent());
                map.put("pic", community.getPic());
                map.put("viewsNumber", community.getViewsNumber());
                map.put("likesNumber", community.getLikesNumber());
                map.put("commentsNumber", community.getCommentsNumber());
            }
        }
        else{
            throw new WxException("系统异常!");

        }
        return map;
    }

    @Override
    public List<Map<String, Object>> getAllCommunity() throws WxException{
        List<Map<String, Object>> al = new ArrayList<>();
        Community community = new Community();
        List<Community> communityList = communityMapper.selectAllCommunity();
        if (null != communityList){
            for (Community community1 : communityList){
                Map<String, Object> map = new HashMap<>(8);
                map.put("writer", community1.getWriter());
                map.put("title", community1.getTitle());
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                map.put("time", formatter.format(community1.getTime()));
                map.put("viewsNumber", community1.getViewsNumber());
                al.add(map);
            }
            return al;
        }
        else{
            throw new WxException("系统异常!");
        }

    }



    @Override
    public boolean insertCommunity(Community community) throws WxException {
        boolean flag = false;
        if (null != community){
            community.setTitle("'" + community.getTitle() + "'");
            community.setContent("'" + community.getContent() + "'");
            community.setPic("'" + community.getPic() + "'");
            int success = communityMapper.insertCommunity(community);
            if (0 < success){
                flag =true;
            }
        } else {
            throw new WxException("系统异常!");
        }
        return flag;
    }

}


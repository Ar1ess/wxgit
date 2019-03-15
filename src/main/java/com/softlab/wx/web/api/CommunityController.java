package com.softlab.wx.web.api;

import com.softlab.wx.common.RestData;
import com.softlab.wx.common.WxException;
import com.softlab.wx.core.model.vo.Community;
import com.softlab.wx.service.CommunityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RestController
public class CommunityController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final CommunityService communityService;

    @Autowired
    public CommunityController(CommunityService communityService) {
        this.communityService = communityService;
    }

    @RequestMapping(value = "/detail/{systemId}", method = RequestMethod.GET)
    public RestData getCommunityDetailByCommunitySystemId(@PathVariable(value = "systemId") Integer systemId, HttpServletRequest request) {
        //logger.info("getCommunityDetailBySystemId : ");
        try {
            Community community = new Community();
            community.setSystemId(systemId);
            Map<String, Object> data = communityService. getCommunityDetailByCommunitySystemId(community);
            return new RestData(data);
        } catch (WxException e) {
            return new RestData(1, e.getMessage());
        }
    }


    @RequestMapping(value = "/community", method = RequestMethod.GET)
    public RestData getAllCommunity( HttpServletRequest request) {
        //logger.info("getAllCommunity : ");
        try {
            List<Map<String, Object>> data = communityService. getAllCommunity();
            return new RestData(data);
        } catch (WxException e) {
            return new RestData(1, e.getMessage());
        }
    }



    @RequestMapping(value = "/post", method =  RequestMethod.POST)
    public RestData insertCommunity (@RequestBody(required = false) Community community, HttpServletRequest request){
        //logger.info(" insertCommunity: ");
        try {
            boolean flag = communityService.insertCommunity(community);
            return new RestData(flag);
        } catch (WxException e) {
            return new RestData(5,e.getMessage());
        }
    }
}


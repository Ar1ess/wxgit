package com.softlab.wx.core.mapper.provider;


import com.softlab.wx.core.model.vo.Community;
import org.apache.ibatis.jdbc.SQL;

/**
 * author Aries
 * date 2019-3-13
 */

public class CommunityProvider {

    public String selectCommunityByCondition(Community community){
        return new SQL() {
            {
                SELECT("community_systemId as systemId, community_title as title, community_writer as writer, " +
                        "community_pic as pic, community_time as time, community_content as content, " +
                        "community_viewsNumber as viewsNumber, community_likesNumber as likesNumber, " +
                        "community_commentsNumber as commentsNumber");
                FROM("community_article");
                if (null != community.getSystemId()) {
                    WHERE("community_systemId=#{systemId}");
                }
                if (null != community.getTitle()) {
                    WHERE("community_title=#{title}");
                }
                if (null != community.getWriter()) {
                    WHERE("community_writerId=#{writerId}");
                }
            }
        }.toString();
    }

    public String selectAllCommunity(){
        return new SQL() {
            {
                SELECT("community_systemId as systemId, community_title as title, community_writer as writer, " +
                        "community_pic as pic, community_time as time, community_content as content, " +
                        "community_viewsNumber as viewsNumber, community_likesNumber as likesNumber, " +
                        "community_commentsNumber as commentsNumber");
                FROM("community_article");
            }
        }.toString();
    }



    public String insertCommunity(Community community){
        return new SQL(){
            {
                INSERT_INTO("community_article");
                if (null != community.getWriter() && null != community.getPic()){
                    VALUES("community_writer", community.getWriter());
                    VALUES("community_pic", community.getPic());
                    if (null != community.getTitle()){
                        VALUES("community_title", community.getTitle());
                    }
                    if (null != community.getContent()){
                        VALUES("communtiy_content", community.getContent());
                    }
                }
            }
        }.toString();
    }


}

package com.softlab.wx.core.mapper;

import com.softlab.wx.core.mapper.provider.CommunityProvider;
import com.softlab.wx.core.model.vo.Community;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author Aries
 * date 2019-3-13
 */

@Mapper
@Repository
public interface CommunityMapper {

    /**
     * 获取文章详情
     */

    @SelectProvider(type = CommunityProvider.class, method = "selectCommunityByCondition")
    List<Community> selectCommunityByCondition(Community community);


    /**
     * 获取所有文章
     */
    @SelectProvider(type = CommunityProvider.class, method = "selectAllCommunity")
    List<Community> selectAllCommunity();


    /**
     * 发布帖子
     */
    //@InsertProvider(type = CommunityProvider.class, method = "insertCommunity")
    @Insert("INSERT INTO community_article(community_title, community_content,community_writer,community_pic) VALUES (#{title}, #{content},#{writer},#{pic})" )
    int insertCommunity(Community community);



}

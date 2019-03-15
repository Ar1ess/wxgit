package com.softlab.wx.core.mapper;

import com.softlab.wx.core.model.vo.Time;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TimeMapper {

    @Select("SELECT COUNT(*) FROM time WHERE username=#{userName}")
    int selectByUsername(@Param("userName") String userName);

    @Select("SELECT * FROM time WHERE username=#{userName}")
    Time selectAllByUsername(@Param("userName") String userName);

    @Insert("INSERT INTO time (username,time)VALUES(#{userName},#{time})")
    void insert(Time time);
}

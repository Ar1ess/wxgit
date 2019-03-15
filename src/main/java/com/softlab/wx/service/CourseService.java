package com.softlab.wx.service;

import com.softlab.wx.core.model.vo.Course;

import java.util.List;

public interface CourseService {
    List<Course> selectByOrder();
    Course selectByCourse(String course);
    boolean add(String course,int count);
}

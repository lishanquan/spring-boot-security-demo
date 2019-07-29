package com.daniel.springbootsecurity.service;

import com.daniel.springbootsecurity.model.Blog;

import java.util.List;

/**
 * @Author: Daniel
 * @Date: 2019/7/26 19:35
 */
public interface IBlogService {

    List<Blog> getBlogs();

    void deleteBlog(long id);

}

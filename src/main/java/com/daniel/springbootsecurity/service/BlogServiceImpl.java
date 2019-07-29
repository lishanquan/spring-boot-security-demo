package com.daniel.springbootsecurity.service;

import com.daniel.springbootsecurity.model.Blog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: Daniel
 * @Date: 2019/7/26 19:36
 */
@Service
public class BlogServiceImpl implements IBlogService {

    private List<Blog> list = new ArrayList<>();

    public BlogServiceImpl(){
        list.add(new Blog(1L, "Spring In Action", "good!"));
        list.add(new Blog(2L, "Spring Boot In Action", "nice!"));
    }

    @Override
    public List<Blog> getBlogs() {
        return list;
    }

    @Override
    public void deleteBlog(long id) {
        Iterator it = list.iterator();
        while (it.hasNext()){
            Blog blog = (Blog) it.next();
            if (blog.getId() == id){
                it.remove();
            }
        }
    }
}

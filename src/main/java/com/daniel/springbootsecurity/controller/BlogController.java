package com.daniel.springbootsecurity.controller;

import com.daniel.springbootsecurity.model.Blog;
import com.daniel.springbootsecurity.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author: Daniel
 * @Date: 2019/7/26 19:41
 */
@RestController
@RequestMapping("blogs")
public class BlogController {

    @Autowired
    IBlogService blogService;

    @GetMapping("list")
    public ModelAndView list(Model model){
        List<Blog> blogs = blogService.getBlogs();
        model.addAttribute("blogsList", blogs);
        return new ModelAndView("blogs/list", "blogModel", model);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/{id}/deletion")
    public ModelAndView delete(@PathVariable("id") Long id, Model model){
        blogService.deleteBlog(id);
        model.addAttribute("blogsList", blogService.getBlogs());
        return new ModelAndView("blogs/list", "blogModel", model);
    }

}

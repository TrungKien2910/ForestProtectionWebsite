package com.stringboot.BaoVeRung.controller;

import com.stringboot.BaoVeRung.dto.BlogDTO;
import com.stringboot.BaoVeRung.entity.Blog;
import com.stringboot.BaoVeRung.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    private BlogService blogService;
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/list-blog")
    public String listBlog(Model model) {
        List<BlogDTO> blogs = blogService.findAll();
        model.addAttribute("blogs",blogs);
        System.out.println(blogs);
        return "blog";
    }

    @GetMapping("/blog")
    public String detailEvent(@RequestParam("id") int id, Model model) {
        BlogDTO blog = blogService.findById(id);
        model.addAttribute("blog",blog);
        return "blog-detail";
    }

    @GetMapping("/blog-form-insert")
    public String formInsert(Model model) {
        Blog blog = new Blog();
        model.addAttribute("blog",blog);
        System.out.println(blog);
        return "blog-form-insert";
    }
    @PostMapping("/save")
    public String save(Blog blog) {
        blogService.save(blog);
        return "redirect:/blogs/list-blog";
    }

    @GetMapping("/blog-form-update")
    public String formUpdate(Model model) {
        Blog blog = new Blog();
        model.addAttribute("blog",blog);
        return "blog-form-update";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        blogService.deleteById(id);
        return "redirect:/blogs/list-blog";
    }

}

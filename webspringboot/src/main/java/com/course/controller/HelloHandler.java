package com.course.controller;

import com.course.entity.Student;
import com.course.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloHandler {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("list",studentRepository.findAll());
        return modelAndView;
    }

    @GetMapping("deleteById/{id}")
    public String deleteById(@PathVariable("id") long id){
        studentRepository.deleteById(id);
        //重定向,跳转到index方法
        return "redirect:/hello/index";
    }

    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id") long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("update");
        modelAndView.addObject("student",studentRepository.findById(id));
        return modelAndView;
    }

    @PostMapping("/update")
    public String updateStu(Student student){
        studentRepository.update(student);
        return "redirect:/hello/index";
    }

    @PostMapping(value = "/save")
    public String save(Student student){
        studentRepository.save(student);
        return "redirect:/hello/index";
    }
}

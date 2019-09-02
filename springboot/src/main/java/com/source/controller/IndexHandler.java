package com.source.controller;

import com.source.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/index")
public class IndexHandler {

    //访问index.html页面
    @GetMapping("/hello")
    public String index(Model model){
        System.out.println("index...");
        List<Student> list = new ArrayList<>();
        list.add(new Student(1L,"zhangsan",23));
        list.add(new Student(2L,"wangwu",24));
        list.add(new Student(3L,"liliu",25));
        model.addAttribute("list",list);
        return "index";
    }

    @GetMapping("/index2")
    public String index2(Map<String,String> map){
        map.put("name","张三");
        return "index";
    }

    @GetMapping("/if")
    public String ifResult(Map<String,Boolean> map){
        map.put("flag",true);
        return "index";
    }

    @GetMapping("/url")
    public String url(Model model){
        model.addAttribute("name","tom");
        return "index";
    }

    @GetMapping("/url/{path}")
    @ResponseBody
    public String returnUrl(@PathVariable("path") String path){
        return path;
    }

    //thymeleaf的src
    @GetMapping("/img")
    public String img(Model model){
        model.addAttribute("src","http://pic.sc.chinaz.com/files/pic/pic9/201503/apic10695.jpg");
        return "index";
    }

    //thymeleaf的三元运算
    @GetMapping("/eq")
    public String eq(Model model){
        model.addAttribute("age",30);
        return "index";
    }
    //thymeleaf的switch判断
    @GetMapping("/switch")
    public String switchCase(Model model){
        model.addAttribute("gender","女");
        return "index";
    }

    @GetMapping("/object")
    public String object(HttpServletRequest request){
        request.setAttribute("request","request对象");
        request.getSession().setAttribute("session","session对象");
        return "index";
    }

    @GetMapping("/util")
    public String util(Model model){
        model.addAttribute("name","zhangsan");
        model.addAttribute("user",new ArrayList<>());
        model.addAttribute("count",22);
        model.addAttribute("date",new Date());
        return "index";
    }
}

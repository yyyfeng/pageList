package com.yingf.study.controller;

import com.yingf.study.dao.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class JspController {

    @RequestMapping("jspIndex")
    public String jspIndex(Integer page,Integer rows,Model model) {
        System.out.println("page:"+page+"---rows:"+rows);
        List<User> list  = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                User user = new User();
                user.setSex(0);
                user.setAge(i);
                user.setName("yingfeng" + i);
                list.add(user);
            }
            for (User u :list                 ) {
                System.out.println("-------"+u.getName());
            }
            model.addAttribute("list",list);
            return "jspIndex";
    }
}

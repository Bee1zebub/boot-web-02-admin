package com.atguigu.admin.controller;

import com.atguigu.admin.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class IndexController {
    /**
     * 来登录页
     * @return
     */
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/sql")
    @ResponseBody
    public String queryFromDb(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from user", Long.class);
        return aLong.toString();
    }

    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        if(StringUtils.hasText(user.getUserName()) && "123".equals(user.getPassword())){
            //登录成功的用户存起来
            session.setAttribute("loginUser",user);
            //登录成功。重定向，无需重新提交表单
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","账号密码错误");
            //回到登录页面
            return "login";
        }

    }

    /**
     * 去main页面
     * @return
     */
    @GetMapping(value={"/main.html","main"})
    public String mainPage(HttpSession session,Model model){
        //log.info("当前处理器方法是","mainPage");
        /*if (session.getAttribute("loginUser")!=null) {
            return "main";
        }else {
            //回到登录页面
            model.addAttribute("msg","请重新登录");
            return "login";
        }*/
        return "main";
    }
}

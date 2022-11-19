package com.atguigu.admin.controller;

import com.atguigu.admin.bean.User;
import com.atguigu.admin.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
public class TableController {

    @Autowired
    UserService userService;

    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn",defaultValue = "1")Integer pn
                                ,Model model){
      /*  //表格内容的遍历
        List<User> users = Arrays.asList(new User("zhangsan", "123456"),
                new User("lisi", "123444"),
                new User("haha", "aaaaa"),
                new User("hehe ", "aaddd"));
        model.addAttribute("users",users);*/

        /*//分页查询的查询数据不能便利该对象
        //从数据库中查出user表中的用户进行展示
        List<User> list = userService.list();
        model.addAttribute("users",list);*/

        //分页查询数据
        Page<User> userPage = new Page<>(pn, 2);
        model.addAttribute("pn",pn);
        //分页查询结果为Page对象
        Page<User> page = userService.page(userPage, null);

        //为model里放入分页相关的信息，如t总数，总页数，当前页
        long total = page.getTotal();
        long pages = page.getPages();
        long current = page.getCurrent();
        //log.info("total:{},pages:{},current:{}",total,pages,current);
        model.addAttribute("users",page);

        return "table/dynamic_table";
    }

    @GetMapping("user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam("pn") Long pn,
                             RedirectAttributes redirectAttributes){
        userService.removeById(id);
        //使用RedirectAttributes为重定向携带参数
        redirectAttributes.addAttribute("pn",pn);
        return "redirect:/dynamic_table";
    }

    @GetMapping("/basic_table")
    public String basic_table(){
        //int i =10/0;
        return "table/basic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }
}

package com.atguigu.admin.controller;

import com.atguigu.admin.bean.Account;
import com.atguigu.admin.bean.City;
import com.atguigu.admin.service.AccountService;
import com.atguigu.admin.service.CityService;;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class MybatisTestController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private CityService cityServiceImpl;

    @GetMapping("/getAcct")
    @ResponseBody
    public Account getById(@RequestParam("id") Long id){
        //log.info("getById()方法内------");
        return accountService.getAcct(id);
    }

    @GetMapping("/city")
    @ResponseBody
    public City getCityById(@RequestParam("id") Long id){
        return cityServiceImpl.getCity(id);
    }

    @PostMapping("/city")
    @ResponseBody
    public City setCity(City city){
        cityServiceImpl.setCity(city);
        return city;
    }
}

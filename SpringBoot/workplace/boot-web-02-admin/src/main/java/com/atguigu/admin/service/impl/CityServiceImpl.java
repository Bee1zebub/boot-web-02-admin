package com.atguigu.admin.service.impl;

import com.atguigu.admin.bean.City;
import com.atguigu.admin.mapper.CityMapper;
import com.atguigu.admin.service.CityService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityMapper cityMapper;

    Counter counter;

    public CityServiceImpl(MeterRegistry registry){
        counter = registry.counter("CityService.getCity.count");
    }


    public City getCity(Long id){
        counter.increment();
        return cityMapper.getrCity(id);
    }

    public void setCity(City city) {
        cityMapper.insert(city);
    }
}

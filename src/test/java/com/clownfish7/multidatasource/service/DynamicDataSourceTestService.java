/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.clownfish7.multidatasource.service;

import com.clownfish7.multidatasource.dao.MyDao;
import com.clownfish7.multidatasource.datasource.annotation.DataSource;
import com.clownfish7.multidatasource.datasource.config.DynamicContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 测试多数据源
 *
 * @author Mark sunlightcs@gmail.com
 */
@Service
//@DataSource("slave1")
public class DynamicDataSourceTestService {

    @Autowired
    private MyDao dao;

    @Transactional
    public void updateUser(Long id){
        System.out.println("updateUserBydefault");
        dao.insert();
        System.out.println(DynamicContextHolder.peek());
    }

    @Transactional
    @DataSource("slave1")
    public void updateUserBySlave1(Long id){
        System.out.println("updateUserBySlave1");
        dao.insert();
        System.out.println(DynamicContextHolder.peek());
    }

    @DataSource("slave2")
    @Transactional
    public void updateUserBySlave2(Long id){
        System.out.println("updateUserBySlave2");
        dao.insert();
        System.out.println(DynamicContextHolder.peek());
        //测试事物
        int i = 1/0;
    }
}
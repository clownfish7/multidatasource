package com.clownfish7.multidatasource.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author You
 * @create 2019-07-15 22:43
 */
@Mapper
public interface MyDao {
    @Insert("insert into d values ('9',9,9)")
    public void insert();
}

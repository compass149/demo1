package com.pgm.springdemo.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
    @Select("select now()")
    String getTime(); //인터페이스 앞에는 public abstract이 생략됨(인터페이스는 추상메소드를 가짐)

    @Select("select count(*) from test_tbl")
    int getCount();
}

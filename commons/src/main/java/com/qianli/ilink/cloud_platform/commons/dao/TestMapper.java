package com.qianli.ilink.cloud_platform.commons.dao;

import org.apache.ibatis.annotations.Select;


public interface TestMapper {

    @Select("select count(1) from act_id_info")
    int count();

}

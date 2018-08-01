package com.qianli.ilink.cloud_platform.commons;

import com.qianli.ilink.cloud_platform.commons.dao.TestMapper;
import org.junit.Test;

import javax.annotation.Resource;

public class DaoTest extends BaseTest{

    @Resource
    private TestMapper testMapper;

    @Test
    public void count(){
        int count = testMapper.count();
        System.out.println(count);
    }

}

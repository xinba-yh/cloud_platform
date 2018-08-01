package com.qianli.ilink.cloud_platform.messagecenter;

import com.qianli.ilink.cloud_platform.messagecenter.dao.TestMapper;
import org.junit.Test;

import javax.annotation.Resource;

public class DaoTest extends BaseTest{

    @Resource
    private TestMapper testMapper;
    @Test
    public void count(){

        System.out.println(testMapper.count());
    }


}

package com.qianli.ilink.cloud_platform.commons.core.dao;

import java.util.List;

/**
 * 所有dao层顶层接口,需继承该接口
 * @param <T> 对应实体类
 */
public interface BastMapper<T> {

    int count();

    List<T> getList();

    T getById(long id);

    default List<T> getBy(T t){
        throw new UnsupportedOperationException("this operation is not supported");
    }

    default T getUniqueBy(T t){
        throw new UnsupportedOperationException("this operation is not supported");
    }

}

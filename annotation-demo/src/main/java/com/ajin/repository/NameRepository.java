package com.ajin.repository;

import com.ajin.annotation.StringRepository;

import java.util.Arrays;
import java.util.List;

/**
 * @author ajin
 */
@StringRepository
public class NameRepository {

    /**
     * 查找所有的名字
     * */
    public List<String> findAll(){
        return Arrays.asList("张三","李四","赵武");
    }
}

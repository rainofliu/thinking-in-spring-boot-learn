package com.ajin.thinkinginspringboot.annotationdesign.conditional;

/**
 * 计算服务接口
 *
 * @author ajin
 */
public interface CalculatingService {

    /**
     * 累加求和
     *
     * @param values 多个累加值
     * @return 累加结果
     */
    Integer sum(Integer... values);
}

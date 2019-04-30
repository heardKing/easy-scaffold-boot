package com.cuixx.es.common.entity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

/**
 * <p> 抽象实体基类，提供统一的ID，和相关的基本功能方法
 */
public abstract class BaseEntity<ID extends Serializable> {

    private ID id;

}

package com.qiyun.util;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * redis连接池配置文件包装类
 *
 * @author daxiong
 *         date: 2017/03/07 11:51
 */
public class GenericObjectPoolConfigWrapper extends GenericObjectPoolConfig {

    public GenericObjectPoolConfig getConfig() {
        return this;
    }

}

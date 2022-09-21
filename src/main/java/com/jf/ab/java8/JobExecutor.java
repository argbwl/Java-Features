package com.jf.ab.java8;

import java.util.Map;

/**
 * Java-Features
 * argbwl
 * 21/09/22
 **/

@FunctionalInterface
public interface JobExecutor {

    public String executeJob(String jobName, Map<String, String> params);

}

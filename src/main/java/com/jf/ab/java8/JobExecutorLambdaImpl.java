package com.jf.ab.java8;

import java.util.HashMap;
import java.util.Map;

/**
 * Java-Features
 * argbwl
 * 21/09/22
 **/

public class JobExecutorLambdaImpl {

    private static final String DEFAULT_FREQUENCY_EVERY_HOUR = "0 0 * * * *";

    private Map<String, String> params = new HashMap<>();

    public void addDetailsIntoMap(String key, String value, boolean override){
        if(override)
            params.compute(key,(k,v) -> value);
        else
            params.compute(key,(k,v) -> v!=null ? v : value);
    }

    public String executeJob(String jobName){
        JobExecutor executor = ((job, paramMap) -> {
            //TODO implement job to execute based on frequency set in map
            return jobName +":"+paramMap.getOrDefault(job.toUpperCase(),DEFAULT_FREQUENCY_EVERY_HOUR);
        });
        return executor.executeJob(jobName, params);
    }

    public Map<String, String> getMapDetails(){
        return this.params;
    }

    public static void main(String[] args) {
        JobExecutorLambdaImpl le = new JobExecutorLambdaImpl();
        le.addDetailsIntoMap("10S", "*/10 * * * * *", false);
        le.addDetailsIntoMap("01JAN", "0 0 0 01 01 ?", false);
        System.out.println(le.executeJob("10s"));
    }

}

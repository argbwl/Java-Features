package com.jf.ab.java8;

import com.jf.ab.impl.*;
import com.jf.ab.po.MatcherPO;

import java.util.HashMap;
import java.util.Map;

/**
 * Java-Features
 * argbwl
 * 21/09/22
 **/

public class MatchFinderLambdaImpl {

    private static final Map<String, MatchInterface> mapInterFaceMap = new HashMap<>();

    public MatchInterface findMatcherImpl(MatcherPO matcherPO) throws ClassNotFoundException {
        IMatchFinder finder = mPO ->{
            MatchInterface mi = null;
            String jobName = IMatchFinder.getMatchPODetails()
                                         .stream()
                                         .filter(mp -> mp.isJobRunningStatus() && mp.getJobName().equals(matcherPO.getJobName()))
                                         .findAny()
                                         .orElseGet(MatcherPO::new).getJobName();

            if(jobName!=null) mi = loadAndGetMatchInterfaceMap(jobName.toUpperCase());
            else throw new ClassNotFoundException("No Class Found for "+matcherPO.getJobName());
            return mi;
        };
        return finder.findClassByArg(matcherPO);
    }

    private MatchInterface loadAndGetMatchInterfaceMap(String key){
        mapInterFaceMap.compute("DAILY",(k,v) -> v!=null ? v : new DailyMatcherImpl());
        mapInterFaceMap.compute("HOURLY",(k,v) -> v!=null ? v : new HourlyMatcherImpl());
        mapInterFaceMap.compute("MONTHLY",(k,v) -> v!=null ? v : new MonthlyMatcherImpl());
        mapInterFaceMap.compute("YEARLY",(k,v) -> v!=null ? v : new YearlyMatcherImpl());
        mapInterFaceMap.compute("WEEKLY",(k,v) -> v!=null ? v : new WeeklyMatcherImpl());
        return mapInterFaceMap.get(key);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        MatchFinderLambdaImpl impl = new MatchFinderLambdaImpl();
        MatcherPO matcherPO = MatcherPO.builder().jobName("WEEKLY").jobFrequency("XYXD").jobRunningStatus(true).build();
        impl.findMatcherImpl(matcherPO).execute();
    }

}

package com.jf.ab.java8;

import com.jf.ab.impl.MatchInterface;
import com.jf.ab.po.MatcherPO;

import java.util.Arrays;
import java.util.List;

/**
 * Java-Features
 * argbwl
 * 21/09/22
 **/

public interface IMatchFinder {

    public MatchInterface findClassByArg(MatcherPO matcherPO) throws ClassNotFoundException;

    static List<MatcherPO> getMatchPODetails() {
        return Arrays.asList(
                MatcherPO.builder().jobName("DAILY").jobFrequency("XYXD").jobRunningStatus(true).build(),
                MatcherPO.builder().jobName("WEEKLY").jobFrequency("XYXW").jobRunningStatus(true).build(),
                MatcherPO.builder().jobName("MONTHLY").jobFrequency("XYXM").jobRunningStatus(false).build(),
                MatcherPO.builder().jobName("YEARLY").jobFrequency("XYXY").jobRunningStatus(true).build(),
                MatcherPO.builder().jobName("HOURLY").jobFrequency("XYXH").jobRunningStatus(false).build()
        );
    }

}

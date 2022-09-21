package com.jf.ab.po;

import lombok.*;

/**
 * Java-Features
 * argbwl
 * 21/09/22
 **/

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(includeFieldNames = true)
public class MatcherPO {

    private String jobName;
    private String jobFrequency;
    private boolean jobRunningStatus;

}

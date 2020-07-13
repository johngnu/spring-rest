package com.rootnite.fastdelivery.microwsdms.util;

import lombok.Builder;

import java.util.Date;

@Builder
public class ResultResponse {
    @Builder.Default
    private Date timestamp = new Date();
    private boolean status;
    private String message;
    private Object data;
}

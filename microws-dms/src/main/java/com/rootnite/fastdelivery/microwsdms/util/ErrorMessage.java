package com.rootnite.fastdelivery.microwsdms.util;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorMessage {
    private String message;
    private String details;
}

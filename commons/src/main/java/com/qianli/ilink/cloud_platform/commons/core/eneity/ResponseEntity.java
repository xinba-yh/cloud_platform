package com.qianli.ilink.cloud_platform.commons.core.eneity;

import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class ResponseEntity implements BaseEntity{

    private static final long serialVersionUID = 6207164949397687726L;

    private Object data;

    private Integer errorCode;

    private String msg;

    private String details;

}

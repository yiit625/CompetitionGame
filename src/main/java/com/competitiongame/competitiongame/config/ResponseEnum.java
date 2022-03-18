package com.competitiongame.competitiongame.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ResponseEnum {
    OK(200, "OK", Boolean.TRUE, ""),
    BADREQUEST(400, "BADREQUEST", Boolean.FALSE, "Task description is required"),
    UNAUTHORIZED(401, "UNAUTHORIZED", Boolean.FALSE, "There is no authorized"),
    FORBIDDEN(403, "FORBIDDEN", Boolean.FALSE, "It is forbidden"),
    NOTFOUND(404, "NOTFOUND", Boolean.FALSE, "Cannot find task"),
    INTERNAL_ERROR(500, "INTERNAL_ERROR", Boolean.FALSE, "");

    private Integer httpStatusCode;
    private String description;
    private Boolean isSuccess;
    private String message;


    public void setHttpStatusCode(Integer httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

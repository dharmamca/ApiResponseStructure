package com.flight.schedule.demo.common.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class ApiResult<T>  implements Serializable{

    private T payload;

    public ApiResult(T payload) {
        this.payload = payload;
    }
}

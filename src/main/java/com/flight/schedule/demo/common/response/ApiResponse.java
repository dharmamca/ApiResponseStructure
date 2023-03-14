package com.flight.schedule.demo.common.response;

import com.flight.schedule.demo.common.response.apierror.ApiError;
import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class ApiResponse {

    private HttpStatus status;

    private String message;

    private ApiResult result;

    private ApiError apiError;


    public ApiResponse(HttpStatus status, String message, ApiResult result, ApiError apiError) {
        this.status = status;
        this.message = message;
        this.result = result;
        this.apiError = apiError;
    }

    public static ApiResponse toApiResponse(Object data){
        return new ApiResponse(HttpStatus.OK,"success",new ApiResult(data),null);
    }

    public static ApiResponse voidResponse(){
        return new ApiResponse(HttpStatus.OK,"success",null,null);
    }
}

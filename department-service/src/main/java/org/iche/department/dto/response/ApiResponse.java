package org.iche.department.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.iche.department.utils.DateUtils;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse <T>{
    private String message;
    private String time;
    private T data;

    public ApiResponse(T data) {
        this.message = "Processed Successfully";
        this.time = DateUtils.saveDate(LocalDateTime.now());
        this.data = data;
    }
}

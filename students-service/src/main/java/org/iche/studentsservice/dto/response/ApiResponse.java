package org.iche.studentsservice.dto.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.iche.studentsservice.Utils.DateUtils;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse <T>{
    private String message;
    private String time;
    private T data;

    public ApiResponse( T data) {
        this.message = "processed successfully";
        this.time= DateUtils.saveDate(LocalDateTime.now());
        this.data = data;
    }
}

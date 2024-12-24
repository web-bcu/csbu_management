package com.csbu.mvc_management.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
//@AllArgsConstructor
@NoArgsConstructor
public class MessageResponse {
    private String message;

    public MessageResponse(String message) { this.message = message;}

    public String getMessage() {return message;}
    public void setMessage(String message) {this.message = message;}
}

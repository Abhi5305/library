package com.infosys.library.util;

import com.infosys.library.dto.Response;
import org.springframework.stereotype.Component;

@Component
public class ResponseGenerator {
    public Response createResponse(String message){
        Response response = new Response();
        response.setMessage(message);
        return response;
    }
}

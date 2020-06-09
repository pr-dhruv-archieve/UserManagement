package com.soma.UserManagement.actuatorendpoints;

import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RestControllerEndpoint(id = "restEndpoint")
public class MyRestControllerEndpoint {
    @GetMapping( )
    public ResponseEntity<String> getResponse() {
        return new ResponseEntity<>("RestController Response endpoint", HttpStatus.OK);
    }
}

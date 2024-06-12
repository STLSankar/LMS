package com.demo.lms.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.demo.lms.exception.GeneralResponse;

/**
 * @author sankar patra
 */
public class ResponseHandler {
    public ResponseEntity<?> successResponseDataSaving(Object object) {
        return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, object, "Successfully data saved."));
    }

    public ResponseEntity<?> successResponseDataRetrieve(Object object) {
        return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, object, "Success"));
    }
}

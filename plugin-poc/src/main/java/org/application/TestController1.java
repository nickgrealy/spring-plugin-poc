package org.application;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController1 {

    @RequestMapping("/application")
    public ResponseEntity<String> service(){
        return ResponseEntity.ok("ok");
    }

}

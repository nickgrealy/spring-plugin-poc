package org.springframework.context;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController2 {

    @RequestMapping("/spring")
    public ResponseEntity<String> service(){
        return ResponseEntity.ok("ok");
    }
    
}

package org.thirdpartyplugin;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController3 {

    @RequestMapping("/thirdpartyplugin")
    public ResponseEntity<String> service(){
        return ResponseEntity.ok("ok");
    }
    
}

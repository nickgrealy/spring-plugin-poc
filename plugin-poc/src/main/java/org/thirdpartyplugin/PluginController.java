package org.thirdpartyplugin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PluginController {

    @Value("${plugin.response:ok}")
    private String pluginResponse;

    @RequestMapping("/thirdpartyplugin")
    public ResponseEntity<String> service(){
        return ResponseEntity.ok(pluginResponse);
    }
    
}

// FluentdController.java

package com.sku.codesnippetshop.fluentdTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fluentd-test")
public class FluentdController {

    private final FluentdService fluentdService;

    @Autowired
    public FluentdController(FluentdService fluentdService) {
        this.fluentdService = fluentdService;
    }

    @PostMapping("/sendData")
    public ResponseEntity<String> sendDataToFluentd(@RequestBody String jsonData) {
        try {
            System.out.println("test");
            fluentdService.sendDataToExternalURL(jsonData);
            return new ResponseEntity<>("Data sent to Fluentd successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error sending data to Fluentd: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
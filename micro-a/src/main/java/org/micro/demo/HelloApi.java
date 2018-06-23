/**
 * 
 */
package org.micro.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author SandeepRaju
 *
 */
@RestController
public class HelloApi {
	
	@Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello from Spring Boot Micro A!";
    }
    
    @RequestMapping("/chaining")
    public String chaining() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8280/chaining", String.class);
        return String.format("Chaining from A -->  %s", response.getBody());
    }
    
    @RequestMapping("/chainException")
    public String chainingException() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8280/chainException", String.class);
        return String.format("ChainException from A  -->  %s", response.getBody());
    }
    
    @RequestMapping("/chainLatency")
    public String chainLatency() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8280/chainLatency", String.class);
        return String.format("ChainLatency from A  -->  %s", response.getBody());
    }
	
}

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
        return "Hello from Spring Boot Micro C!";
    }
    
    @RequestMapping("/chaining")
    public String chaining() {
        return " Invoking C ";
    }
    
    @RequestMapping("/chainException")
    public String chainingException() {
    	 ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8480/chaining", String.class);
         return String.format(" Invoking Exception C -->  %s", response.getBody());
    }
    
    @RequestMapping("/chainLatency")
    public String chainLatency() {
        return " Invoking Latency C ";
    }
}

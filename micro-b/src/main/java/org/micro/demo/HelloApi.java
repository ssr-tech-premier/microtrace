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
        return "Hello from Spring Boot Micro B!";
    }
    
    @RequestMapping("/chaining")
    public String chaining() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8380/chaining", String.class);
        return String.format(" Invoking B -->  %s", response.getBody());
    }
    
    @RequestMapping("/chainException")
    public String chainingException() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8380/chainException", String.class);
        return String.format(" Invoking B -->  %s", response.getBody());
    }
    
    @RequestMapping("/chainLatency")
    public String chainLatency() {
    	
    	for(int i=0 ; i < 1000; i++) {
    		for(int j=0 ; j < 10; j++) {
    			System.out.println(i * j + ( i + j));
    		}
    	}
    	
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8380/chainLatency", String.class);
        return String.format("Invoking B -->  %s", response.getBody());
    }
	
}

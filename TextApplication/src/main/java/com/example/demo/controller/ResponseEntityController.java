package com.example.demo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.form.ResponseEntityForm;

@Controller
public class ResponseEntityController {
	
	@RequestMapping(value="/demo")
	public String demo(){
		return "demo";
	}
	
	@RequestMapping(value = "/responseEntity")
    public ResponseEntity<ResponseEntityForm> getCountry() {
        
		ResponseEntityForm c = new ResponseEntityForm();
        c.setName("France");
        c.setPopulation(66984000);
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Company", "MyController");
        
//        return ResponseEntity.accepted().headers(headers).body(c);
//        return ResponseEntity.status(400).headers(headers).body(c);
        return ResponseEntity.badRequest().headers(headers).body(c);
     
    }
	
	@RequestMapping(value="/year")
	public ResponseEntity<ResponseEntityForm> getResponse(){
		
		ResponseEntityForm form = new ResponseEntityForm();
		form.setMessage("success");
		form.setContact("007");
		form.setStatus("200");
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Company", "CFS");
		
		return ResponseEntity.status(209).headers(headers).body(form);
	}
    
    @RequestMapping(value = "/getCountry2")
    @ResponseBody
    public ResponseEntityForm getCountry2() {

    	ResponseEntityForm c = new ResponseEntityForm();
        c.setName("France");
        c.setPopulation(66984000);
        
        return c;
    }    
}

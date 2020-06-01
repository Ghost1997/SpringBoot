package com.sujit.bfo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sujit.bfo.dao.bfoRepository;
import com.sujit.bfo.model.BFO;
import com.sujit.bfo.service.bfoService;
import com.sujit.bfo.utility.Response;

@RestController
public class bfoController {
	
	
	@Autowired
	private bfoRepository repository;
	
	@Autowired
	private bfoService service;
	
	@PostMapping("/createbfo")
	public Response create(@RequestBody BFO bfo) {
		Response res=service.create(bfo);		
		return res;

	}
	@GetMapping("/getbfo")
	public Response getbfo(@RequestParam(name="id", required = true) String id,@RequestParam(name="date", required = true) String date) throws ParseException {
		Date date1= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(date);
		TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
		Response res=service.getbfo(id,date1);
		return res;
		

	}


}

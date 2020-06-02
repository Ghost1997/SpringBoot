package com.sujit.bfo.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.TimeZone;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sujit.bfo.dao.bfoRepository;
import com.sujit.bfo.model.BFO;
import com.sujit.bfo.utility.Response;

@Service
public class bfoService {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
	@Autowired
	private bfoRepository repository;

	public Response create(BFO bfo) {
		if (Pattern.compile("[0-9]{4}[A-Z]{5}[0-9]{2}").matcher(bfo.getOpportunityId()).find()) {
			bfo.getOpportunityId();
			repository.save(bfo);
			ArrayList al = new ArrayList();
			al.add(bfo);
			Response res = new Response();
			res.setMessage("Sucess");
			res.setStatus(200);
			res.setResult(al);
			System.out.println(res);
			return res;
		} else {
			ArrayList al = new ArrayList();
			al.add("Pattern Not Mached");
			Response res = new Response();
			res.setMessage("Bad Request");
			res.setStatus(400);
			res.setResult(al);
			System.out.println(res);
			return res;

		}

	}

	public Response getbfo(String id, Date date) {
		String reqDate = sdf.format(date);
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		try {
			
			Optional<BFO> bfo = repository.findById(id);
			String dbDate = sdf.format(bfo.get().getCreatedDate());
			if (bfo.isPresent() && dbDate.equals(reqDate)) {
				ArrayList al = new ArrayList();
				al.add(bfo);
				Response res = new Response();
				res.setMessage("Sucess");
				res.setStatus(200);
				res.setResult(al);
				System.out.println(res);
				return res;
			} else {
				ArrayList al = new ArrayList();
				al.add("Not Result Found");
				Response res = new Response();
				res.setMessage("Bad Request");
				res.setStatus(400);
				res.setResult(al);
				return res;

			}
		} catch (Exception e) {
			ArrayList al = new ArrayList();
			al.add("No Result Found");
			Response res = new Response();
			res.setMessage("Bad Request");
			res.setStatus(400);
			res.setResult(al);
			return res;
		}

	}

}

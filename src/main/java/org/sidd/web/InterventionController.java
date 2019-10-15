package org.sidd.web;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.sidd.dao.InterventionRepository;
import org.sidd.entites.Intervention;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterventionController {
	@Autowired
	private InterventionRepository interventionRepository;
	@GetMapping("/interventions/Filtrer-test")
	public List<String> Filtrer(@RequestParam("dateintervention") String date) throws ParseException{
		System.out.println();
		return interventionRepository.Filtrer(new SimpleDateFormat("yyyy-MM-dd").parse(date));
	}
}

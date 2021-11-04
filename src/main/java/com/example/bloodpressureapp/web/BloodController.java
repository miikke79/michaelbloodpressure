package com.example.bloodpressureapp.web;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.bloodpressureapp.domain.Bloodpressure;
import com.example.bloodpressureapp.domain.Bloodpressurerepository;

@Controller
public class BloodController {
	@Autowired
	private Bloodpressurerepository repository;

	@RequestMapping(value = { "/", "/bloodpressure" })
	public String bloodPressure(Model model) {
		model.addAttribute("bloodpressures", repository.findAll());
		return "bloodpressure";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBloodpressure(@PathVariable("id") Long bloodpressureId, Model model) {
		repository.deleteById(bloodpressureId);
		return "redirect:../bloodpressure";
	}

	@GetMapping("/addreading")
	public String addRecord(Model model) {
		model.addAttribute("bloodpressure", new Bloodpressure(0, 0, 0, LocalDate.now()));
		return "addreading";

	}
	
	@RequestMapping(value = "/editreading/{id}")
	public String modifyRecord(@PathVariable("id") Long recordId, Model model) {
		Optional<Bloodpressure> record = repository.findById(recordId);
		model.addAttribute("bloodpressure", record);
		return "editreading";
	}
	
	@PostMapping(value = "/save")
	public String save(Bloodpressure newReading) {
		repository.save(newReading);
		return "redirect:bloodpressure";
	}

}

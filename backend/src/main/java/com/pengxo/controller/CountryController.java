package com.pengxo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pengxo.database.entity.onetomany.Country;
import com.pengxo.database.service.CountryService;

@RestController
public class CountryController {

	@Autowired
	private CountryService countryService;

	@GetMapping(path = "/countries")
	public List<Country> getAllCountrys() {
		return countryService.getAllCountrys();
	}

	@PostMapping(path = "/addCountry")
	public void addCountry(@RequestBody final Country country) {
		countryService.saveCountry(country);
	}

	@PostMapping(path = "/editCountry")
	public void editCountry(@RequestBody final Country country) {
		countryService.saveCountry(country);
	}

	@DeleteMapping(path = "/deleteCountry")
	public void removeCountry(@RequestBody final Country country) {
		countryService.deleteCountry(country);
	}

}

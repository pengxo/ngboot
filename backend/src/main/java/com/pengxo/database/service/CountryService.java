package com.pengxo.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pengxo.database.entity.onetomany.Country;
import com.pengxo.database.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Transactional
	public List<Country> getAllCountrys() {
		return countryRepository.findAll();
	}

	@Transactional
	public void saveCountry(final Country country) {
		countryRepository.save(country);
	}

	@Transactional
	public void deleteCountry(final Country country) {
		countryRepository.delete(country);
	}

	@Transactional
	public Country findById(final Long id) {
		return countryRepository.findById(id).orElse(null);
	}

}

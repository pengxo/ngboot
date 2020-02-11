package com.pengxo.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pengxo.database.entity.onetomany.Province;
import com.pengxo.database.repository.ProvinceRepository;

@Service
public class ProvinceService {

	@Autowired
	private ProvinceRepository provinceRepository;

	@Transactional
	public List<Province> getAllProvinces() {
		return provinceRepository.findAll();
	}

	@Transactional
	public void saveProvince(final Province province) {
		provinceRepository.save(province);
	}

	@Transactional
	public void deleteProvince(final Province province) {
		provinceRepository.delete(province);
	}

	@Transactional
	public Province findById(final Long id) {
		return provinceRepository.findById(id).orElse(null);
	}

}

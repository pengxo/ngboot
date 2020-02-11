package com.pengxo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pengxo.database.entity.onetomany.Province;
import com.pengxo.database.service.ProvinceService;

@RestController
public class ProvinceController {

	@Autowired
	private ProvinceService provinceService;

	@GetMapping(path = "/provinces")
	public List<Province> getAllProvinces() {
		return provinceService.getAllProvinces();
	}

	@PostMapping(path = "/addProvince")
	public void addProvince(@RequestBody final Province province) {
		provinceService.saveProvince(province);
	}

	@PostMapping(path = "/editProvince")
	public void editProvince(@RequestBody final Province province) {
		provinceService.saveProvince(province);
	}

	@DeleteMapping(path = "/deleteProvince")
	public void removeProvince(@RequestBody final Province province) {
		provinceService.deleteProvince(province);
	}

}

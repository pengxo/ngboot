package com.pengxo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pengxo.database.entity.manytomany.Writer;
import com.pengxo.database.service.WriterService;

@RestController
public class WriterController {

	@Autowired
	private WriterService writerService;

	@GetMapping(path = "/writers")
	public List<Writer> getAllWriters() {
		return writerService.getAllWriters();
	}

	@PostMapping(path = "/addWriter")
	public void addWriter(@RequestBody final Writer writer) {
		writerService.saveWriter(writer);
	}

	@PostMapping(path = "/editWriter")
	public void editWriter(@RequestBody final Writer writer) {
		writerService.saveWriter(writer);
	}

	@DeleteMapping(path = "/deleteWriter")
	public void removeWriter(@RequestBody final Writer writer) {
		writerService.deleteWriter(writer);
	}

}

package com.pengxo.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pengxo.database.entity.manytomany.Writer;
import com.pengxo.database.repository.WriterRepository;

@Service
public class WriterService {

	@Autowired
	private WriterRepository writerRepository;

	@Transactional
	public List<Writer> getAllWriters() {
		return writerRepository.findAll();
	}

	@Transactional
	public void saveWriter(final Writer writer) {
		writerRepository.save(writer);
	}

	@Transactional
	public void deleteWriter(final Writer writer) {
		writerRepository.delete(writer);
	}

}

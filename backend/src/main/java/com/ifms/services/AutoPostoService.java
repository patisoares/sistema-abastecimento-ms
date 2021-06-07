package com.ifms.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifms.dto.AutoPostoDTO;
import com.ifms.entities.AutoPosto;
import com.ifms.repositories.AutoPostoRepository;
import com.ifms.services.exceptions.ResourceNotFoundException;

@Service
public class AutoPostoService {
	
	@Autowired
	private AutoPostoRepository repository;

	@Transactional(readOnly = true)
	public List<AutoPostoDTO> findAll() {
		
	List<AutoPosto> list =	repository.findAll();
		return list.stream().map(autoposto -> new AutoPostoDTO(autoposto))
							.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public AutoPostoDTO findById(Long id) {
		Optional<AutoPosto> obj = repository.findById(id);
		AutoPosto autoposto = obj.orElseThrow(() -> new ResourceNotFoundException(
					"O AutoPosto solicitado não foi localizado"));
		return new AutoPostoDTO(autoposto);
	}

}

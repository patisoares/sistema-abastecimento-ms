package com.ifms.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifms.dto.AbastecimentoDTO;
import com.ifms.entities.Abastecimento;
import com.ifms.repositories.AbastecimentoRepository;
import com.ifms.services.exceptions.ResourceNotFoundException;

@Service
public class AbastecimentoService {
	
	@Autowired
	private AbastecimentoRepository repository;

		
	@Transactional(readOnly = true)
	public List<AbastecimentoDTO> findAll() {
		List<Abastecimento> list = repository.findAll();
		return list.stream().map(abastecimento -> new AbastecimentoDTO(abastecimento))
							.collect(Collectors.toList());
		
	}

	@Transactional(readOnly = true)
	public AbastecimentoDTO findById(Long id) {
		Optional<Abastecimento> obj = repository.findById(id);
		Abastecimento abastecimento = obj.orElseThrow(() -> new ResourceNotFoundException(
					"O Abastecimento solicitado não foi localizado"));
		return new AbastecimentoDTO(abastecimento);
	}

}

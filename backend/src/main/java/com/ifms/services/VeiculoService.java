package com.ifms.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifms.dto.VeiculoDTO;
import com.ifms.entities.Veiculo;
import com.ifms.repositories.VeiculoRepository;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository repository;

	@Transactional(readOnly = true)
	public List<VeiculoDTO> findAll() {
		List<Veiculo> list = repository.findAll();
		return list.stream().map(veiculo -> new VeiculoDTO(veiculo))
							.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)	
	public VeiculoDTO findById(Long id) {
		Optional<Veiculo> obj =  repository.findById(id);
		Veiculo veiculo = obj.get();
		return new VeiculoDTO(veiculo);
	}
	
	
	}
	
	


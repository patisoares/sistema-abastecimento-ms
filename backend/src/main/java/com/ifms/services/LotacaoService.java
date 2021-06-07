package com.ifms.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifms.dto.LotacaoDTO;
import com.ifms.entities.Lotacao;
import com.ifms.repositories.LotacaoRepository;
import com.ifms.services.exceptions.ResourceNotFoundException;

@Service
public class LotacaoService  {
	
	@Autowired
	private LotacaoRepository repository;

	@Transactional(readOnly = true)
	public List<LotacaoDTO> findAll() {
		List<Lotacao> list = repository.findAll();
		return list.stream().map(lotacao -> new LotacaoDTO(lotacao))
							.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public LotacaoDTO findById(Long id) {
		Optional<Lotacao> obj = repository.findById(id);
		Lotacao lotacao = obj.orElseThrow(() -> new ResourceNotFoundException(
				"A Lotação solicitada não foi localizada"));
		return new LotacaoDTO(lotacao);
	}
	

}

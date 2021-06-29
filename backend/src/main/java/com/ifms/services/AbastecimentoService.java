	package com.ifms.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifms.dto.AbastecimentoDTO;
import com.ifms.entities.Abastecimento;
import com.ifms.repositories.AbastecimentoRepository;
import com.ifms.services.exceptions.DataBaseException;
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
	
	@Transactional
	public AbastecimentoDTO insert(AbastecimentoDTO dto) {
		Abastecimento entity = new Abastecimento();
		entity.setCpfMotorista(dto.getCpfMotorista());
		entity.setDataDoAbastecimento(dto.getDataDoAbastecimento());
		entity.setQuilometragem(dto.getQuilometragem());
		entity.setCombustivel(dto.getCombustivel());
		entity.setQuantidadeEmLitros(dto.getQuantidadeEmLitros());
		entity.setValorPorLitro(dto.getValorPorLitro());
		entity.setAutoPosto(dto.getAutoPosto());
		entity.setVeiculo(dto.getVeiculo());
		entity = repository.save(entity);
		return new AbastecimentoDTO(entity);
	}

	@Transactional
	public AbastecimentoDTO update(Long id, AbastecimentoDTO dto) {
		try {
			Abastecimento entity = repository.getOne(id);
			entity.setCpfMotorista(dto.getCpfMotorista());
			entity.setDataDoAbastecimento(dto.getDataDoAbastecimento());
			entity.setQuilometragem(dto.getQuilometragem());
			entity.setCombustivel(dto.getCombustivel());
			entity.setQuantidadeEmLitros(dto.getQuantidadeEmLitros());
			entity.setValorPorLitro(dto.getValorPorLitro());
			entity.setAutoPosto(dto.getAutoPosto());
			entity.setVeiculo(dto.getVeiculo());
			entity = repository.save(entity);
			return new AbastecimentoDTO(entity);			
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("o id do Abastecimento não foi localizado");
		}
	}

	

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Não foi possível deletar, o id do Abastecimento não foi localizado");
		}catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Não foi possivel deletar o Abastecimento, pois este está em uso");
		}
		
	}

}

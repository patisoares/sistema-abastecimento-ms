package com.ifms.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifms.dto.LotacaoDTO;
import com.ifms.services.LotacaoService;

@RestController
@RequestMapping(value = "/lotacoes")
public class LotacaoResource {
	
	@Autowired
	private LotacaoService service;
	
	@GetMapping
	public ResponseEntity<List<LotacaoDTO>> findAll(){
		List<LotacaoDTO> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<LotacaoDTO> findById(@PathVariable Long id){
		LotacaoDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
}

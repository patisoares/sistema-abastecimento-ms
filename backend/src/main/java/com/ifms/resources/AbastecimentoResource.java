package com.ifms.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifms.dto.AbastecimentoDTO;
import com.ifms.services.AbastecimentoService;

@RestController
@RequestMapping(value = "/abastecimentos")
public class AbastecimentoResource {

	
	@Autowired
	private AbastecimentoService service;
	
	@GetMapping
	public ResponseEntity<List<AbastecimentoDTO>> findAll(){
		List<AbastecimentoDTO> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AbastecimentoDTO> findById(@PathVariable Long id){
		AbastecimentoDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
		
	}
	
}

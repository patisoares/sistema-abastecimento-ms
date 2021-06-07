package com.ifms.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifms.dto.AutoPostoDTO;
import com.ifms.services.AutoPostoService;

@RestController
@RequestMapping(value = "/autopostos")
public class AutoPostoResource {
	
	@Autowired
	private AutoPostoService service;
	
	@GetMapping
	public ResponseEntity<List<AutoPostoDTO>> findAll(){
		List<AutoPostoDTO> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}

		@GetMapping(value = "/{id}")
		public ResponseEntity<AutoPostoDTO> findById(@PathVariable Long id){
		AutoPostoDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
		}
}

package com.hcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.service.CacheImpl;

@RestController
public class CacheController {
	@Autowired
	private CacheImpl nameImpl;
	
	@GetMapping("/get/{id}")
	public String get(@PathVariable Integer id) {
		return nameImpl.get(id);
	}

	@PatchMapping("/update/{id}/{name}")
	public String update(@PathVariable Integer id, @PathVariable String name) {
		nameImpl.delete(id);
		nameImpl.put(id, name);
		
		return name;
	}
		
	@PostMapping("/put/{id}/{name}")
	public void put(@PathVariable Integer id, @PathVariable String name) {
		nameImpl.put(id, name);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		nameImpl.delete(id);
	}
}

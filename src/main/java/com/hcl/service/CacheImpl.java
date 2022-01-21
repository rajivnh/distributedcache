package com.hcl.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheImpl {
	private Map<Integer, String> namesMap = new HashMap<Integer, String>();
	
	@Cacheable(cacheNames = "names")
	public String get(Integer customerId) {
		try {
			Thread.sleep(4000);
		} catch(Exception e) {
			
		}
		
	    return namesMap.get(customerId);
	}
	
	@CacheEvict(cacheNames = "names")
	public void delete(Integer id) {
		namesMap.remove(id);
	}

	@CachePut(cacheNames = "names")
	public void put(Integer id, String name) {
		namesMap.put(id, name);
	}
	
	@PostConstruct
	private void init() {
		namesMap.put(1, "Rajiv");
		namesMap.put(2, "Vivva");
		namesMap.put(3, "David");
		namesMap.put(4, "Sachin");
	}
}

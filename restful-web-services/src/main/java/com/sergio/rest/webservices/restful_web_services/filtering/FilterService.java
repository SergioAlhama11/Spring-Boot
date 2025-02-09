package com.sergio.rest.webservices.restful_web_services.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@Service
public class FilterService {

	public MappingJacksonValue createFilter1(MappingJacksonValue mappingJacksonValue) {
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1");
		//SimpleBeanPropertyFilter filter2 = SimpleBeanPropertyFilter.filterOutAll();
		
		establishingFilters(mappingJacksonValue, filter);
		
		return mappingJacksonValue;
	}
	
	public MappingJacksonValue createFilter2(MappingJacksonValue mappingJacksonValue) {
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
		//SimpleBeanPropertyFilter filter2 = SimpleBeanPropertyFilter.filterOutAll();
		
		establishingFilters(mappingJacksonValue, filter);
		
		return mappingJacksonValue;
	}
	
	private void establishingFilters(MappingJacksonValue mappingJacksonValue, SimpleBeanPropertyFilter filter) {
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mappingJacksonValue.setFilters(filters);                                                         
	}
}

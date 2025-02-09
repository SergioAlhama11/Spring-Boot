package com.sergio.rest.webservices.restful_web_services.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
	
	@Autowired
	private FilterService filterService;
	
	public FilteringController(FilterService filterService) {
		super();
		this.filterService = filterService;
	}

	@GetMapping("/filtering")
	public SomeBean filtering() {
		return new SomeBean("value1", "value2", "value3");
	}
	
	@GetMapping("/filtering-list")
	public List<SomeBean> filteringList() {
		return Arrays.asList(new SomeBean("value1", "value2", "value3"), new SomeBean("value4", "value5", "value6"));
	}
	
	// Dynamic Filtering
	
	@GetMapping("/dynamic-filtering")
	public MappingJacksonValue dynamicFiltering() {
		SomeBean someBean = new SomeBean("value1", "value2", "value3");
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		
		return filterService.createFilter1(mappingJacksonValue);
	}
	
	@GetMapping("/dynamic-filtering-list")
	public MappingJacksonValue dynamicFilteringList() {
		List<SomeBean> valuesList = Arrays.asList(new SomeBean("value1", "value2", "value3"), new SomeBean("value4", "value5", "value6"));
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(valuesList);
		
		return filterService.createFilter2(mappingJacksonValue);
	}
}

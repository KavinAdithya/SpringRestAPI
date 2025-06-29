package com.techcrack.restfulWebService.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	@GetMapping("filter")
	public MappingJacksonValue getSomeBean() {

		var someBean = new SomeBean("Field 1", "Field 2", "Field 3");
		MappingJacksonValue filter = new MappingJacksonValue(someBean);
		SimpleBeanPropertyFilter f = SimpleBeanPropertyFilter.filterOutAllExcept("field3");
		
		FilterProvider provider = new SimpleFilterProvider().addFilter("someBeanFilter", f);
		filter.setFilters(provider);
		
		return filter;
	}
	
	@GetMapping("filter-list")
	public MappingJacksonValue getSomeBeans() {
		var someBeans  =  Arrays.asList(
				new SomeBean("Field 1", "Field 2", "Field 3"),
				new SomeBean("Field 4", "Field 5", "Field 6"),
				new SomeBean("Field 7", "Field 8", "Field 9"));
		
		var mappingJacksonValue = new MappingJacksonValue(someBeans);
		
		var filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
		
		var provider = new SimpleFilterProvider();
		provider.addFilter("someBeanFilter", filter);
		
		mappingJacksonValue.setFilters(provider);
		
		return mappingJacksonValue;
	}
}

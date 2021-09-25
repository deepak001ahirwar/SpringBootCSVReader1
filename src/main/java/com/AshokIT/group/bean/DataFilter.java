package com.AshokIT.group.bean;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.AshokIT.group.model.Product;

@Service
public class DataFilter implements IDataFilter {

	@Override
	public List<Product> filterProducts(List<Product> productsList) {

		return productsList.stream()
						   .filter(p -> p.getProductPrice() >= 5000)
						   .collect(Collectors.toList());

	}

}

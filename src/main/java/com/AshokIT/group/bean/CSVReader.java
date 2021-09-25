package com.AshokIT.group.bean;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.AshokIT.group.model.Product;

@Service
public class CSVReader {

	private IDataFilter dataFilter;

	// constucter Injection
	public CSVReader(IDataFilter dataFilter) {
		this.dataFilter = dataFilter;
	}

	public List<Product> readAndFilterProductData() throws Exception {

		List<Product> plist = new ArrayList<>();

		FileReader fr = new FileReader(new File("products.txt"));

		BufferedReader br = new BufferedReader(fr);

		String lineData = br.readLine();

		while (lineData != null) {

			String[] split = lineData.split(",");

			String pid = split[0];
			String name = split[1];
			String price = split[2];

			Product p = new Product();
			p.setProductId(Integer.parseInt(pid));
			p.setProductName(name);
			p.setProductPrice(Double.parseDouble(price));
			
			plist.add(p);
			
			lineData=br.readLine();
			
		}
		System.out.println("before filter "+plist);

		return dataFilter.filterProducts(plist);

	}

}

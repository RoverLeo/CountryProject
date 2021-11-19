package main;

import data.CountriesDataRepository;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		CountriesDataRepository countriesDataRepository = new CountriesDataRepository();
		List<Double> freedoms = countriesDataRepository.findAllFreedom();
		freedoms = freedoms.stream().sorted().collect(Collectors.toList());

		Map<Double, Integer> data = new TreeMap<>();
		int counter = 0;
		double freedomPrevValue = 0;
		for (var f : freedoms) {
			if (f != freedomPrevValue) {
				data.put(freedomPrevValue, counter);
				counter = 0;
				freedomPrevValue = f;
			}
			counter++;
		}

		BarChartSample.countData = data;
		BarChartSample.main(args);
	}
}

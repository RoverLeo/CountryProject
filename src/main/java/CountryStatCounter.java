package src;

import java.math.BigDecimal;
import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class CountryStatCounter {

	public BigDecimal countAverageHappinessRank(List<CountryData> countriesData) {
		BigDecimal happinessRankSum = BigDecimal.ZERO;
		long count = 0;
		for (CountryData country : countriesData) {
			double happinessRank = country.getHappinessRank();
			happinessRankSum = happinessRankSum.add(BigDecimal.valueOf(happinessRank));
			count++;
		}
		return happinessRankSum.divide(BigDecimal.valueOf(count));
	}

	public double findHighestHappinessRank(List<CountryData> countriesData) {
		double max = Double.MIN_VALUE;
		for (CountryData country : countriesData) {
			max = max < country.getHappinessRank() ? country.getHappinessRank() : max;
		}
		return max;
	}

	public double findHighestFreedom(List<CountryData> countriesData) {
		double max = Double.MIN_VALUE;
		for (CountryData country : countriesData) {
			max = max(country.getFreedom(), max);
		}
		return max;
	}

	public double findLowestRank(List<CountryData> countriesData) {
		double min = Double.MAX_VALUE;
		for (CountryData country : countriesData) {
			min = min(country.getFreedom(), min);
		}
		return min;
	}

	public int findLongestCountryName(List<CountryData> countriesData) {
		int nameSize = 0;
		for (CountryData country : countriesData) {
			nameSize = max(nameSize, country.getName().length());
		}
		return nameSize;
	}
}

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TestCountryStatCounter {

	CountryStatCounter countryStatCounter = new CountryStatCounter();

	@Test
	public void testFindLongestCountryName() {
		List<CountryData> countryData = new ArrayList<>();
		CountryData usa = new CountryData();
		usa.setName("USA");
		countryData.add(usa);
		CountryData russia = new CountryData();
		russia.setName("russia");
		countryData.add(russia);
		int maxName = countryStatCounter.findLongestCountryName(countryData);
		Assert.assertEquals(6, maxName);
	}

	@Test
	public void testCountAverageHappinessRank() {
		List<CountryData> countryData = new ArrayList<>();
		CountryData usa = new CountryData();
		usa.setHappinessRank(2.0);
		countryData.add(usa);
		CountryData russia = new CountryData();
		russia.setHappinessRank(1.0);
		countryData.add(russia);
		BigDecimal average = countryStatCounter.countAverageHappinessRank(countryData);
		Assert.assertEquals(BigDecimal.valueOf(1.5), average);
	}

	@Test
	public void testFindHighestHappinessRank() {
		List<CountryData> countryData = new ArrayList<>();
		CountryData usa = new CountryData();
		usa.setHappinessRank(100.9);
		countryData.add(usa);
		CountryData russia = new CountryData();
		russia.setHappinessRank(100.99);
		countryData.add(russia);
		BigDecimal maxRank = countryStatCounter.countAverageHappinessRank(countryData);
		Assert.assertEquals(BigDecimal.valueOf(100.99), maxRank);
	}
}

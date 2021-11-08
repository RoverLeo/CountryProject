import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class TestCSVParse {

	CSVCountriesReader csvCountriesReader;

	@Test
	public void testReadCSVFile() {
		File file = new File("G:\\Leo\\Here\\DATA.csv");
		csvCountriesReader = new CSVCountriesReader(file, ",");
		List<CountryData> countryData = csvCountriesReader.parseDataInDTO();

		Assert.assertTrue(countryData.size() > 0);
	}
}

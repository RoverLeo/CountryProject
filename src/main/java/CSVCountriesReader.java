import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVCountriesReader extends CSVReader {

	CSVCountriesReader(File file, String separater) {
		super(file, separater);
	}

	@Override
	@SneakyThrows
	public List<CountryData> parseDataInDTO() {
		List<CountryData> countryDataParsed = new ArrayList();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] params = getParamsFromLine(line);

				CountryData countryData = new CountryData();
				fillCountriesData(countryData, params);
			}
			return countryDataParsed;
		}
	}

	private String[] getParamsFromLine(String line) {
		String[] params = line.split(SEPARATER);
		if (params.length != 12) {
			throw new NotAllDataLineException(params);
		}
		return params;
	}

	private void fillCountriesData(CountryData countryData, String[] params) {
		countryData.setName(params[0]);
		countryData.setRegion(params[1]);
		countryData.setHappinessRank(Double.parseDouble(params[2]));
		countryData.setHappinessScore(Double.parseDouble(params[3]));
		countryData.setStandardError(Double.parseDouble(params[4]));
		countryData.setEconomy(Double.parseDouble(params[5]));
		countryData.setFamily(Double.parseDouble(params[6]));
		countryData.setHealth(Double.parseDouble(params[7]));
		countryData.setFreedom(Double.parseDouble(params[8]));
		countryData.setTrust(Double.parseDouble(params[9]));
		countryData.setGenerosity(Double.parseDouble(params[10]));
		countryData.setDystopiaResidual(Double.parseDouble(params[11]));
	}
}

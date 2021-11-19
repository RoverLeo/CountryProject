package src;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public abstract class CSVReader {

	protected final File file;
	protected final String SEPARATER;

	@SneakyThrows
	CSVReader(File file, String separater) {
		if (!file.exists() || file.isDirectory()) {
			throw new FileNotFoundException();
		}
		this.file = file;
		SEPARATER = separater;
	}

	abstract <DTO> List<DTO> parseDataInDTO();
}

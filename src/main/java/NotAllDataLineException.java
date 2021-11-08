public class NotAllDataLineException extends RuntimeException {

	public NotAllDataLineException(String[] params) {
		super(getMessageParams(params));
	}

	private static String getMessageParams(String[] params) {
		StringBuilder messageParams = new StringBuilder();
		for (String param : params) {
			messageParams.append(param);
			messageParams.append(" ");
		}
		return messageParams.toString();
	}
}

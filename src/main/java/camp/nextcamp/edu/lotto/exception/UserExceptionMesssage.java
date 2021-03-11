package camp.nextcamp.edu.lotto.exception;

public enum UserExceptionMesssage {
	IS_NOT_LOTTO_RANGE("Lotto 는 1~46까지만 입력이 가능합니다."),
	MAXIUMUM_SIZE("Lotto 개수는 6개여야 됩니다."),
	SLICE_WITH_COMMA(",  단위로 잘라서 입력해주세요."),
	ONLY_NUMBER("숫자만 입력이 가능합니다.");

	private final String message;

	UserExceptionMesssage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
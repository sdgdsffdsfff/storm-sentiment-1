package zx.soft.storm.web.domain;

public class ErrorResponse {

	private final int errorCode;
	private final String errorMessage;

	public ErrorResponse(final Builder builder) {
		this.errorCode = builder.errorCode;
		this.errorMessage = builder.errorMessage;
	}

	public static class Builder {

		private final int errorCode;
		private final String errorMessage;

		public Builder(final int errorCode, final String errorMessage) {
			super();
			this.errorCode = errorCode;
			this.errorMessage = errorMessage;
		}

		public ErrorResponse build() {
			return new ErrorResponse(this);
		}
	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}

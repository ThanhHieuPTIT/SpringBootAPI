package application.dao;

public class LoginResponse {
	private String accessToken;
	private String tokenType = "Bearer";
	
	public LoginResponse(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
}

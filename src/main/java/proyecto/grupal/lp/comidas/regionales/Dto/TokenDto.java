package proyecto.grupal.lp.comidas.regionales.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenDto {
	private String token;
	@JsonProperty("refresh_token")
	private String refreshToken;


	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}

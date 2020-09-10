package estagio.totem.endereco.controller.dto;

public class TokenDTO {
    private String token;
    private String tipoToken;

    public TokenDTO(String token, String tipoToken) {
        this.token = token;
        this.tipoToken = tipoToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTipoToken() {
        return tipoToken;
    }

    public void setTipoToken(String tipoToken) {
        this.tipoToken = tipoToken;
    }
}

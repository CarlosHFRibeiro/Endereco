package estagio.totem.endereco.configuration.exception;

public class ErrorDto {

    private String error;

    public ErrorDto(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}

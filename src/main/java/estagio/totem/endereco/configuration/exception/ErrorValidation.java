package estagio.totem.endereco.configuration.exception;

public class ErrorValidation {
    private final String propriedade;
    private final String erro;

    public ErrorValidation(String propriedade, String erro) {
        this.propriedade = propriedade;
        this.erro = erro;
    }

    public String getPropriedade() {
        return propriedade;
    }

    public String getErro() {
        return erro;
    }
}

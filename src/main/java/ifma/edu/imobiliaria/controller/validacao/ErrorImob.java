package ifma.edu.imobiliaria.controller.validacao;

public class ErrorImob {

    private String campo;
    private String mensagem;

    public ErrorImob(String campo, String erro) {
        this.campo = campo;
        this.mensagem = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getMensagem() {
        return mensagem;
    }
}

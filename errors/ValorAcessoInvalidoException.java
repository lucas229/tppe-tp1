public class ValorAcessoInvalidoException extends Exception {
    String valorAcesso;

    public ValorAcessoInvalidoException(String valorAcesso){
        this.valorAcesso = valorAcesso;
    }

    @Override
    public String getMessage() {
        return "Valor de acesso " + valorAcesso +  " informado é inválido";
    }
}

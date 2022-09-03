public class CadastroAcesso {
    private Estacionamento estacionamento;
    private String placa, horaEntrada, horaSaida;
    private int minutosEntrada, minutosSaida;
    
    public CadastroAcesso(String placa, String horaEntrada, String horaSaida, Estacionamento estacionamento) {
        this.estacionamento = estacionamento;
        this.placa = placa;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
    }
    
    public float computar() throws DescricaoEmBrancoException, HorarioInvalidoException, CapacidadeException {
        estacionamento.validarAcesso(placa, horaEntrada, horaSaida);

        minutosEntrada = estacionamento.calcularMinutos(horaEntrada);
        minutosSaida = estacionamento.calcularMinutos(horaSaida);
        
        if(estacionamento.checarMensalista(placa)) {
            return estacionamento.getValorAcessoMensalista();
        }

        if(estacionamento.checarAcessoNoturno(minutosEntrada, minutosSaida)) {
            return estacionamento.calcularValorAcessoNoturno();
        }

        if(estacionamento.checarAcessoDiurno(minutosEntrada, minutosSaida)) {
            return estacionamento.getValorDiariaDiurna();
        }

        return estacionamento.cadastrarAcessoFracao(minutosEntrada, minutosSaida);
    }
}

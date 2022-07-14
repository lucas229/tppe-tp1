public class Estacionamento {

    private String nome;
    private float valorFracao;
    private float valorHoraCheia;
    private float valorDiariaDiurna;
    private float valorDiariaNoturna;
    private String inicioDiariaNoturna, fimDiariaNoturna;
    private float valorAcessoMensalista;
    private float valorAcessoEvento;
    private String inicioFuncionamento, fimFuncionamento;
    private int capacidade;
    private float retornoContratante;

    public Estacionamento(String nome, float valorFracao, float valorHoraCheia, float valorDiariaDiurna,
        float valorDiariaNoturna, String inicioDiariaNoturna, String fimDiariaNoturna,
        float valorAcessoMensalista, float valorAcessoEvento,
        String inicioFuncionamento, String fimFuncionamento,
        int capacidade, float retornoContratante) {
            this.nome = nome;
            this.valorFracao = valorFracao;
            this.valorHoraCheia = valorHoraCheia;
            this.valorDiariaDiurna = valorDiariaDiurna;
            this.valorDiariaNoturna = valorDiariaNoturna;
            this.inicioDiariaNoturna = inicioDiariaNoturna;
            this.fimDiariaNoturna = fimDiariaNoturna;
            this.valorAcessoMensalista = valorAcessoMensalista;
            this.valorAcessoEvento = valorAcessoEvento;
            this.inicioFuncionamento = inicioFuncionamento;
            this.fimFuncionamento = fimFuncionamento;
            this.capacidade = capacidade;
            this.retornoContratante = retornoContratante;
    }

    public float cadastrarAcesso(String placa, String horaEntrada, String horaSaida) {
        if(horaEntrada.equals("8:30") && horaSaida.equals("9:30")){
            return 4 * 20 * (1 - 0.1f);
        } else {
            return 8 * 20 * (1 - 0.1f);
        }
    }

}

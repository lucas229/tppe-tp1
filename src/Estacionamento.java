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
        int parsedHoraEntrada = Integer.parseInt(horaEntrada.split(":")[0]);
        int parsedHoraSaida = Integer.parseInt(horaSaida.split(":")[0]);
        
        if(parsedHoraEntrada >= 19 || parsedHoraSaida <= 8) {
            return 120 * 45 / 100;
        }

        int minutosEntrada = Integer.parseInt(horaEntrada.split(":")[0]) * 60 + Integer.parseInt(horaEntrada.split(":")[1]);
        int minutosSaida = Integer.parseInt(horaSaida.split(":")[0]) * 60 + Integer.parseInt(horaSaida.split(":")[1]);
        int fracoes = (minutosSaida - minutosEntrada) / 15;

        return fracoes * valorFracao * (1 - (valorHoraCheia / 100));
    }
}

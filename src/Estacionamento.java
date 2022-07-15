import java.util.ArrayList;

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
    private ArrayList<String> mensalistas;

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
            mensalistas = new ArrayList<>();
    }

    public float cadastrarAcesso(String placa, String horaEntrada, String horaSaida) {
        int minutosEntrada = Integer.parseInt(horaEntrada.split(":")[0]) * 60 + Integer.parseInt(horaEntrada.split(":")[1]);
        int minutosSaida = Integer.parseInt(horaSaida.split(":")[0]) * 60 + Integer.parseInt(horaSaida.split(":")[1]);
        int fracoes = (minutosSaida - minutosEntrada) / 15;
        int totalMinutos;
        
        int minutosInicioNoturna = Integer.parseInt(inicioDiariaNoturna.split(":")[0]) * 60 + Integer.parseInt(inicioDiariaNoturna.split(":")[1]);
        int minutosFimNoturna = Integer.parseInt(fimDiariaNoturna.split(":")[0]) * 60 + Integer.parseInt(fimDiariaNoturna.split(":")[1]);

        // Mensalista
        if(mensalistas.contains(placa)) {
            return valorAcessoMensalista;
        }

        // Noturno
        if(minutosEntrada >= minutosInicioNoturna && (minutosSaida <= 23 * 60 + 59 || minutosSaida <= minutosFimNoturna)) {
            return valorDiariaDiurna * valorDiariaNoturna / 100;
        }
        // Diária diurna
        if(minutosSaida < minutosEntrada) {
            totalMinutos = minutosSaida + ((23 * 60 + 59) - minutosEntrada);
        } else {
            totalMinutos = minutosSaida - minutosEntrada;
        }

        if(totalMinutos > 9*60){
            return valorDiariaDiurna;
        }

        // hora cheia
        return fracoes * valorFracao * (1 - (valorHoraCheia / 100));
    }

    public float cadastrarAcessoEvento(String placa, String horaEntrada, String horaSaida) {
        return valorAcessoEvento;
    }

    public void cadastrarMensalista(String placa){
        mensalistas.add(placa);
    }
}

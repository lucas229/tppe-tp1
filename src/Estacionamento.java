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
        int capacidade, float retornoContratante) throws DescricaoEmBrancoException, ValorAcessoInvalidoException {
            if(nome.isEmpty()){
                throw new DescricaoEmBrancoException("nome");
            } else if(valorFracao < 0){
                throw new ValorAcessoInvalidoException("fração de tempo");
            } else if(valorHoraCheia < 0 || valorHoraCheia > 100){
                throw new ValorAcessoInvalidoException("valor hora cheia");
            } else if(valorDiariaDiurna < 0){
                throw new ValorAcessoInvalidoException("valor diária diurna");
            } else if(valorDiariaNoturna < 0 || valorDiariaNoturna > 100){
                throw new ValorAcessoInvalidoException("valor diária noturna");
            }  else if(inicioDiariaNoturna.isEmpty()){
                throw new DescricaoEmBrancoException("Inicio da diária noturna");
            } else if(fimDiariaNoturna.isEmpty()){
                throw new DescricaoEmBrancoException("Fim da diária noturna");
            } else if(valorAcessoMensalista < 0){
                throw new ValorAcessoInvalidoException("valor acesso mensalista");
            } else if(valorAcessoEvento < 0){
                throw new ValorAcessoInvalidoException("valor acesso por evento");
            } else if(inicioFuncionamento.isEmpty()){
                throw new DescricaoEmBrancoException("Início do funcionamento");   
            } else if(fimFuncionamento.isEmpty()){
                throw new DescricaoEmBrancoException("Fim do funcionamento");   
            } else if( capacidade < 0){
                throw new ValorAcessoInvalidoException("capacidade");
            } else if(retornoContratante < 0 || retornoContratante > 100){
                throw new ValorAcessoInvalidoException("valor de retorno contratante");
            }   

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

    public float cadastrarAcesso(String placa, String horaEntrada, String horaSaida) throws DescricaoEmBrancoException {
        
        if(placa.isEmpty()){
            throw new DescricaoEmBrancoException("placa");
        } else if(horaEntrada.isEmpty()){
            throw new DescricaoEmBrancoException("hora de entrada");
        } else if(horaSaida.isEmpty()){
            throw new DescricaoEmBrancoException("hora de saída");
        }
        
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

        // fração de tempo
        float valorDeAcesso = (fracoes % 4) * valorFracao;
        
        // hora cheia
        if(fracoes > 3){
            int horasCheias = fracoes / 4; 
            valorDeAcesso =  valorDeAcesso + horasCheias * 4 * valorFracao * (1 - (valorHoraCheia / 100));
        }
        
        return valorDeAcesso;
    }

    public float cadastrarAcessoEvento(String placa, String horaEntrada, String horaSaida) {
        return valorAcessoEvento;
    }

    public void cadastrarMensalista(String placa){
        mensalistas.add(placa);
    }
}

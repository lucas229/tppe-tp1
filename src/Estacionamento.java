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
    private int numeroAcessos;
    private float valorApurado;

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
            numeroAcessos = 0;
    }
    
    private void validarAcesso(String placa, String horaEntrada, String horaSaida) throws DescricaoEmBrancoException, CapacidadeException, HorarioInvalidoException {
        validarCadastro(placa, horaEntrada, horaSaida);
        
        validarCapacidade();

        int minutosEntrada = calcularMinutos(horaEntrada);
        int minutosSaida = calcularMinutos(horaSaida);

        validarHorario(minutosEntrada, minutosSaida, horaEntrada, horaSaida);

        numeroAcessos +=1;
    }

    private void validarCadastro(String placa, String horaEntrada, String horaSaida) throws DescricaoEmBrancoException {
        if(placa.isEmpty()){
            throw new DescricaoEmBrancoException("placa");
        } else if(horaEntrada.isEmpty()){
            throw new DescricaoEmBrancoException("hora de entrada");
        } else if(horaSaida.isEmpty()){
            throw new DescricaoEmBrancoException("hora de saída");
        }
    }


    private void validarCapacidade() throws CapacidadeException {
        
        if(numeroAcessos == capacidade) {
            throw new CapacidadeException(capacidade);
        }
    }

    private void validarHorario(int minutosEntrada, int minutosSaida, String horaEntrada, String horaSaida) throws HorarioInvalidoException {

        int minutosInicioFuncionamento = calcularMinutos(inicioFuncionamento);
        int minutosFimFuncionamento = calcularMinutos(fimFuncionamento);

        if(minutosEntrada < minutosInicioFuncionamento || minutosSaida > minutosFimFuncionamento) {
            throw new HorarioInvalidoException(horaEntrada, horaSaida);
        }

    }

    private int calcularMinutos(String hora) {
        return Integer.parseInt(hora.split(":")[0]) * 60 + Integer.parseInt(hora.split(":")[1]);
    }

    private int calcularFracoes(int minutosEntrada, int minutosSaida) {
        return (minutosSaida - minutosEntrada) / 15;
    }

    private boolean checarMensalista(String placa) {
        if(mensalistas.contains(placa)) {
            valorApurado += valorAcessoMensalista;
            return true;
        }
        return false;
    }

    private boolean checarAcessoNoturno(int minutosEntrada, int minutosSaida) {
        int minutosInicioNoturna = calcularMinutos(inicioDiariaNoturna);
        int minutosFimNoturna = calcularMinutos(fimDiariaNoturna);

        if(minutosEntrada >= minutosInicioNoturna && (minutosSaida <= 23 * 60 + 59 || minutosSaida <= minutosFimNoturna)) {
            valorApurado += valorDiariaDiurna * valorDiariaNoturna / 100;
            return true;
        }

        return false; 
    }

    private boolean checarAcessoDiurno(int minutosEntrada, int minutosSaida ) {
        int totalMinutos;

        if(minutosSaida < minutosEntrada) {
            totalMinutos = minutosSaida + ((23 * 60 + 59) - minutosEntrada);
        } else {
            totalMinutos = minutosSaida - minutosEntrada;
        }

        if(totalMinutos > 9*60){
            valorApurado += valorDiariaDiurna;
            return true;
        }

        return false;
    }

    private float calcularValorAcessoNoturno() {
        return valorDiariaDiurna * valorDiariaNoturna / 100;
    }

    private float calcularValorFracaoTempo(int fracoes) {
        return (fracoes % 4) * valorFracao;
    }

    private float cadastrarAcessoFracao(int minutosEntrada, int minutosSaida) {
        int fracoes = calcularFracoes(minutosEntrada, minutosSaida);
        float valorDeAcesso = calcularValorFracaoTempo(fracoes);
        
        if(fracoes > 3){
            int horasCheias = fracoes / 4; 
            valorDeAcesso =  valorDeAcesso + horasCheias * 4 * valorFracao * (1 - (valorHoraCheia / 100));
        }

        valorApurado += valorDeAcesso;
        return valorDeAcesso;
    }

    public float cadastrarAcesso(String placa, String horaEntrada, String horaSaida) throws DescricaoEmBrancoException, HorarioInvalidoException, CapacidadeException {
        validarAcesso(placa, horaEntrada, horaSaida);

        int minutosEntrada = calcularMinutos(horaEntrada);
        int minutosSaida = calcularMinutos(horaSaida);
        
        if(checarMensalista(placa)) {
            return valorAcessoMensalista;
        }

        if(checarAcessoNoturno(minutosEntrada, minutosSaida)) {
            return calcularValorAcessoNoturno();
        }

        if(checarAcessoDiurno(minutosEntrada, minutosSaida)) {
            return valorDiariaDiurna;
        }

        return cadastrarAcessoFracao(minutosEntrada, minutosSaida);
    }

    public float cadastrarAcessoEvento(String placa, String horaEntrada, String horaSaida) throws CapacidadeException, DescricaoEmBrancoException {
        if(placa.isEmpty()){
            throw new DescricaoEmBrancoException("placa");
        } else if(horaEntrada.isEmpty()){
            throw new DescricaoEmBrancoException("hora de entrada");
        } else if(horaSaida.isEmpty()){
            throw new DescricaoEmBrancoException("hora de saída");
        }
        
        if(numeroAcessos == capacidade){
            throw new CapacidadeException(capacidade);
        }
        numeroAcessos++;
        valorApurado += valorAcessoEvento;
        return valorAcessoEvento;
    }

    public void cadastrarMensalista(String placa){
        numeroAcessos++;
        valorApurado += valorAcessoMensalista;
        mensalistas.add(placa);
    }

	public float getValorApurado() {
		return valorApurado * retornoContratante/100;
	}
        
}

public class HorarioInvalidoException extends Exception {

    private String horaEntrada;
    private String horaSaida;

    public HorarioInvalidoException(String horaEntrada, String horaSaida) {
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
    }

    @Override
    public String getMessage() {
        return "O horário de " + horaEntrada + " - " + horaSaida + " está fora do horário de funcionamento";
    }

}

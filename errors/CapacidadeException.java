public class CapacidadeException extends Exception {
    private int capacidade;

    public CapacidadeException(int capacidade) {
        this.capacidade = capacidade;
    }

    @Override
    public String getMessage() {
        return "O estacionamento já atingiu a capacidade máxima de " + capacidade;
    }
}

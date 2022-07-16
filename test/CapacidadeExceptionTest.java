import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CapacidadeExceptionTest {
    Estacionamento estacionamento;

    @Before
    public void setup() throws DescricaoEmBrancoException, ValorAcessoInvalidoException {
        estacionamento = new Estacionamento("Estac. 2", 20, 10, 70, 30, "21:00", "7:00", 455, 60, "0:00", "23:59", 1, 60);
    }

    @Test(expected = CapacidadeException.class)
    @Category(TesteExcecao.class)
    public void testCapacidadeMaxima() throws DescricaoEmBrancoException, HorarioInvalidoException, CapacidadeException {
        estacionamento.cadastrarAcesso("ABCD123", "10:40", "10:55");
        estacionamento.cadastrarAcesso("ABCD123", "11:00", "12:55");
    }
}

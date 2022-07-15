import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CadastroEstacionamentoExceptionTest {
    Estacionamento estacionamento;

    @Test(expected = DescricaoEmBrancoException.class)
    @Category(TesteExcecao.class)
    public void testCadastroEstacionamentoCampoEmBranco() throws DescricaoEmBrancoException, ValorAcessoInvalidoException{
        estacionamento = new Estacionamento("", 30, 15, 120, 45, "19:00", "8:00", 600, 50, "6:00", "22:00", 300, 50);
    }

    @Test(expected = ValorAcessoInvalidoException.class)
    @Category(TesteExcecao.class)
    public void testCadastroEstacionamentoValorAcessoInvalido() throws DescricaoEmBrancoException, ValorAcessoInvalidoException{
        estacionamento = new Estacionamento("Estac. 1", -40, 15, 120, 45, "19:00", "8:00", 600, 50, "6:00", "22:00", 300, 50);
    }
}

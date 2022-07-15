import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CadastroAcessoExceptionTest {
    Estacionamento estacionamento;
    String placa, horaEntrada, horaSaida; 
    
    @Parameters
	public static List<Object[]> getParameters() {
		Object[][] parameters = new Object[][] {
			{"", "8:30", "8:45"},
			{"HI139", "", "9:00"},
			{"HI139", "8:30", ""},
		};

		return Arrays.asList(parameters);
	}

    @Before
    public void setup() throws DescricaoEmBrancoException, ValorAcessoInvalidoException{
        estacionamento = new Estacionamento("Estac. 2", 20, 10, 70, 30, "21:00", "7:00", 455, 60, "0:00", "23:59", 120, 60);
    }

    public CadastroAcessoExceptionTest(String placa, String horaEntrada, String horaSaida){
        this.placa = placa;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
    }

    @Test(expected = DescricaoEmBrancoException.class)
    @Category(TesteExcecao.class)
    public void testCadastroAcessoException() throws DescricaoEmBrancoException{
        estacionamento.cadastrarAcesso(placa, horaEntrada, horaSaida);
    }
}

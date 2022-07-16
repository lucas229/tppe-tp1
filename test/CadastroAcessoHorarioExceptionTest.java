import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CadastroAcessoHorarioExceptionTest {
    Estacionamento estacionamento;
    String placa, horaEntrada, horaSaida; 
    
    @Parameters
	public static List<Object[]> getParameters() {
		Object[][] parameters = new Object[][] {
			{"HI139", "5:30", "17:45"},
			{"HI139", "14:00", "21:00"},
			{"HI139", "18:00", "18:15"},
		};

		return Arrays.asList(parameters);
	}

    @Before
    public void setup() throws DescricaoEmBrancoException, ValorAcessoInvalidoException {
        estacionamento = new Estacionamento("Estac. 2", 20, 10, 70, 30, "21:00", "7:00", 455, 60, "6:00", "17:30", 120, 60);
    }

    public CadastroAcessoHorarioExceptionTest(String placa, String horaEntrada, String horaSaida) {
        this.placa = placa;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
    }

    @Test(expected = HorarioInvalidoException.class)
    @Category(TesteExcecao.class)
    public void testCadastroAcessoHorarioException() throws DescricaoEmBrancoException, HorarioInvalidoException, CapacidadeException {
        estacionamento.cadastrarAcesso(placa, horaEntrada, horaSaida);
    }
}

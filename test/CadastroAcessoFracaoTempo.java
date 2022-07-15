import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class CadastroAcessoFracaoTempo {
    private Estacionamento estacionamento;
    private String placa;
    private String horaEntrada;
    private String horaSaida;
    private float resultado;

	@Parameters
	public static List<Object[]> getParameters() {
		Object[][] parameters = new Object[][] {
			{"HI139", "8:30", "8:45", 20},
			{"HI139", "8:30", "9:00", 40},
			{"HI139", "8:30", "9:15", 60},
			{"HI139", "8:30", "9:45", 92},
			{"HI139", "18:05", "20:46", 184},
			{"HI139", "11:07", "14:03", 204},
		};

		return Arrays.asList(parameters);
	}

    @Before
    public void setup() {
        estacionamento = new Estacionamento("Estac. 2", 20, 10, 70, 30, "21:00", "7:00", 455, 60, "0:00", "23:59", 120, 60);
    }

	public CadastroAcessoFracaoTempo(String placa, String horaEntrada, String horaSaida, float resultado) {
		this.placa = placa;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
		this.resultado = resultado;
	}

    @Test
	@Category(TesteFuncional.class)
    public void testCadastroFracaoTempo() throws DescricaoEmBrancoException {
        assertEquals(resultado, estacionamento.cadastrarAcesso(placa, horaEntrada, horaSaida), 0.01);
    }
}

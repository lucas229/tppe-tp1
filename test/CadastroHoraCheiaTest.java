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
public class CadastroHoraCheiaTest {

    private Estacionamento estacionamento;
    private String placa;
    private String horaEntrada;
    private String horaSaida;
    private float resultado;

	@Parameters
	public static List<Object[]> getParameters() {
		Object[][] parameters = new Object[][] {
			{"HI139", "8:30", "9:30", 72},
			{"HI139", "8:30", "10:30", 144},
			{"HI139", "8:30", "11:30", 216}
		};

		return Arrays.asList(parameters);
	}

    @Before
    public void setup() throws DescricaoEmBrancoException, ValorAcessoInvalidoException {
        estacionamento = new Estacionamento("Estac. 2", 20, 10, 70, 30, "21:00", "7:00", 455, 60, "0:00", "23:59", 120, 60);
    }

	public CadastroHoraCheiaTest(String placa, String horaEntrada, String horaSaida, float resultado) {
		this.placa = placa;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
		this.resultado = resultado;
	}
   
    @Test
	@Category(TesteFuncional.class)
    public void testCadastroHoraCheia() throws DescricaoEmBrancoException {
        assertEquals(resultado, estacionamento.cadastrarAcesso(placa, horaEntrada, horaSaida), 0.01);
    }

}

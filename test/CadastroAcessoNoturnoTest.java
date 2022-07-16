import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import java.util.List;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
public class CadastroAcessoNoturnoTest {

    private String placa;
    private String horaEntrada;
    private String horaSaida;
    private Estacionamento estacionamento;
    private float resultado;

	@Parameters
	public static List<Object[]> getParameters() throws DescricaoEmBrancoException, ValorAcessoInvalidoException {
        Estacionamento estacionamento1 = new Estacionamento("Estac. 1", 30, 15, 120, 45, "19:00", "8:00", 600, 50, "6:00", "22:00", 300, 50);
        Estacionamento estacionamento2 = new Estacionamento("Estac. 2", 20, 10, 70, 30, "21:00", "9:00", 455, 60, "0:00", "23:59", 120, 60);
        Estacionamento estacionamento3 = new Estacionamento("Estac. 3", 10, 0, 50, 40, "20:00", "8:00", 350, 40, "6:00", "23:59", 600, 70);
		Object[][] parameters = new Object[][] {
			{"ABC123", "19:00", "19:30", estacionamento1, 54},
			{"DEF456", "21:00", "9:00", estacionamento2, 21},
			{"DEF456", "20:30", "23:59", estacionamento3, 20}
		};

		return Arrays.asList(parameters);
	}

    public CadastroAcessoNoturnoTest(String placa, String horaEntrada, String horaSaida, Estacionamento estacionamento, float resultado) {
        this.placa = placa;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
        this.estacionamento = estacionamento;
        this.resultado = resultado;
    }

    @Test
    @Category(TesteFuncional.class)
    public void testCadastroAcessoNoturno() throws DescricaoEmBrancoException, HorarioInvalidoException {
        assertEquals(resultado, estacionamento.cadastrarAcesso(placa, horaEntrada, horaSaida), 0.01);
    }

}

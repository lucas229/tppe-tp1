import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CadastroAcessoDiurnoTest {
    private Estacionamento estacionamento; 
    private String placa;
    private String horaEntrada, horaSaida;
    private float resultado;

   	@Parameters
	public static List<Object[]> getParameters() throws DescricaoEmBrancoException, ValorAcessoInvalidoException {
        Estacionamento estacionamento1 = new Estacionamento("Estac. 1", 30, 15, 120, 45, "19:00", "8:00", 600, 50, "6:00", "22:00", 300, 50);
        Estacionamento estacionamento2 = new Estacionamento("Estac. 2", 20, 10, 70, 30, "21:00", "9:00", 455, 60, "0:00", "23:59", 120, 60);
        Estacionamento estacionamento3 = new Estacionamento("Estac. 3", 10, 0, 50, 40, "20:00", "8:00", 350, 40, "0:00", "22:00", 600, 70);
		Object[][] parameters = new Object[][] {
			{"ABC123", "12:00", "21:01", estacionamento1, 120},
			{"DEF456", "17:00", "9:00", estacionamento2, 70},
			{"ZXC374", "00:00", "15:00", estacionamento3, 50}
		};

		return Arrays.asList(parameters);
	}
    
    public CadastroAcessoDiurnoTest(String placa, String horaEntrada, String horaSaida, Estacionamento estacionamento, float resultado) {
		this.placa = placa;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
        this.estacionamento = estacionamento;
		this.resultado = resultado;
	}

    @Test
	@Category(TesteFuncional.class)
    public void testCadastroDiurno() throws DescricaoEmBrancoException, HorarioInvalidoException, CapacidadeException {
        assertEquals(resultado, estacionamento.cadastrarAcesso(placa, horaEntrada, horaSaida), 0.01);
    }
}

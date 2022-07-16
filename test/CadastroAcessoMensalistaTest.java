import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CadastroAcessoMensalistaTest {
    private Estacionamento estacionamento; 
    private String placa;
    private String horaEntrada, horaSaida;
    private float resultado;

   	@Parameters
	public static List<Object[]> getParameters() throws DescricaoEmBrancoException, ValorAcessoInvalidoException {
        Estacionamento estacionamento1 = new Estacionamento("Estac. 1", 30, 15, 120, 45, "19:00", "8:00", 600, 50, "0:00", "23:59", 300, 50);
        Estacionamento estacionamento2 = new Estacionamento("Estac. 2", 20, 10, 70, 30, "21:00", "10:30", 455, 60, "0:00", "23:59", 120, 60);
        Estacionamento estacionamento3 = new Estacionamento("Estac. 3", 10, 0, 50, 40, "20:00", "8:00", 350, 40, "1:00", "23:59", 600, 70);
		Object[][] parameters = new Object[][] {
			{"ABC123", "00:00", "23:59", estacionamento1, 600},
			{"DEF456", "21:09", "10:04", estacionamento2, 455},
			{"ZXC374", "23:50", "1:14", estacionamento3, 350}
		};

		return Arrays.asList(parameters);
	}
    
    public CadastroAcessoMensalistaTest(String placa, String horaEntrada, String horaSaida, Estacionamento estacionamento, float resultado) {
		this.placa = placa;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
        this.estacionamento = estacionamento;
		this.resultado = resultado;
	}

    @Test
	@Category(TesteFuncional.class)
    public void testCadastroMensalista() throws DescricaoEmBrancoException, HorarioInvalidoException, CapacidadeException {
		estacionamento.cadastrarMensalista(placa);
        assertEquals(resultado, estacionamento.cadastrarAcesso(placa, horaEntrada, horaSaida), 0.01);
    }   
}

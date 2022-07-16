import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ValorApuradoTest {
    
    private Estacionamento estacionamento;
    private Object[][] acessos;
    private float resultado;

    @Parameters
	public static List<Object[]> getParameters() {
		Object[][] parameters = new Object[][] {
			{
                new Object[][] {
                    {"AFG123", "8:00", "9:00"},
                }, 36
            },
            {
                new Object[][] {
                    {"AFG123", "8:00", "9:00"},
                    {"AUI123", "10:00", "19:15"},
            }, 78
            },
            {
                new Object[][]{
                    {"AFG123", "8:00", "9:00"},
                    {"AUI123", "10:00", "19:15"},
                    {"LLL123", "10:00", "10:46"},
                }, 114
            }
		};

		return Arrays.asList(parameters);
	}

    public ValorApuradoTest(Object[][] acessos, float resultado) {
        this.acessos = acessos;
        this.resultado = resultado;
    }
    
    @Before()
    public void setup() throws DescricaoEmBrancoException, ValorAcessoInvalidoException{
        estacionamento = new Estacionamento("Estac. 2", 20, 10, 70, 30, "21:00", "7:00", 455, 60, "0:00", "23:59", 120, 60);
    }


    @Test()
    public void testValorApurado() throws DescricaoEmBrancoException, HorarioInvalidoException {
        int count = 0;
        for(Object[] acesso : acessos) {
            String placa = String.valueOf(acesso[0]);
            String horaEntrada = String.valueOf(acesso[1]);
            String horaSaida = String.valueOf(acesso[2]);

            if(count == 0) {
                estacionamento.cadastrarAcessoEvento(placa, horaEntrada,horaSaida);
            } else {
                estacionamento.cadastrarAcesso(placa, horaEntrada,horaSaida);
            }
            count ++;
        }
        assertEquals(resultado, estacionamento.getValorApurado(), 0.01);
    }
}

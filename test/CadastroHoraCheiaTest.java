import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CadastroHoraCheiaTest {

    Estacionamento estacionamento;

    @Before
    public void setup() {
        estacionamento = new Estacionamento("Estac. 2", 20, 10, 70, 30, "21:00", "7:00", 455, 60, "0:00", "23:59", 120, 60);
    }

    @Test
    public void testCadastroUmaHoraCheia() {
        assertEquals(72, estacionamento.cadastrarAcesso("HI139", "8:30", "9:30"), 0.01);
    }

}

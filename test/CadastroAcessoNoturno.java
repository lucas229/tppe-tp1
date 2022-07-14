import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CadastroAcessoNoturno {
    
    private Estacionamento estacionamento1;
    private Estacionamento estacionamento2;

    @Before
    public void setup() {
        estacionamento1 = new Estacionamento("Estac. 1", 30, 15, 120, 45, "19:00", "8:00", 600, 50, "6:00", "22:00", 300, 50);
        estacionamento2 = new Estacionamento("Estac. 2", 20, 10, 70, 30, "21:00", "9:00", 455, 60, "0:00", "23:59", 120, 60);
    }

    @Test
    public void testCadastroAcessoNoturno1() {
        assertEquals(54, estacionamento1.cadastrarAcesso("ABC123", "19:00", "19:30"), 0.01);
    }

    @Test
    public void testCadastroAcessoNoturno2() {
        assertEquals(21, estacionamento2.cadastrarAcesso("DEF456", "21:00", "9:00"), 0.01);
    }

}

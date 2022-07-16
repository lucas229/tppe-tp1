import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ValorApuradoTest {
    
    private Estacionamento estacionamento;
    
    @Before()
    public void setup() throws DescricaoEmBrancoException, ValorAcessoInvalidoException{
        estacionamento = new Estacionamento("Estac. 2", 20, 10, 70, 30, "21:00", "7:00", 455, 60, "0:00", "23:59", 120, 60);
    }
    
    @Test()
    public void testValorApuradoUmAcesso() {
        estacionamento.cadastrarAcessoEvento("AFG123", "8:00", "9:00");
        assertEquals(36, estacionamento.getValorApurado(), 0.01);
    }

}

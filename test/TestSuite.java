import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses({
   CadastroAcessoDiurnoTest.class,
   CadastroAcessoEventoTest.class,
   CadastroAcessoExceptionTest.class,
   CadastroAcessoFracaoTempo.class,
   CadastroAcessoMensalistaTest.class,
   CadastroAcessoNoturnoTest.class,
   CadastroEstacionamentoExceptionTest.class,
   CadastroHoraCheiaTest.class
})

@RunWith(Suite.class)
public class TestSuite {

}

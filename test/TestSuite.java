import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory({TesteExcecao.class, TesteFuncional.class})
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
public class TestSuite {

}

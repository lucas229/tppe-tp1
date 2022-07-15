
public class DescricaoEmBrancoException  extends Exception{
    private String campoEmBranco;


    public DescricaoEmBrancoException(String campoEmBranco){
        this.campoEmBranco = campoEmBranco;
    }

  @Override
  public String getMessage() {
    return "O atributo " + campoEmBranco + " não pode estar em branco";
  }

}

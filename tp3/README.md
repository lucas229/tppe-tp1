# Simplicidade

## Descrição
Um código simples é fácil de entender e de implementar, além de ser coerente e consistente. Não é fácil criar um projeto simples, porém deve-se evitar o uso exagerado de threads, escolha incorreta de algoritmos, esquemas de nomenclatura complexos e uso inadequado de módulos de dependências. Um código simples resulta em baixo acoplamento e alta coesão.

## Maus-cheiros
- Método longo: Métodos muito grandes dificultam o entendimento do código.
- Longa lista de parâmetros: longas listas de parâmetros dificultam o entendimento e a utilização do método.
- Aglomerado de dados: esse mau cheiro de código é identificado quando alguns itens de dados aparecem em conjunto em alguns pedaços do código de diversas formas possíveis.
- Classe grande: Uma classe que apresenta muitas variáveis de instância resulta em uma baixa coesão.

## Operações
- Extrair método: Dividir um método grande em partes menores pode ajudar a aumentar a coesão e reduzir o acoplamento.
- Substituir parâmetro por método: Fazer uma chamada a um objeto que possua o dado para obter o dado desejado.
- Extrair classe: Permite agrupar variáveis que em conjunto fazem sentido para o projeto.

# Ausência de duplicidade

## Descrição
Um código bem desenhado não contém duplicações. Isso significa que um código nunca deve se repetir. Porém, uma prática comum é o copia-e-cola no momento do desenvolvimento, o que acaba gerando a duplicação do código. Isso pode resultar em uma fragilidade no programa, pois quando há necessidade de alteração do trecho de código, pode-se esquecer de alterar em outras partes onde o código original se repete. Por outro lado, a aplicação dessa característica de um bom projeto de software contribui para a manutenibilidade da aplicação. 

## Maus-cheiros
- Código duplicado: Esse mau cheiro de código é identificado quando o mesmo trecho de código aparece em vários pontos do projeto.
- Instrução switch: Esse mau cheiro de código é identificado pelo uso da mesma instrução switch em em diversos pontos do código.

## Operações
- Extrair método: Quando um mesmo trecho de código aparece em locais diferentes podemos transformar aquela operação em um método/função, evitando duplicações. 
- Trocar tipo por subclasse ou trocar tipo por State / Strategy: Uma vez que o método esteja no local correto consiste na alteração do método de maneira que utilize polimorfismo.

# Extensibilidade

## Descrição
Essa característica de um código bem projetado permite a implementação de novas funcionalidades em locais apropriados quando necessário. É importante definir o que precisa ser implementado agora e o que será implementado depois para definir o nível da extensibilidade e assim evitar o alto acoplamento.

## Maus-cheiros
- Herança negada: Ocorre quando subclasses herdam métodos e atributos que não serão utilizados por ela.
- Cadeias de mensagens: Acontece quando um objeto chama outro, que chama outro, e assim sucessivamente.

## Operações
- Descer método/campo: Consiste em mover os métodos e atributos para a classe irmã da que rejeita a herança.
- Extrair método/mover método: Realizar a extração do trecho de código utilizado pelo cliente e movê-lo para os pontos iniciais da cadeia.

# Boas interfaces 

## Descrição
A interface é o caminho para as funcionalidades de um determinado módulo, servindo como um ponto de contato entre o cliente e as funcionalidades internas do módulo. Sendo assim, a qualidade da interface irá determinar a qualidade do módulo para a composição do sistema.

## Maus-cheiros
- Biblioteca de classes incompleta: Esse mau cheiro é identificado quando bibliotecas de classes não oferecem todos os recursos dos quais precisamos. 
- Intimidade inapropriada: Ocorre quando uma classe se torna muito íntima da outra, o que permite que ela investigue as partes privadas das outras classes.

## Operações
- Ocultar delegação: impedir que o cliente de uma classe conheça o método que executa a delegação de uma tarefa. 
- Introduzir extensão local: adicionar funcionalidades ainda não implementadas pela biblioteca.

# Elegância

## Descrição
A elegância está de acordo com a simplicidade. Um projeto de software que possui essa característica não está lotado de casos especiais, mas cada parte agrega valor a outra e as mudanças só precisam ser feitas em um local, resultando em um código bem projetado, estruturado, inteligente e não muito complexo.

## Maus-cheiros
- Cirurgia com rifle: Ocorre quando ao realizar uma mudança, várias classes devem sofrer modificação, havendo o risco de alguma mudança ser esquecida.
- Classe preguiçosa: Presença de classe no projeto que não possui comportamento suficiente para ser mantida no projeto.

## Operações
- Mover método ou mover campo: colocar todas as variações em uma única classe.
- Incorporar classe: agrupar um conjunto de comportamentos em uma única estrutura
- Mover método e mover atributo: levar os elementos presentes na classe preguiçosa para outras classes onde são mais coerentes.

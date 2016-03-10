#### Leitura de inputs ####
 * Usar o sqlite para guardar informação sobre a informação dos trabalhadores e tarefas. Deveram existir diversas bases de dados com a mesma estrutura mas com diferentes inserts.

#### Objetivos ####
 * Alocar trabalhadores de modo a que as tarefas sejam todas realizadas e que o custo seja o minimo

#### Restrições ####
 * Tarefas agrupadas em módulos
 * Tarefas do mesmo modulo utilizam a mesma linguagem de programação
 * Cada tarefa tem uma determinada tecnologia

#### Regras de negócio ####
 * Cada trabalhador possui uma ou mais especializações em tecnologias
 * Cada trabalhador é proficiente em uma ou mais linguagens de programação
 * Alocar um trabalhador tem um custo associado, diferente para cada trabalhador
 * Configurar tarefas necessárias
 * Configurar trabalhadores disponíveis

#### Dúvidas ####
 * Como é que definimos o custo associado à alocação de um determinado trabalhador (depende da linguagem e da especialização mas com que penalizações em números)?
 * Existem tarefas principais e secundárias?
 * As restrições mudam no decorrer da alocação? Se sim temos de ter em conta a disponibilidade dos trabalhadores.
 * um trabalhador faz a tarefa ate ao fim e termina o seu ciclo de vida? ou pode realizar outra tarefa de seguida?

#### Contributers ####
Joel Carneiro
Hugo Drumond
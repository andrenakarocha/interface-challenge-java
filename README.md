# Gestão de Desafios em Java

Este repositório apresenta a solução para os três desafios propostos na aula de 16/04/2025, utilizando o conceito de Interfaces em Java. Cada desafio foi implementado em um pacote distinto, seguindo uma estrutura organizada para facilitar a compreensão e a manutenção do código.

## Estrutura do Projeto

```
gestao-desafios-java/
├── campeonato/                # Pacote para o Desafio 1: Gestão de Campeonato de Futebol Feminino
│   ├── src/
│   │   └── main/
│   │       └── java/
│   │           └── com/seusistema/campeonato/
│   │               ├── entidades/
│   │               │   ├── Jogadora.java
│   │               │   └── Time.java
│   │               ├── interfaces/
│   │               │   └── (Opcional: Interfaces específicas do campeonato)
│   │               ├── negocio/
│   │               │   ├── Campeonato.java
│   │               │   └── Partida.java
│   │               └── main/
│   │                   └── Main.java
│   └── test/
│       └── java/
│           └── com/seusistema/campeonato/negocio/
│               ├── CampeonatoTest.java
│               └── PartidaTest.java
├── pedagios/                   # Pacote para o Desafio 3: Sistema de Controle de Pedágios no Estado de São Paulo
│   ├── src/
│   │   └── main/
│   │       └── java/
│   │           └── com/seusistema/pedagios/
│   │               ├── entidades/
│   │               │   ├── Pedagio.java
│   │               │   └── Veiculo.java
│   │               ├── interfaces/
│   │               │   └── CalculavelPedagio.java
│   │               ├── negocio/
│   │               │   ├── RegistroPassagem.java
│   │               │   └── RelatorioPedagios.java
│   │               └── main/
│   │                   └── Main.java
│   └── test/
│       └── java/
│           └── com/seusistema/pedagios/negocio/
│               ├── RegistroPassagemTest.java
│               └── RelatorioPedagiosTest.java
├── pessoas-especiais/          # Pacote para o Desafio 2: Cadastro e Acompanhamento de Pessoas com Necessidades Especiais
│   ├── src/
│   │   └── main/
│   │       └── java/
│   │           └── com/seusistema/pessoasespeciais/
│   │               ├── entidades/
│   │               │   ├── Atendimento.java
│   │               │   └── Pessoa.java
│   │               ├── interfaces/
│   │               │   └── Filtravel.java
│   │               ├── negocio/
│   │               │   ├── CadastroPessoas.java
│   │               │   └── RelatorioAtendimentos.java
│   │               └── main/
│   │                   └── Main.java
│   └── test/
│       └── java/
│           └── com/seusistema/pessoasespeciais/negocio/
│               ├── CadastroPessoasTest.java
│               └── RelatorioAtendimentosTest.java
├── .gitignore                  # Especificação de arquivos ignorados pelo Git
└── README.md                   # Este arquivo, contendo a descrição do projeto
```
## Desafios Implementados

### Desafio 1: Gestão de Campeonato de Futebol Feminino

* **Tema:** Futebol Feminino
* **Objetivo:** Criar um sistema para gerenciar times, jogadoras, partidas e pontuação.
* **Funcionalidades:**
    * Cadastro de times (nome, cidade, lista de jogadoras).
    * Cadastro de jogadoras (nome, idade, posição, número da camisa).
    * Registro de partidas (dois times e placar final).
    * Cálculo automático de pontos (3 por vitória, 1 por empate, 0 por derrota).
    * Visualização da tabela de classificação.
* **Localização do Código:** `campeonato/src/main/java/com/seusistema/campeonato/`
* **Classe Main:** `campeonato/src/main/java/com/seusistema/campeonato/main/Main.java`
* **Testes Unitários:** `campeonato/src/test/java/com/seusistema/campeonato/negocio/`

### Desafio 2: Cadastro e Acompanhamento de Pessoas com Necessidades Especiais

* **Tema:** Pessoas com necessidades especiais
* **Objetivo:** Desenvolver um sistema que permita cadastrar pessoas com deficiência e acompanhar suas necessidades e atendimentos.
* **Funcionalidades:**
    * Cadastro de pessoas (nome, idade, tipo de deficiência, grau, endereço).
    * Cadastro de atendimentos realizados (data, tipo, profissional responsável) associados a cada pessoa.
    * Listagem de todas as pessoas.
    * Filtragem de pessoas por tipo de deficiência e grau.
    * Geração de relatório de atendimentos por pessoa.
* **Localização do Código:** `pessoas-especiais/src/main/java/com/seusistema/pessoasespeciais/`
* **Classe Main:** `pessoas-especiais/src/main/java/com/seusistema/pessoasespeciais/main/Main.java`
* **Testes Unitários:** `pessoas-especiais/src/test/java/com/seusistema/pessoasespeciais/negocio/`
* **Interface Utilizada:** `Filtravel` para definir o contrato de filtragem de pessoas.

### Desafio 3: Sistema de Controle de Pedágios no Estado de São Paulo

* **Tema:** Controle de Pedágios
* **Objetivo:** Criar um sistema para simular o controle de veículos que passam por pedágios em SP.
* **Funcionalidades:**
    * Registro da passagem de veículos (placa, tipo, eixos).
    * Definição de praças de pedágio (localização, tarifa-base).
    * Cálculo do valor cobrado por pedágio, dependendo do tipo de veículo.
    * Emissão de relatório de veículos e valores arrecadados por praça.
* **Localização do Código:** `pedagios/src/main/java/com/seusistema/pedagios/`
* **Classe Main:** `pedagios/src/main/java/com/seusistema/pedagios/main/Main.java`
* **Testes Unitários:** `pedagios/src/test/java/com/seusistema/pedagios/negocio/`
* **Interface Utilizada:** `CalculavelPedagio` para definir o contrato de cálculo do valor do pedágio.

## Como Executar os Desafios

1.  **Clone o Repositório:**
    ```bash
    git clone https://github.com/andrenakarocha/interface-challenge-java
    ```
2.  **Navegue até a Pasta do Desafio Desejado:**
    * Para o Desafio 1: `cd campeonato/src/main/java/com/seusistema/campeonato/main/`
    * Para o Desafio 2: `cd pessoas-especiais/src/main/java/com/seusistema/pessoasespeciais/main/`
    * Para o Desafio 3: `cd pedagios/src/main/java/com/seusistema/pedagios/main/`
3.  **Execute a Classe Main:**
    Utilize sua IDE para executar o arquivo `Main.java` dentro da pasta `main` de cada desafio. Certifique-se de que o ambiente Java (JDK) esteja configurado.

## Execução dos Testes Unitários

Os testes unitários foram implementados utilizando JUnit 5 para verificar a lógica de negócio de cada desafio.

1.  **Navegue até a Raiz do Projeto.**
2.  **Utilize sua IDE:** A maioria das IDEs oferece uma interface para executar os testes unitários localizados nas pastas `test/java`.
3.  **Utilize Maven (se configurado):** Execute o seguinte comando na raiz do projeto:
    ```bash
    mvn test
    ```
4.  **Utilize Gradle (se configurado):** Execute o seguinte comando na raiz do projeto:
    ```bash
    gradle test
    ```

## Observações

* O código foi desenvolvido em Java, seguindo boas práticas de programação e com comentários para facilitar o entendimento.
* O conceito de Interfaces foi aplicado para definir contratos e promover a flexibilidade do código.
* Testes unitários foram implementados para as principais funcionalidades de cada desafio, garantindo a integridade das regras de negócio.

Este repositório contém a solução completa para os três desafios, atendendo aos requisitos especificados.

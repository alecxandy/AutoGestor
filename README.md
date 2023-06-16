# README - Sistema AutoGestor GURU (Spring Boot)

Bem-vindo(a) ao Sistema de Autoescola desenvolvido em Spring Boot! Este sistema é uma solução abrangente para o gerenciamento eficiente e simplificado de uma autoescola, desde a matrícula dos alunos até a obtenção da carteira de habilitação. Siga as instruções abaixo para configurar e utilizar o sistema corretamente.

## Requisitos do Sistema

- Java 8 ou superior
- Maven
- Banco de dados (por exemplo, MySQL, PostgreSQL)

## Configuração do Banco de Dados

1. Crie um banco de dados vazio no seu sistema de banco de dados preferido.
2. Configure as informações de conexão com o banco de dados no arquivo `application.properties`, localizado no diretório `src/main/resources`. Por exemplo:
   ```
   spring.datasource.url=jdbc:mysql://localhost:3306/nome_do_banco
   spring.datasource.username=usuario
   spring.datasource.password=senha
   ```

## Executando o Sistema

1. Clone o repositório para o seu ambiente local.
2. Abra o terminal ou prompt de comando e navegue até o diretório raiz do projeto.
3. Execute o seguinte comando para compilar e empacotar o projeto:
   ```
   mvn clean package
   ```
4. Em seguida, execute o seguinte comando para iniciar o sistema:
   ```
   java -jar target/nome_do_arquivo.jar
   ```
5. O sistema estará disponível em `http://localhost:8080`.

## Configuração Adicional

- Para personalizar as configurações do sistema, consulte o arquivo `application.properties` no diretório `src/main/resources`.
- Certifique-se de configurar as credenciais corretas para envio de e-mails no arquivo `application.properties` para permitir o envio de notificações e lembretes automáticos aos alunos.
- Personalize as páginas, estilos e templates do sistema conforme necessário, localizados no diretório `src/main/resources/templates` e `src/main/resources/static`.

## Funcionalidades Principais

1. Cadastro de Alunos: Os alunos podem se inscrever na autoescola, fornecendo informações pessoais, contatos e documentos necessários.
2. Agendamento de Aulas Teóricas e Práticas: Os alunos podem agendar aulas teóricas e práticas de acordo com a disponibilidade dos instrutores.
3. Acompanhamento do Progresso do Aluno: O sistema registra o progresso de cada aluno, incluindo horas de aula concluídas, resultados de testes teóricos e habilidades de direção adquiridas.
4. Preparação para Exames: Recursos disponíveis para os alunos estudarem para os exames teóricos e práticos, incluindo materiais de estudo e simulados.
5. Emissão de Documentos: O sistema gera documentos importantes, como declarações de conclusão de curso, boletos de pagamento e requerimentos para exames.
6. Integração com Órgãos de Trânsito: O sistema se integra aos órgãos de trânsito, permitindo o envio de dados dos alunos, agendamento de exames e recebimento de notificações sobre o status dos processos.
7. Controle Financeiro: Possibilidade de registrar pagamentos de matrículas, mensalidades, taxas de exame e emitir rel

atórios financeiros detalhados.
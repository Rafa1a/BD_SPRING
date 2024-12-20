# API de Notificações
 
Este é um projeto de API que lida com notificações e informações de processos judiciais.

## Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas em sua máquina:

- Java SDK 17
- Spring Boot
- SQL server Microsoft

## Funcionalidades

- `/cep`:
  - **GET**: Retorna as notificações pendentes com informações de CEP.
    - Entrada:
      - Nenhuma entrada necessária.
    - Resposta:
      - Código 200: OK
      - Código 500: Internal Server Error

  - **PUT**: Altera o status de uma notificação com base no ID.
    - Entrada:
      - ID da notificação (integer)
      - Novo status (string)
    - Resposta:
      - Código 200: OK
      - Código 500: Internal Server Error

- `/dje`:
  - **GET**: Lista de notificações DJE.
    - Entrada:
      - Nenhuma entrada necessária.
    - Resposta:
      - Código 200: OK

  - **PUT**: Alterar status de notificação.
    - Entrada:
      - ID da notificação (integer)
      - Novo status (string)
    - Resposta:
      - Código 200: OK
      - Código 500: Erro ao editar o processo
      - Código 409: Processo já foi enviado ou possui dados adicionais

- `/notificacao`:
  - **POST**: Envia uma notificação por e-mail.
    - Entrada:
      - Número do processo (string)
      - Motivo da notificação (string)
    - Resposta:
      - Código 200: OK
      - Código 500: Erro ao enviar o e-mail

## Começando

Estas instruções ajudarão você a configurar e executar a API em sua máquina local para fins de desenvolvimento e teste.

1. Clone este repositório:

https://github.com/Rafa1a/BD_SPRING


2. Navegue até o diretório do projeto:

cd db_jpa

3. Configure as informações do banco de dados no arquivo [application.properties](./db_jpa/src/main/resources/application.properties).

4. Execute o aplicativo:

indo em `Spring Boot DashBoard` run. Instale em `Extensions`

O aplicativo estará rodando em `http://localhost:8080`.

## Documentação da API

A documentação da API pode ser acessada após a instalação de uma extensão para leitura de arquivos YAML/JSON, como o OpenAPI Swagger no Visual Studio Code. [Documentação](./db_jpa/src/main/java/com/bdjpa/db_jpa/documentacao/documentacao.yml)

## Contribuindo

Sinta-se à vontade para contribuir com este projeto. Se você encontrar problemas ou tiver sugestões, abra uma issue neste repositório.

## Autores

- Rafael Leal Altero `Identificação Faculdadade`:202205021882
- Wallace Felipe Tavares Moreira `Identificação Faculdadade`:202109237331
- Ruan Hernandes Finamor Correia `Identificação Faculdadade`:202208175252
- Maiara Accacio Machado `Identificação Faculdadade`:202204268183
- Rodrigo de Oliveira Alarcon `Identificação Faculdadade`:202204482321
- Mariana Lucas Fernandes Onorio `Identificação Faculdadade`:202204465469
## Licença

Este projeto está licenciado sob a Licença MIT - consulte o arquivo [LICENSE](LICENSE) para obter detalhes.



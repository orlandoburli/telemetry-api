# Telemetry v1

## Contexto

Nosso cliente, iComida, precisa de uma api que será consumida pelo aplicativo mobile. Ele necessita que sejam identificadas pelo CPF do entregador, e que receba sua coordenada geográfica, bem como o status de bateria do mesmo.


## User histories

### 1) Api de coleta de dados (telemetria)

Construa uma ou mais api's que:

- Receba, em uma mesma requisição, as coordenadas geográficas (latitude,longitude) e o percentual de bateria de celular.

  - Armazene estes dados em uma tabela com o histórico desses dados

  - Armazene, em outra tabela, apenas o ultimo dado (coordenadas) do entregador.

  - Armazene também, em outra tabela, o status da bateria, e o status do entregador. Inicialmente, vamos armazenar apenas o valor ATIVO.

Requisitos:

  - Faça cobertura de testes unitários e testes de integração;

# Projeto de Reconciliação Financeira

## 📌 Sobre o Projeto

O **Projeto de Reconciliação Financeira** simula um serviço responsável por validar a consistência de transações financeiras, garantindo que os dados processados entre os serviços estejam corretos e sincronizados.

O objetivo principal é comparar informações como:

- Status do pagamento
- Status do antifraude
- Valor da transação
- Resultado final da reconciliação

Com isso, o sistema consegue identificar inconsistências no fluxo financeiro e gerar um resultado confiável sobre o processamento da transação.

---

# 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Docker
- Docker Compose
- Cache com Spring Cache

---

# 🏗️ Arquitetura do Projeto

O projeto foi pensado simulando um fluxo bancário dividido em serviços independentes.

Fluxo atual:

```text
Transação → Antifraude → Pagamento → Reconciliação
```

Cada serviço possui sua própria responsabilidade dentro do fluxo financeiro.

---

# 📊 Arquitetura Geral
<img width="644" height="457" alt="Reconciliação" src="https://github.com/user-attachments/assets/719d81e0-9df4-44a1-9d7e-156c6e0e3a91" />


---

# 🧠 Modelagem do Sistema

A modelagem representa a relação entre os domínios da aplicação.
<img width="745" height="261" alt="Modelagem da Reconciliação" src="https://github.com/user-attachments/assets/9feea28f-96b2-4dd8-b2a3-e4fb512d372f" />


---

# 📦 Estrutura das Entidades

## Transação

Responsável por armazenar os dados iniciais da operação financeira.

| Campo | Tipo |
|---|---|
| id | Long |
| contaOrigem | String |
| contaDestino | String |
| tipoTransacao | String |
| valor | BigDecimal |
| data | LocalDateTime |

---

## Antifraude

Responsável pela análise de risco da transação.

| Campo | Tipo |
|---|---|
| id | Long |
| transacaoId | Long |
| score | Integer |
| status | Enum |
| dataAnalise | LocalDateTime |

---

## Pagamento

Responsável pela confirmação do processamento financeiro.

| Campo | Tipo |
|---|---|
| id | Long |
| transacaoId | Long |
| status | Enum |
| tipoPagamento | String |

---

## Reconciliação

Responsável pela validação final do fluxo.

| Campo | Tipo |
|---|---|
| id | Long |
| transacaoId | Long |
| statusPagamento | Enum |
| statusAntifraude | Enum |
| valorTransacao | BigDecimal |
| detalhes | String |

---

# 🔄 Fluxo da Reconciliação

A reconciliação realiza validações entre:

- Resultado do antifraude
- Status do pagamento
- Valor da transação

Exemplo:

| Pagamento | Antifraude | Resultado |
|---|---|---|
| CONCLUIDO | APROVADO | Sucesso |
| CANCELADO | REJEITADO | Falha |
| PENDENTE | PENDENTE | Em análise |

---


---

# ▶️ Como Executar

## 1. Clonar o repositório

```bash
git clone <URL_DO_REPOSITORIO>
```

---

## 2. Subir os containers

```bash
docker compose up --build
```

---

# 📡 Endpoints

## Criar Reconciliação

### POST

```http
POST /reconciliacao/criar
```

### Body

```json
{
  "transacaoId": 1,
  "status_Pagamento": "CONCLUIDO",
  "status_Antifraude": "APROVADO",
  "valor_transacao": 250.75
}
```

---

## Buscar Reconciliação

### GET

```http
GET /reconciliacao/transacao/{id}
```

Exemplo:

```http
GET /reconciliacao/transacao/1
```

---

# ✅ Exemplo de Resposta

## POST
<img width="841" height="443" alt="image" src="https://github.com/user-attachments/assets/a2e3e807-4e3b-4a5d-93ec-b66f9030c868" />



---

## GET

<img width="845" height="408" alt="image" src="https://github.com/user-attachments/assets/04114afa-45ed-4ded-a30f-f578884753d1" />


---

# ⚙️ Cache

O projeto utiliza cache para melhorar a performance das consultas de reconciliação.

Exemplo:

```java
@Cacheable(value = "reconciliacoes", key = "#transacaoId")
```

---

# 🔮 Evoluções Futuras

O projeto foi estruturado pensando em evolução para uma arquitetura mais distribuída e orientada a eventos.

Próximas implementações planejadas:

- Apache Kafka para comunicação assíncrona entre serviços
- Integração com Datadog para observabilidade
- Logs centralizados
- Métricas de performance
- Tracing distribuído
- Retry e Dead Letter Queue
- Arquitetura baseada em microsserviços
- Processamento orientado a eventos

---

# 🎯 Objetivo Técnico

Este projeto foi desenvolvido com foco em:

- Simulação de fluxo bancário
- Modelagem de domínio financeiro
- Arquitetura backend
- Boas práticas com Spring Boot
- Persistência com JPA/Hibernate
- Containers com Docker
- Escalabilidade futura
- Comunicação assíncrona

---

# 👨‍💻 Autor

Desenvolvido por Herik Kou.

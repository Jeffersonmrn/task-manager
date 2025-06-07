📌 Task Manager API - Documentação da API: http://localhost:8080/swagger-ui/index.html

Uma API RESTful para gerenciar tarefas, construída com Spring Boot, seguindo boas práticas de camadas, persistência com JPA, banco em memória H2 e endpoints REST documentados.

🚀 Tecnologias utilizadas:

Java 21, Spring Boot, Spring Web, Spring Data JPA, Banco de dados H2 e Maven.

📂 Estrutura do Projeto:

model — Entidades JPA

repository — Acesso ao banco de dados

service — Regras de negócio

controller — Endpoints REST

enums — Enumerações de status e prioridade

📌 Endpoints disponíveis:

✅ Criar uma nova tarefa

POST /tasks
Exemplo de body JSON:

{
  "title": "Estudar Spring Boot",
  "description": "Revisar JPA e REST",
  "priority": "ALTA",
  "status": "PENDENTE",
  "dueDate": "2025-06-07"
}

📋 Listar todas as tarefas

GET /tasks
🔍 Filtrar por status ou prioridade

GET /tasks?status=PENDENTE
GET /tasks?priority=ALTA

📅 Buscar tarefas com vencimento até hoje

GET /tasks/due-today

✅ Marcar uma tarefa como concluída

PUT /tasks/{id}/done

🔗 Exemplo no Postman:

Criar task → POST /tasks

Listar tudo → GET /tasks

Filtrar por prioridade ou status → GET /tasks?priority=ALTA → GET /tasks?status=PENDENTE

Ver tarefas para hoje → GET /tasks/due-today
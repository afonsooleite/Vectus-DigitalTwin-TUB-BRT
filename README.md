# Vectus – Digital Twin para os MetroBus dos TUB

> 🏆 **Projeto premiado**  
> Este projeto foi distinguido com o **CPES SERIW Award – Methodologies and Processes 2024/25**,  
> pelo **melhor projeto em Desenvolvimento de Aplicações Informáticas (2024/25)** na Universidade do Minho.

Digital Twin para os **MetroBus dos Transportes Urbanos de Braga (TUB)**, com monitorização em tempo real da **localização**, **ocupação** e **afluência nas paragens**, integrando sensores físicos/simulados, backend Java e dashboards web.

---

## Objetivos do projeto

- Monitorizar **posição GPS** dos MetroBus em tempo real.  
- Medir a **ocupação dos veículos** (contagem de passageiros a partir de câmaras/sensores).  
- Estimar **afluência nas paragens** com dados de CCTV/sensores.  
- Guardar histórico operacional para **análise e reporting**.  
- Apoiar supervisores com **dashboards em tempo real** e alertas.  
- Suportar regras de negócio (lotação, atrasos, imobilização remota, etc.).

---

## Arquitetura (visão geral)

O projeto segue **OpenUP** (Inception, Elaboration, Construction, Transition) e uma arquitetura em camadas:

- **Frontend** – aplicação web para supervisores e utilizadores finais (dashboards, mapas, alertas).  
- **Backend** – serviços Java para gestão de MetroBus, paragens, sensores, notificações e APIs.  
- **Sensores / Digital Twin** – integração com simuladores/serviços de sensores para enviar eventos em tempo real.  
- **Persistência** – base de dados para registar estados, leituras e eventos operacionais.

O relatório em `docs/` inclui Vision, System-Wide Requirements, Use Cases, Architecture Notebook, Test Cases, Test Log, Build & Implementation, etc.

---

## Estrutura do repositório

```text
Vectus-DigitalTwin-TUB-BRT/
│ README.md
│ LICENSE
│ .gitignore
│
├── ProjetoBRT/     # Código e artefactos do projeto (backend, frontend, configs, etc.)
└── docs/
    Vectus.pdf      # Relatório completo do projeto (substituir pelo nome real)
    CPES Award.pdf     # certificado do prémio

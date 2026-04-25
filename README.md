# 🛒 SpeakList

API inteligente de lista de compras por reconhecimento de voz.

## 📋 Sobre o projeto

SpeakList é uma API REST desenvolvida com Spring Boot que permite gerenciar 
uma lista de compras através de comandos de voz ou texto, utilizando 
inteligência artificial para transcrição e interpretação dos comandos.

## 🎓 Bootcamp DIO + Globant

Este projeto foi desenvolvido como Projeto Final do bootcamp 
**Java & Spring Boot AI Developer** da [DIO](https://www.dio.me/) em parceria com a **Globant**.

Durante o bootcamp foram aplicados os seguintes conceitos no desenvolvimento do SpeakList:

- **Java 21** — fundamentos e recursos modernos da linguagem
- **Spring Boot** — criação de APIs REST completas
- **Spring AI** — integração com serviços de inteligência artificial
- **Spring Data JPA** — persistência e integração com banco de dados
- **Clean Code** — boas práticas de escrita e organização de código
- **Padrões de projeto** — arquitetura em camadas (Controller, Service, Repository)
- **Banco de dados** — PostgreSQL com Supabase
- **Deploy** — publicação da API em ambiente de produção com Render
- **Controle de versão** — versionamento do projeto com Git e GitHub

## 🚀 Tecnologias

- Java 21
- Spring Boot 4.0
- Spring AI
- Groq (Whisper + LLaMA)
- PostgreSQL (Supabase)
- Google TTS

## ⚙️ Funcionalidades

- 🎤 Reconhecimento de fala
- 🧠 Interpretação de comandos com IA
- ➕ Adicionar itens
- ➖ Remover itens
- 🔄 Atualizar quantidade
- 📋 Listar itens
- 🖼️ Gerar imagem da lista
- 🔊 Resposta em áudio

---

## 📁 Estrutura do projeto

```
src/
└── main/
    └── java/
        └── com.camila.speaklist/
            ├── SpeakListApplication.java       ← ponto de entrada
            ├── controller/
            │   ├── AudioController.java        ← endpoints de voz
            │   └── ListaController.java        ← endpoints de texto
            ├── model/
            │   └── ItemLista.java              ← entidade do banco
            ├── repository/
            │   └── ItemRepository.java         ← acesso ao banco
            └── service/
                ├── ComandoService.java         ← interpreta comandos com IA
                ├── ImagemService.java          ← gera imagem da lista
                ├── ListaService.java           ← lógica da lista
                ├── SpeechService.java          ← texto para áudio
                └── TranscricaoService.java     ← áudio para texto
```

---

## ⚠️ Aviso importante

A API está hospedada no plano gratuito do Render. 
No plano gratuito o servidor entra em modo de espera após 15 minutos sem uso.

Na primeira requisição pode demorar até **1 minuto** para responder — 
é o tempo que o servidor leva para "acordar". 
Após a primeira resposta funciona normalmente! 😊

---

## 🧪 Como testar a API

A API está disponível em:
https://speaklist.onrender.com

---

### Ferramentas recomendadas
- [Postman](https://www.postman.com/downloads/) para testar os endpoints
- Qualquer gravador de áudio para gravar comandos de voz (.mp3 ou .wav)

---

### 🎤 Testando por voz

1. Grave um áudio com um dos comandos abaixo
2. Abra o Postman
3. Configure a requisição:
   - Método: `POST`
   - URL: `https://speaklist.onrender.com/api/audio/comando`
   - Aba **Body** → **form-data**
   - Adicione o campo `audio` como `File` e selecione seu arquivo

**Exemplos de comandos de voz:**
| O que falar | O que acontece |
|---|---|
| "Adiciona 2 litros de água" | Adiciona feijão na lista |
| "Remove o açúcar" | Remove o feijão da lista |
| "Adiciona mais 3 litros de água" | Soma 3 à quantidade atual de açúcar|
| "Tira 1 litro de leite" | Subtrai 1 da quantidade atual |
| "Muda o açúcar para 5 quilos" | Atualiza a quantidade para 5 |
| "Quais itens tem na lista?" | Lista todos os itens |

A resposta será um arquivo de áudio `resposta.mp3` com a confirmação do comando!

---

### ✍️ Testando por texto (endpoints diretos)

#### ➕ Adicionar item
`POST https://speaklist.onrender.com/api/lista/adicionar
Params: nome=Arroz&quantidade=10&unidade=kg`

#### 🗑️ Remover item 
`DELETE https://speaklist.onrender.com/api/lista/remover
Params: nome=Arroz`

#### 🔼 Somar quantidade
`PUT https://speaklist.onrender.com/api/lista/somar
Params: nome=Arroz&quantidade=5`

#### 🔽 Subtrair quantidade
`PUT https://speaklist.onrender.com/api/lista/subtrair
Params: nome=Arroz&quantidade=3`

#### 🔄 Atualizar quantidade
`PUT https://speaklist.onrender.com/api/lista/atualizar
Params: nome=Arroz&quantidade=20`

#### 📋 Listar todos os itens
`GET https://speaklist.onrender.com/api/lista`

#### 🖼️ Ver imagem da lista
`GET https://speaklist.onrender.com/api/lista/imagem`

Acesse direto no navegador para visualizar a imagem da lista!

---

## 🤝 Contribuições

Contribuições são bem-vindas! Por favor, abra uma **Issue** primeiro 
para discutir o que você gostaria de mudar.

---

## 👩‍💻 Autora

Desenvolvido por **Camila Machado** "Zenóbya" ✨

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Camila_Machado-0077B5?style=flat&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/camilamachado23/)
[![GitHub](https://img.shields.io/badge/GitHub-Zenobya-181717?style=flat&logo=github&logoColor=white)](https://github.com/Zenobya)
[![DIO](https://img.shields.io/badge/DIO-Bootcamp-F97316?style=flat&logo=rocket&logoColor=white)](https://www.dio.me)
[![Globant](https://img.shields.io/badge/Globant-Java_%26_Spring_Boot_AI_Developer-00C752?style=flat)](https://www.dio.me/bootcamp/globant-java-spring-boot-ai-developer)

## 📝 Licença

Este projeto está sob a licença MIT.





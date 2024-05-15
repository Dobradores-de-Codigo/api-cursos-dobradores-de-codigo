# Projeto para um micro serviço para gestão de cursos - README

<img width="20%"  src="./imagesREADME/compassUolLogoSvg.svg"/>

Este é o repositório do projeto "micro serviço para gestão de cursos" desenvolvido como parte do estágio na Compass UOL. Abaixo estão as informações importantes para o desenvolvimento, entrega e funcionalidades do projeto.

## Descrição do Projeto

O projeto consiste em criar um micro serviço para a gestão de cursos, utilizando Spring Boot e o banco de dados H2 em arquivo. O micro serviço deve ter documentação de API(Swagger) e comunicação entre o micro serviço de gestão de matriculas e alunos, pelo HTTP(OpenFeign).

## Desenvolvedores

Os desenvolvedores deste projeto são:

+ Jeferson Gomes da Silva: [@Jeferson5641](https://github.com/Jeferson5641)
+ Juliana Lourdes Ransani: [@Clexa97](https://github.com/Clexa97)
+ Vagner Ferreira Lima Junior: [@vagnerflj](https://github.com/vagnerflj)

## Instrutores

- **Rafael Henrique Menegon(P.O):** [@devrafamenegon](https://github.com/devrafamenegon)
- **Edmar Miller(P.O):** [@EdmarMiller](https://github.com/EdmarMiller)
- **Cleiton Fiatkoski Balansin(P.O):** [@CleitonFB](https://github.com/CleitonFB)
- **Mateus de Oliveira e Silveira(P.O):** [@mosilveira](https://github.com/mosilveira)
- **João Nicoli(P.O):** [@Joaonic](https://github.com/Joaonic)
- **Rafael Luz(P.O):** [@rafinhaLQ](https://github.com/rafinhaLQ)
- **Lucas Magno(P.O):** [@lucasmgn](https://github.com/lucasmgn)
- **Manoel Rosa(P.O):** [@guiguel](https://github.com/guiguel)

## Entrega

+ Último commit: até às 12h00 de 13/05/2024 (segunda-feira).
+ Os dois projetos devem estar disponiveis em um repositório no GitHub, configurado como "privado".
+ O repositório deve ter duas branches fixas: 'main' e 'dev', o restante das branches devem estar padronizadas com o formato: [nome-do-microserviço]/[feature]-[nome_da_funcionalidade], os commits devem ser semânticos.
+ Os instrutores devem ter acesso ao GitHub para revisão.

## Prazo

O link do repositório deve ser enviado por e-mail até às 12hrs do dia 13/05/2024 (segunda-feira).

## Funcionalidades Obrigatórias

+ Entidades: Curso: nome, quantidade de horas, professor, área do conhecimento, ativo;
+ Funcionalidades: 1. Cadastrar curso. 2. Inabilitar curso. 3. Alterar professor de um curso já cadastrado.


## Regras

+ Nome de cursos não podem se repitir.
+ Deve-se criar novas entidades e/ou campos casos necessário.
+ Deve-se criar todos os endpoints necessários.
+ Os micro serviços devem ter cobertura de teste de no mínimo 30%.
+ Todos os endpoints devem obedecer as finalidades de funcionamento dos métodos HTTP, assim como os retornos HTTP status code coerentes.
+ O campo área do conhecimento deve ser um ENUM interno ao projeto com uma lista pré-definida, que deve constar na documentação;

## Endpoits

+ Cadastrar curso.
+ Alterar Professor de um curso já cadastrado.
+ Inabilitar curso.
+ Buscar todos os cursos cadastrados.
+ Buscar curso por id.
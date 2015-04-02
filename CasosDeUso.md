# Introdução #

Casos de uso para o SIATCO (Sistema de Gerenciamento de Atividades Complementares)


# Detalhes #

  * **Aluno** cadastra hora complementar
  * **Professor** avalia as horas
  * **Ensino** gera relatórios

## **Lançar Atividade** ##

**Fluxo Principal:**

  1. Funcionário valida comprovante de matrícula do aluno.
  1. Funcionário recebe documentação original.
  1. Funcionário verifica se o aluno já é cadastrado.
  1. Funcionário verifica se o curso já é cadastrado.
  1. Funcionário verifica se o tipo de atividade já é cadastrado.
  1. Funcionário cadastra a atividade complementar.
  1. Funcionário envia a atividade para análise do professor.
  1. Sistema gera notificação para o professor coordenador.
  1. Fim.

**Tratamento de Exceções:**

  1. .1 Comprovante de matrícula inválido.
    1. .1.1 Vai para o passo 8.
  1. .1 Documentação não compatível.
    1. 2.1.1 Vai para o passo 8.
  1. .1 Tipo de Atividade não cadastrada.
    1. .1.1 Solicita cadastro ao professor coordenador.
    1. .1.2 Retorna para o item 5.
  1. .1 Notificação não gerada pelo sistema.
    1. .1.1 Retorna ao passo 7.

**Fluxo Alternativo:**

  1. .1 Aluno não cadastrado.
    1. .1.1 Funcionário efetua o cadastro do aluno.
  1. .1.2 Retorna para o passo 3.
  1. .1 Curso não cadastrado.
    1. .1.1 Funcionário efetua o cadastro do curso.
    1. .1.2 Retorna para o passo 4.

## **Analisar Hora** ##

**Fluxo Principal:**

  1. Professor recebe notificação para aprovação de atividade complementar.
  1. Professor analisa documentação.
  1. Professor aprova solicitação.
  1. Sistema gera notificação para o aluno.
  1. Fim.

**Tratamento de Exceções:**
  1. .1 Notificação não gerada pelo sistema.
    1. .1.1 Retorna ao passo 3.

**Fluxo alternativo:**
  1. .1 Professor não aceita documentação.
    1. .1.1 Professor informa documentação necessária.
    1. .1.2 Professor envia solitação para secretaria.
    1. .1.3 Sistema gera notificações para aluno e secretaria.
  1. .1 Professor não aceita horas apresentadas.
    1. .1.1 Professor faz justificativa pelo motivo das horas não serem aceitas.
    1. .1.2 Vai para o item 4.

## **Consultar Horas /Atividades** ##

**Fluxo Principal (_Ensino_ e _Professor_):**

  1. Ensino efetua login.
  1. Ensino executa consultas.
  1. Fim.

**Tratamento de Exceções:**
  1. .1 Funcionario com problema no login.
    1. .1.1 Informar a secretaria.

**Fluxo alternativo:**
  1. .1 A pesquisa não retornou resultados.
    1. .1.1 Retorna para o item 2.

**Fluxo Principal (_Aluno_):**
  1. Aluno acessa o sistema.
  1. Aluno pesquisa extrato de solicitações
  1. Sistema apresenta as informações relacionadas ao aluno.
  1. Fim.

**Tratamento de Exceções:**
  1. .1 Aluno com problema no login.
    1. .1.1 Informar a secretaria.

**Fluxo Alternativo:**
  1. .1 Sistema não apresenta informações do aluno.
    1. .1.1 Retornar para passo 2.

## **Gerenciar Tipo de Atividade** ##

**Fluxo Principal:**
  1. Funcionário pesquisa tipo de atividade no sistema.
  1. Sistema informa se o tipo de atividade já consta no sistema.
  1. Sistema possibilita a alteração dos dados dos tipos de atividades.
  1. Funcionário salva alterações.

**Tratamento de Exceção:**
  1. Funcionário não possui permissão para editar o tipo de atividade.
    1. .1 Funcionário solicita autorização ao administrator.

**Fluxo Alternativo:**
  1. Sistema não apresenta tipo de atividades cadastradas.
    1. .1 Funcionário insere um novo tipo de atividade.
    1. .2 Funcionário pesquisa o tipo de atividade
    1. .3 Sistema exibe os tipos de atividades cadastrados.

## **Gerenciar Curso** ##

**Fluxo Principal:**
  1. Funcionário pesquisa curso no sistema.
  1. Sistema informa se o curso já consta no sistema.
  1. Sistema possibilita a alteração das informações do curso.
  1. Funcionário salva alterações.

**Tratamento de Exceção:**
  1. Funcionário não possui permissão para editar o tipo de atividade.
    1. .1 Funcionário solicita autorização ao administrator.

**Fluxo Alternativo:**
  1. Sistema não apresenta curso cadastrado.
    1. .1 Funcionário insere um novo curso.
    1. .2 Funcionário pesquisa o curso
    1. .3 Sistema exibe os cursos cadastrados.

## **Gerenciar Aluno** ##

**Fluxo Principal:**
  1. Aluno entrega documentação para o funcionário.
  1. Funcionário insere os dados do aluno.
  1. Aluno cadastra um usuário e uma senha.
  1. Sistema valida e salva os dados.

**Tratamento de Exceção:**
  1. .1 Senha não bate com padrões de segurança.
> > 3.1.1 Informa padrão de senha.
  1. .1 Sistema não confirma os dados durante a inserção.
    1. .1.1 Funcionario deve preencher os dados novamente.

**Fluxo alternativo:**
  1. Sistema informa que o aluno já esta cadastrado.
    1. .1.1 Funcionário cancela o cadastro em andamento.
    1. .1.2 Pesquisa o cadastro existente.
    1. .1.3 Sistema retorna os dados do aluno
    1. .1.4 Funcionario realiza atualizações caso necessário.
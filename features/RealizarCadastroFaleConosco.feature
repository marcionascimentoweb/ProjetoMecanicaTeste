#language: pt
#encoding: iso-8859-1

Funcionalidade: Realizar um formulário de Fale conosco para escrever 
uma mensagem de sugestões, elogios ou criticas.

Cenário: Preencher o formulário com sucesso
Dado Acessar a página 
E Informar o nome do cliente "Marcio Luiz"
E Informar o email do cliente "mlrnrj@hotmail.com"
E Informar o telefone do cliente "997334640"
E Informar a mensagem desejada "Tudo correto com o teste"
Quando Solicitar o envio do formulário
Então Sistema envia o formulário


Cenário: Não enviar o formulário 
Dado Acessar a página 
E Informar o nome do cliente "Marcio Luiz2"
E Informar o email do cliente "mlrnrj@hotmail."
E Informar o telefone do cliente "997334640"
E Informar a mensagem desejada "Problemas nos dados do site"
Quando Solicitar o envio do formulário
Então Sistema envia o formulário

Cenário: Validação de campos obrigatórios 
Dado Acessar a página 
Quando Solicitar o envio do formulário
Então Sistema envia o formulário

 
 
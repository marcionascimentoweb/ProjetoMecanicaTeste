#language: pt
#encoding: iso-8859-1

Funcionalidade: Realizar um formul�rio de Fale conosco para escrever 
uma mensagem de sugest�es, elogios ou criticas.

Cen�rio: Preencher o formul�rio com sucesso
Dado Acessar a p�gina 
E Informar o nome do cliente "Marcio Luiz"
E Informar o email do cliente "mlrnrj@hotmail.com"
E Informar o telefone do cliente "997334640"
E Informar a mensagem desejada "Tudo correto com o teste"
Quando Solicitar o envio do formul�rio
Ent�o Sistema envia o formul�rio


Cen�rio: N�o enviar o formul�rio 
Dado Acessar a p�gina 
E Informar o nome do cliente "Marcio Luiz2"
E Informar o email do cliente "mlrnrj@hotmail."
E Informar o telefone do cliente "997334640"
E Informar a mensagem desejada "Problemas nos dados do site"
Quando Solicitar o envio do formul�rio
Ent�o Sistema envia o formul�rio

Cen�rio: Valida��o de campos obrigat�rios 
Dado Acessar a p�gina 
Quando Solicitar o envio do formul�rio
Ent�o Sistema envia o formul�rio

 
 
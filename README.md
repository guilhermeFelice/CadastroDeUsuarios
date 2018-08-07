# CadastroDeUsuarios

Este projeto contem um sistema web, desenvolvido com o backend em java, o frontend em AgularJS e utilizando um arquivo de texto para a persistênca dos dados registrados.
Nele contem uma barra de menu com os seguintes itens: 
* Inclusão de um novo registro;

  Este item contem uma tela, com um único campo (Nome) e com um botão (Salvar), que armazena o nome inserido no campo, para um arquivo de texto.
* Listagem de todos os usuários registrado;

  Este item lê o arquivo de texto, e retorna em uma tabela todos os valores cadastrados.

### Requisitos

* java 1.8.0\_144

* apache-tomcat 7.0.85


### Deploy

* Fazer Download ou git clone deste repositorio https://github.com/guilhermeFelice/CadastroDeUsuarios.

* Copiar o arquivo ".war" em CadastroDeUsuarios/target/CadastroDeUsuarios.war e colar \<service-tomcat\>/webapps/CadastroDeUsuarios.war

* Reiniciar servidor tomcat. Exemplo: service tomcat7 restart

* Acessar http://localhost:8080/CadastroDeUsuarios/index.html em um navegador qualquer.



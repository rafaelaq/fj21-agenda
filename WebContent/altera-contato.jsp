<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
  <head>
     <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Insert title here</title>
  </head>
 <body>
 
<form action="mvc?logica=AlteraContatoLogic" method="post">

            <c:forEach var="contato" items="${contatos}">
				<input type="text" name="id" value="${contato.id}"placeholder="id"/><br>          
                <input type="text" name="nome" value="${contato.nome}"placeholder="nome"/><br>
                <input type="text" name="email" value="${contato.email}" placeholder="email"/><br>
                <input type="text" name="endereco" value="${contato.endereco}" placeholder="endereço"/><br>
                <input type="text" name="dataNascimento" value="<fmt:formatDate value='${contato.dataNascimento.time}' pattern="dd/MM/yyyy"/>" placeholder="dataNascimento" /><br>
                <input type="submit" value="Alterar"/>
            </c:forEach> 

     </form>
   </body>
</html>
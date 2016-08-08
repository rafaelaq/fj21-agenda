<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    <c:import url="cabecalho.jsp" />
   
    <table border="1" cellpadding="10px">
     
		<tr>
		<TH>Remover</TH>
		<TH>Alterar</TH>
		<TH>Nome</TH>
		<TH>Email</TH>
		<TH>Endereço</TH>
		<TH>Data de nascimento</TH>
		</tr>

		<c:forEach var="contato" items="${contatos}">
		<tr>
            
		<tr>
		<td>
		<a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a>
	
		</td>
			<td><a href="altera-contato.jsp">Alterar</a></td>
		<td>${contato.nome}</td>
		
		<td><c:if test="${not empty contato.email}">
	    <a href="mailto:${contato.email}">${contato.email}</a>
	    </c:if>
	        
	    <c:if test="${empty contato.email}">
		 E-mail não informado
	    </c:if>
	    </td>
		
		<td>${contato.endereco}</td>
		
		<td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" /></td>
        
		</tr>
		
		</c:forEach>
		
		</table>
		    <c:import url="rodape.jsp" />
		   
		</body>
		</html>
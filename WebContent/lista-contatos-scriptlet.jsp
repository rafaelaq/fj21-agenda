<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.*, br.com.caelum.agenda.dao.*, br.com.caelum.agenda.modelo.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contatos</title>
</head>
<body>
<c:import url="cabecalho.jsp" />
 <table border="1">
 <TR>
<TH>Nome</TH>
<TH>Email</TH>
<TH>Endereço</TH>
<TH>Data de nascimento</TH>
</TR>
		  <%
		  ContatoDao dao = new ContatoDao();
		  List<Contato> contatos = dao.getLista();
		  for (Contato contato : contatos ) { 
			  SimpleDateFormat forma = new SimpleDateFormat("dd/MM/yyyy");
		  %>
		  <tr>
		   <td><%=contato.getNome() %></td>
		   <td><%=contato.getEmail() %></td>
		   <td><%=contato.getEndereco() %></td>
		   <td><%=forma.format(contato.getDataNascimento().getTime()) %></td>
		   
		  </tr>
		  <%
		  }
		  %>
 </table>
 <c:import url="rodape.jsp" />
</body>
</html>
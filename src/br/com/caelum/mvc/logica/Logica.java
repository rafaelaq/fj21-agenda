package br.com.caelum.mvc.logica;

import javax.servlet.http.*;

public interface Logica {
	String executa(HttpServletRequest req,	HttpServletResponse res) throws Exception;

    }


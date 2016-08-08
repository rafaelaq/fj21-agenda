package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;
import br.com.caelum.util.DataFormatada;

public class AlteraContatoLogic implements Logica{

	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		long id = Long.parseLong(req.getParameter("id"));
		
		String nome = req.getParameter("nome");
		String endereco = req.getParameter("endereco");
		String email = req.getParameter("email");
		String dataNascimento = req.getParameter("dataNascimento");
		
		
		Contato contato = new Contato();
		
		contato.setId(id);
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(DataFormatada.DataFormata(dataNascimento));

		ContatoDao dao = new ContatoDao();
		dao.altera(contato);
	
		return "mvc?logica=ListaContatosLogic";
		
		}
	}




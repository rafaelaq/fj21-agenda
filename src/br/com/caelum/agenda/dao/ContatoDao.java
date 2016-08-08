package br.com.caelum.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.agenda.modelo.Contato;
import br.com.caelum.jdbc.ConnectionFactory;

public class ContatoDao {
	
	private Connection connection;
	
	public ContatoDao(Connection connection){
		this.connection = connection;
	}
	
	public ContatoDao(){
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void adiciona(Contato contato){
		String sql = "insert into contatos (nome,email,endereco,dataNascimento) values(?,?,?,?)";
		try {
			//prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			//seta os valores
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			//executa
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Contato> getLista(){
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection.prepareStatement("Select * from contatos");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				//criando o objeto Contato
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				
				//montando a data através do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				
				//adicionando o objeto à lista
				contatos.add(contato);
			}
			rs.close();
			stmt.close();
			return contatos;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void altera(Contato contato){
		String sql = "update contatos set nome=?, email=?, endereco=?, dataNascimento=? where id=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			
			stmt.execute();
			stmt.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(Contato contato){
		
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from contatos where id=?");
			
			stmt.setLong(1, contato.getId());
			
			stmt.execute();
			stmt.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Contato getContato(Contato contato) throws SQLException {
		String sql = "select * from contatos where id = ?";
		Contato contatoSelecionado = new Contato();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, contato.getId());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto Contato
				contatoSelecionado.setId(rs.getLong("id"));
				contatoSelecionado.setNome(rs.getString("nome"));
				contatoSelecionado.setEmail(rs.getString("email"));
				contatoSelecionado.setEndereco(rs.getString("endereco"));
				// montando a data atrav�s do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contatoSelecionado.setDataNascimento(data);
			}			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return contatoSelecionado;
	}	
	
}


package br.com.vacina.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import br.com.vacina.model.Login;
import br.com.vacina.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Repository
public class usuarioDAOImpl implements usuarioDAO{

	@Autowired JdbcTemplate jdbcTemplete;
	@Override
	public int cadastrarUsuario(Usuario usuario) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplete.update((Connection connection) -> {
		PreparedStatement p;
		p =  connection.prepareStatement("INSERT INTO mydb.usuario (nome, sobrenome, telefone, email, cpf, senha, rua, estado, cidade, numero, bairro, complemento, cep) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
		p.setString(1, usuario.getNome());
		p.setString(2, usuario.getSobrenome());
		p.setString(3, usuario.getTelefone());
		p.setString(4, usuario.getEmail());
		p.setString(5, usuario.getCpf());
		p.setString(6, usuario.getSenha());
		p.setString(7, usuario.getRua());
		p.setString(8, usuario.getEstado());
		p.setString(9, usuario.getCidade());
		p.setInt(10, usuario.getNumero());
		p.setString(11, usuario.getBairro());
		p.setString(12, usuario.getComplemento());
		p.setString(13, usuario.getCep());
		return p;
		}, keyHolder);		
		return keyHolder.getKey().intValue();
	}

	@Override
	public List<Usuario> getlistarUsuario() {
		List<Usuario> listaUsuario = new ArrayList<>();
		Collection<Map<String, Object>> rows = null;
		rows = jdbcTemplete.queryForList("SELECT * FROM mydb.usuario");
		rows.stream().map((row) -> {
		Usuario p = new Usuario();
		p.setIdUsuario((int) row.get("idUsuario"));
		p.setNome((String) row.get("nome"));
		p.setSobrenome((String) row.get("sobrenome"));
		p.setTelefone((String) row.get("telefone"));
		p.setEmail((String) row.get("email"));
		p.setCpf((String) row.get("cpf"));
		p.setSenha((String) row.get("senha"));
		p.setRua((String) row.get("rua"));
		p.setEstado((String) row.get("estado"));
		p.setCidade((String) row.get("cidade"));
		p.setNumero((int) row.get("numero"));
		p.setBairro((String) row.get("bairro"));
		p.setComplemento((String) row.get("complemento"));
		p.setCep((String) row.get("cep"));
		return p;
		}).forEach((ss) -> {
			listaUsuario.add(ss);
		});
		//RETORNA OS DADOS EM LISTA
		return listaUsuario;
	}

	@Override
	public List<Usuario> loginUsuario(Login login) {				
		
		List<Usuario> listaUsuario = new ArrayList<>();
		Collection<Map<String, Object>> rows = null;
		rows = jdbcTemplete.queryForList("SELECT * FROM mydb.usuario WHERE cpf='" + login.getCpf().toString() + "'");
		if(!rows.isEmpty()) {		
			rows.stream().map((row) -> {		
				Usuario p = new Usuario();
				p.setIdUsuario((int) row.get("idUsuario"));
				p.setNome((String) row.get("nome"));
				p.setSobrenome((String) row.get("sobrenome"));
				p.setTelefone((String) row.get("telefone"));
				p.setEmail((String) row.get("email"));
				p.setCpf((String) row.get("cpf"));
				p.setSenha((String) row.get("senha"));
				p.setRua((String) row.get("rua"));
				p.setEstado((String) row.get("estado"));
				p.setCidade((String) row.get("cidade"));
				p.setNumero((int) row.get("numero"));
				p.setBairro((String) row.get("bairro"));
				p.setComplemento((String) row.get("complemento"));
				p.setCep((String) row.get("cep"));
				return p;
				}).forEach((ss) -> {
					listaUsuario.add(ss);
				});
			
				if(login.getCpf().equals(listaUsuario.get(0).getCpf().toString()) && login.getSenha().equals(listaUsuario.get(0).getSenha().toString())) {
					return listaUsuario;
				}
		} 		
		return null;		
	}
}

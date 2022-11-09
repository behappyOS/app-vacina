package br.com.vacina.dao;

import java.util.List;

import br.com.vacina.model.Login;
import br.com.vacina.model.Usuario;

public interface usuarioDAO {
	
	public abstract int cadastrarUsuario(Usuario usuario);
	public abstract List<Usuario> getlistarUsuario();
	public abstract List<Usuario> loginUsuario(Login login);
}

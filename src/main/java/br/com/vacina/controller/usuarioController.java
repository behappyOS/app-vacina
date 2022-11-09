package br.com.vacina.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.vacina.dao.usuarioDAO;
import br.com.vacina.model.Login;
import br.com.vacina.model.Usuario;

@CrossOrigin
@RestController
public class usuarioController {

	@Autowired usuarioDAO UsuarioDAO;
	@RequestMapping(value="/cadastrarUsuario", method=RequestMethod.POST)
	public ResponseEntity<Object> cadastrarUsuario(@RequestBody Usuario usuario){
		UsuarioDAO.cadastrarUsuario(usuario);
		return new ResponseEntity<>("sucesso", HttpStatus.OK);
	}
	
	@RequestMapping(value="/listarUsuario", method=RequestMethod.GET)
	public ResponseEntity<Object> listarUsuario(){
		return new ResponseEntity<>(UsuarioDAO.getlistarUsuario(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/loginUsuario", method=RequestMethod.POST)
	public ResponseEntity<Object> loginUsuario(@RequestBody Login login){		
		return new ResponseEntity<>(UsuarioDAO.loginUsuario(login), HttpStatus.OK);
	}
}

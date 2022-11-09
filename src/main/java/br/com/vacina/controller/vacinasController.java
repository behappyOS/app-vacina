package br.com.vacina.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.vacina.dao.vacinasDAO;

@CrossOrigin
@RestController
public class vacinasController {
	
	@Autowired vacinasDAO VacinasDAO;		
	@RequestMapping(value="/listarVacinas", method=RequestMethod.GET)
	public ResponseEntity<Object> listarExame(){
		return new ResponseEntity<>(VacinasDAO.getlistarVacinas(), HttpStatus.OK);
	}

}

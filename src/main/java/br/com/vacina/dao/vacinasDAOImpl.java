package br.com.vacina.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import br.com.vacina.model.Vacinas;

@Repository
public class vacinasDAOImpl implements vacinasDAO {

	@Autowired JdbcTemplate jdbcTemplete;
	@Override
	public List<Vacinas> getlistarVacinas() {
		List<Vacinas> listaVacinas = new ArrayList<>();
		Collection<Map<String, Object>> rows = null;
		rows = jdbcTemplete.queryForList("SELECT * FROM mydb.vacinas");
		rows.stream().map((row) -> {
		Vacinas p = new Vacinas();
		p.setIdVacinas((int) row.get("idVacinas"));
		p.setNome_posto((String) row.get("nome_posto"));
		p.setTelefone((String) row.get("telefone"));
		p.setBairro((String) row.get("bairro"));
		p.setNumero((int) row.get("numero"));
		p.setCep((String) row.get("cep"));
		p.setComplemento((String) row.get("complemento"));
		p.setRua((String) row.get("rua"));
		p.setLatitude(Double.parseDouble(row.get("latitude").toString()));
		p.setLongitude(Double.parseDouble(row.get("longitude").toString()));
		return p;
		}).forEach((ss) -> {
			listaVacinas.add(ss);
		});
		//RETORNA OS DADOS EM LISTA
		return listaVacinas;
	}

}

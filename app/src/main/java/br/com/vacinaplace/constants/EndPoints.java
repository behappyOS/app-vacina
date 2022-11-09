package br.com.vacinaplace.constants;

public class EndPoints {

    //CLASSE ONDE SERÃO LISTADOS TODOS OS ENDPOINTS DO PROJETO

    //API DE PRODUCAO
    public static final String BASE_URL = "http://192.168.100.107:8080/vacina_place/";

    //LOGIN
    public static final String LOGIN = BASE_URL + "loginUsuario";

    //CADASTRAR USUARIO
    public static final String CADASTRO = BASE_URL + "cadastrarUsuario";

    //CEP
    public static final String URL_ZIPCODE = "https://viacep.com.br/ws/";
}

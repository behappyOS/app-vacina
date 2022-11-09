package br.com.vacinaplace.viewmodel;

import android.content.Context;
import br.com.vacinaplace.service.LoginAsyncTask;

public class LoginActivityViewModel {

    private Context activity;
    private LoginInterface loginInterface;

    public LoginActivityViewModel(Context activity, LoginInterface loginInterface){
        this.activity = activity;
        this.loginInterface = loginInterface;
    }

    //METODO PARA VALIDAR OS DADOS DE LOGIN DO USUARIO
    public void login(String cpf, String senha){
        new LoginAsyncTask(activity, loginInterface, cpf, senha).execute();
    }
}

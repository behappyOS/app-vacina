package br.com.vacinaplace.viewmodel;

import android.content.Context;
import br.com.vacinaplace.model.Usuario;
import br.com.vacinaplace.service.PrimeiroAcessoAsyncTask;

public class PrimeiroAcessoViewModel {

    private Context context;
    private PrimeiroAcessoInterface primeiroAcessoInterface;
    private Usuario usuario;

    public PrimeiroAcessoViewModel(Context context, PrimeiroAcessoInterface primeiroAcessoInterface, Usuario usuario){
        this.context = context;
        this.primeiroAcessoInterface = primeiroAcessoInterface;
        this.usuario = usuario;
    }

    //METODO IRA CHAMAR NOSSA TAREFA SINCRONA PARA PROCESSAMENTO PESADO.
    public void cadastrar(){
        new PrimeiroAcessoAsyncTask(context, primeiroAcessoInterface, usuario).execute();
    }
}

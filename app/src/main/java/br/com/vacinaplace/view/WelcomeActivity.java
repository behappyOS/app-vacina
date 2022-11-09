package br.com.vacinaplace.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.vacinaplace.R;
import br.com.vacinaplace.viewmodel.WelcomeActivityViewModel;

public class WelcomeActivity extends AppCompatActivity {

    private ImageView background;
    private WelcomeActivityViewModel welcomeActivityViewModel;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //INICIALIZAR OS COMPONENTES DA TELA
        inicializarComponentes();

        //TODA AÇÃO DE ALGUM COMPONENTE SERÁ EXECUTADO ATRAVÉS DAS CLASSES "VIEW MODEL"
        welcomeActivityViewModel = new WelcomeActivityViewModel(this);
        welcomeActivityViewModel.init(background);
    }

    //CLIQUE BOTÃO: "JA TENHO ACESSO"
    public void btnTenhoAcesso(View view){
        intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }


    //CLIQUE BOTÃO: "PRIMEIRO ACESSO"
    public void btnPrimeiroAcesso(View view){
        intent = new Intent(this, PrimeiroAcessoActivity.class);
        startActivity(intent);
    }

    //METODO PARA INICIALIZAR TODOS OS COMPONENTES DA ACTIVITY
    private void inicializarComponentes(){
        background = (ImageView) findViewById(R.id.background);
    }
}
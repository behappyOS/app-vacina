package br.com.vacinaplace.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import br.com.vacinaplace.R;
import br.com.vacinaplace.view.WelcomeActivity;

//CLASSE PRINCIPAL
//PRIMEIRA CLASSE A SER EXECUTADA AO INICIAR O APP
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //APÓS A EXECUÇÃO, A CLASSE IRÁ CHAMAR A PRIMEIRA TELA, WELCOME!
        //setContentView(R.layout.activity_welcome);
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }
}
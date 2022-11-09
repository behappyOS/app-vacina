package br.com.vacinaplace.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.vacinaplace.R;
import br.com.vacinaplace.viewmodel.LoginActivityViewModel;
import br.com.vacinaplace.viewmodel.LoginInterface;

public class LoginActivity extends AppCompatActivity implements LoginInterface {

    //COMPONENTES
    private EditText etCPF, etSenha;
    private LoginActivityViewModel loginActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inicializarComponentes();
    }

    //METODO PARA INICIALIZAR TODOS OS COMPONENTES DA ACTIVITY
    private void inicializarComponentes(){
        etCPF = (EditText) findViewById(R.id.etNome);
        etSenha = (EditText) findViewById(R.id.etSenha);

        loginActivityViewModel = new LoginActivityViewModel(this, LoginActivity.this);
    }

    //CLICK NO BOTAO ACESSAR
    public void btnAcessar(View view){
        //CHAMA O METODO PARA REALIZAR LOGIN
       loginActivityViewModel.login(etCPF.getText().toString(), etSenha.getText().toString());
    }

    //METODO EXECUTADO APOS RECEBER OS DADOS DO JSON
    @Override
    public void resultLogin(String resultado, ProgressDialog progressDialog) {
        progressDialog.dismiss();
        //SE O RETORNO FOR IGUAL A "1" - AUTENTICA O USUARIO
        if(resultado.equals("1")){
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        } else {
            //CASO CONTRARIO, RETORNA MENSAGEM DE ERRO E NAO AUTENTICA
            Toast.makeText(this, R.string.login_failed, Toast.LENGTH_LONG).show();
        }
    }
}
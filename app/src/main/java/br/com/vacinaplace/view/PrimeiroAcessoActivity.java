package br.com.vacinaplace.view;

import androidx.appcompat.app.AppCompatActivity;
import br.com.vacinaplace.R;
import br.com.vacinaplace.model.AddressModel;
import br.com.vacinaplace.model.Usuario;
import br.com.vacinaplace.service.zipcode.Address;
import br.com.vacinaplace.service.zipcode.ZipCodeRequestAsyncTask;
import br.com.vacinaplace.service.zipcode.ZipCodeRequestInterface;
import br.com.vacinaplace.viewmodel.PrimeiroAcessoInterface;
import br.com.vacinaplace.viewmodel.PrimeiroAcessoViewModel;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class PrimeiroAcessoActivity extends AppCompatActivity implements ZipCodeRequestInterface, PrimeiroAcessoInterface {

    private EditText etNome, etSobrenome, etTelefone, etEmail, etCPF, etCEP, etEndereco, etNumero, etComplemento,
    etBairro, etCidade, etEstado, etConfirmarSenha, etSenha;
    private PrimeiroAcessoViewModel primeiroAcessoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //INICIALIZAR OS COMPONENTES DA TELA
        inicializarComponentes();

        //AÇÃO REALIZADA AO SAIR DO BOTÃO CEP
        etCEP.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    String zipcode = v.getText().toString().replace("-", "");
                    if( zipcode.length() == 8 ){
                        new ZipCodeRequestAsyncTask(PrimeiroAcessoActivity.this, PrimeiroAcessoActivity.this, zipcode ).execute();
                    } else{
                        Toast.makeText(PrimeiroAcessoActivity.this, "O CEP deve conter 8 dígitos!", Toast.LENGTH_LONG).show();
                    }
                    return true;
                }
                return false;
            }
        });

        TextView tiZipCodeNot = (TextView) findViewById(R.id.tiZipCodeNot);
        tiZipCodeNot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etEndereco.setEnabled(true);
                etBairro.setEnabled(true);
                etCidade.setEnabled(true);
                etEstado.setEnabled(true);
            }
        });
    }

    //METODO PARA INICIALIZAR TODOS OS COMPONENTES DA ACTIVITY
    private void inicializarComponentes(){
        etNome = (EditText) findViewById(R.id.etNome);
        etSobrenome = (EditText) findViewById(R.id.etSobrenome);
        etTelefone = (EditText) findViewById(R.id.etTelefone);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etCPF = (EditText) findViewById(R.id.etCPF);
        etCEP = (EditText) findViewById(R.id.etCEP);
        etEndereco = (EditText) findViewById(R.id.etEndereco);
        etNumero = (EditText) findViewById(R.id.etNumero);
        etComplemento = (EditText) findViewById(R.id.etComplemento);
        etBairro = (EditText) findViewById(R.id.etBairro);
        etCidade = (EditText) findViewById(R.id.etCidade);
        etEstado = (EditText) findViewById(R.id.etEstado);
        etSenha = (EditText) findViewById(R.id.etSenha);
        etConfirmarSenha = (EditText) findViewById(R.id.etConfirmarSenha);
    }

    //RECEBE OS DADOS APOS DIGITAR O CEP
    @Override
    public void setData(Address address) {
        if(address.getBairro() == null || address.getBairro().isEmpty()){
            Toast.makeText(PrimeiroAcessoActivity.this, "Por favor, verifique se o CEP está correto!", Toast.LENGTH_LONG).show();
        } else {
            etEndereco.setText(address.getLogradouro());
            etBairro.setText(address.getBairro());
            etEstado.setText(address.getUf());
            etCidade.setText(address.getLocalidade());
        }
    }

    //VALIDAR SE OS CAMPOS OBRIGATORIOS FORAM PREENCHIDOS
    private boolean validaCampos(){
        if(etNome.getText().toString().equals("") ||
        etSobrenome.getText().toString().equals("") ||
        etTelefone.getText().toString().equals("") ||
        etEmail.getText().toString().equals("")||
        etCPF.getText().toString().equals("")||
        etCEP.getText().toString().equals("") ||
        etEndereco.getText().toString().equals("") ||
        etNumero.getText().toString().equals("") ||
        etBairro.getText().toString().equals("") ||
        etCidade.getText().toString().equals("") ||
        etEstado.getText().toString().equals("") ||
        etSenha.getText().toString().equals("") ||
        etConfirmarSenha.getText().toString().equals("")
        ){
            return false;
        }
        return true;
    }

    //CLIQUE NO BOTAO CADASTRAR
    public void btnCadastrar(View view){

        //PRIMEIRO VALIDA SE OS CAMPOS ESTAO PREENCHIDOS
        if(validaCampos()){
            //APOS, VALIDA SE AS SENHAS CONFEREM
            if (etSenha.getText().toString().equals(etConfirmarSenha.getText().toString())){
                try {
                    //COLOCAREMOS OS DADOS DO USUARIO EM UM OBJETO "USUARIO" PARA ENCAPSULAMENTO DE DADOS
                    //E PARA ORGANIZAR NOSSO CODIGO
                    Usuario usuario = new Usuario();
                    usuario.setNome(etNome.getText().toString());
                    usuario.setSobrenome(etSobrenome.getText().toString());
                    usuario.setTelefone(etTelefone.getText().toString());
                    usuario.setEmail(etEmail.getText().toString());
                    usuario.setCpf(etCPF.getText().toString());
                    usuario.setCep(Integer.parseInt(etCEP.getText().toString()));
                    usuario.setRua(etEndereco.getText().toString());
                    usuario.setNumero(Integer.parseInt(etNumero.getText().toString()));
                    usuario.setBairro(etBairro.getText().toString());
                    usuario.setCidade(etCidade.getText().toString());
                    usuario.setEstado(etEstado.getText().toString());
                    usuario.setComplemento(etComplemento.getText().toString());
                    usuario.setSenha(etSenha.getText().toString());

                    //DEPOIS, IREMOS CHAMAR NOSSA CLASSE PARA CADASTRAR OS DADOS
                    primeiroAcessoViewModel = new PrimeiroAcessoViewModel(this, PrimeiroAcessoActivity.this, usuario);
                    primeiroAcessoViewModel.cadastrar();
                } catch (Exception e){
                    e.printStackTrace();
                }
            } else  {
                Toast.makeText(this, "Senhas não conferem!", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "Preencha todos os campos obrigatórios!", Toast.LENGTH_LONG).show();
        }
    }

    //RESULTADO APOS CLICAR NO BOTAO CADASTRAR
    @Override
    public void resultadoCadastrar(String resultado, ProgressDialog progressDialog){

            //APOS RECEBER OS DADOS, PARAMOS A BARRA DE CARREGAMENTO
            progressDialog.dismiss();

            //IREMOS VALIDAR A RESPOSTA DO SERVIDOR DE CADASTRO
            if(resultado.equals("sucesso")){
                //CASO DE SUCESSO MOSTRAMOS A MENSAGEM E RETORNAMOS A TELA PRINCIPAL
                Toast.makeText(this, "Cadastrado com Sucesso!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, WelcomeActivity.class);
                startActivity(intent);
            } else {
                //CASO NEGATIVO, MOSTRAMOS A MENSAGEM DE ERRO
                Toast.makeText(this, "Não foi possível completar o cadastro!", Toast.LENGTH_LONG).show();
            }
    }
}
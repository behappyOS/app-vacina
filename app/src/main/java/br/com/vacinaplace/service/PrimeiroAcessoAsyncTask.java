package br.com.vacinaplace.service;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.UnsupportedEncodingException;
import br.com.vacinaplace.constants.EndPoints;
import br.com.vacinaplace.model.Usuario;
import br.com.vacinaplace.viewmodel.PrimeiroAcessoInterface;

//CLASSE ASYNCRONA: REALIZA A VERIFICACAO EM JSON PARA O EDNPOINT ESPECIFICADO EM SEGUNDO PLANO NO APLICATIVO
//SEM TRAVAR A APLICACAO OU NOSSA UI PRINCIPAL
public class PrimeiroAcessoAsyncTask extends AsyncTask<Void, Void, Void> {

    private Context context;
    private PrimeiroAcessoInterface primeiroAcessoInterface;
    private Usuario usuario;
    private ProgressDialog progressDialog;

    public PrimeiroAcessoAsyncTask(Context context, PrimeiroAcessoInterface primeiroAcessoInterface, Usuario usuario){
        this.context = context;
        this.primeiroAcessoInterface = primeiroAcessoInterface;
        this.usuario = usuario;
    }

    //METODO EXECUTADO ANTES DA INICIALIZACAO DA BUSCA
    //GERALMENTE MOSTRAMOS UMA BARRA DE CARREGAMENTO
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Cadastrando Usuario..");
        progressDialog.show();
    }

    @Override
    protected Void doInBackground(Void... voids) {

        try {
            RequestQueue requestQueue = Volley.newRequestQueue(context);
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("nome", usuario.getNome());
            jsonBody.put("sobrenome", usuario.getSobrenome());
            jsonBody.put("telefone", usuario.getTelefone());
            jsonBody.put("email", usuario.getEmail());
            jsonBody.put("cpf", usuario.getCpf());
            jsonBody.put("senha", usuario.getSenha());
            jsonBody.put("rua", usuario.getRua());
            jsonBody.put("estado", usuario.getEstado());
            jsonBody.put("cidade", usuario.getCidade());
            jsonBody.put("numero", usuario.getNumero());
            jsonBody.put("bairro", usuario.getBairro());
            jsonBody.put("complemento", usuario.getComplemento());
            jsonBody.put("cep", usuario.getCep());
            final String requestBody = jsonBody.toString();

            StringRequest stringRequest = new StringRequest(Request.Method.POST, EndPoints.CADASTRO,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            primeiroAcessoInterface.resultadoCadastrar(response, progressDialog);
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("VOLLEY", error.toString());
                }
            }) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                @Override
                public byte[] getBody() {
                    try {
                        return requestBody == null ? null : requestBody.getBytes("utf-8");
                    } catch (UnsupportedEncodingException uee) {
                        VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                        return null;
                    }
                }
            };

            requestQueue.add(stringRequest);

        } catch(JSONException e){
            e.printStackTrace();
        }

        return null;
    }
}

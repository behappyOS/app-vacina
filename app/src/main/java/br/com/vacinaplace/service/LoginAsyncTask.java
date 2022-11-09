package br.com.vacinaplace.service;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.android.volley.AuthFailureError;
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
import br.com.vacinaplace.viewmodel.LoginInterface;

//CLASSE ASYNCRONA: REALIZA A VERIFICACAO EM JSON PARA O EDNPOINT ESPECIFICADO EM SEGUNDO PLANO NO APLICATIVO
//SEM TRAVAR A APLICACAO
public class LoginAsyncTask extends AsyncTask<Void, Void, Void>{

    private Context activity;
    private LoginInterface loginInterface;
    private String cpf, senha;
    private ProgressDialog progressDialog;

    public LoginAsyncTask(Context activity, LoginInterface loginInterface, String cpf, String senha){
        this.activity = activity;
        this.loginInterface = loginInterface;
        this.cpf = cpf;
        this.senha = senha;
    }

    //METODO EXECUTADO ANTES DA INICIALIZACAO DA BUSCA
    //GERALMENTE MOSTRAMOS UMA BARRA DE CARREGAMENTO
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage("Validando Usuario..");
        progressDialog.show();
    }

    //METODO QUE REALIZA SUA FUNCAO EM SEGUNDO PLANO, OU SEJA, THRED SECUNDARIA DA ACTIVITY PRINCIPAL
    //NESTE METODO REALIZAREMOS A CONSULTA DO LOGIN
    @Override
    protected Void doInBackground(Void... voids) {

        try {
            RequestQueue requestQueue = Volley.newRequestQueue(activity);
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("cpf", cpf);
            jsonBody.put("senha", senha);
            final String requestBody = jsonBody.toString();

            StringRequest stringRequest = new StringRequest(Request.Method.POST, EndPoints.LOGIN,
                new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    loginInterface.resultLogin(response, progressDialog);
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

package br.com.vacinaplace.service;

import android.app.ProgressDialog;
import android.content.Context;
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

import br.com.vacinaplace.viewmodel.LoginInterface;

//CLASSE QUE REALIZARA A REQUISICAO JSON
public class JsonRequest {

    String a = null;

    public static void request(String url, String cpf, String senha, Context context, LoginInterface loginInterface, ProgressDialog progressDialog) {



    }
}

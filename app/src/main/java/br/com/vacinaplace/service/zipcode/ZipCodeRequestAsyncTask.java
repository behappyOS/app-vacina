//CRIADO POR: LEONARDO DE OLIVEIRA
package br.com.vacinaplace.service.zipcode;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.google.gson.Gson;

import br.com.vacinaplace.constants.EndPoints;

public class ZipCodeRequestAsyncTask extends AsyncTask<Void, Void, Address> {

    private String zipcode;
    private Context activity;
    private ZipCodeRequestInterface zipCodeRequestInterface;
    private ProgressDialog progressDialog;

    public ZipCodeRequestAsyncTask(Context activity, ZipCodeRequestInterface zipCodeRequestInterface, String zipcode ){
        this.zipcode = zipcode;
        this.zipCodeRequestInterface = zipCodeRequestInterface;
        this.activity = activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage("Carregando o CEP...");
        progressDialog.show();
    }

    @Override
    protected Address doInBackground(Void... voids) {

        try {
            String jsonString = JsonRequest.request(EndPoints.URL_ZIPCODE + zipcode + "/json/");
            Gson gson = new Gson();
            return gson.fromJson(jsonString, Address.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(Address address) {
        super.onPostExecute(address);
        if( activity != null ){
            if(address != null) {
               zipCodeRequestInterface.setData(address);
            }
        }
        progressDialog.dismiss();
    }
}

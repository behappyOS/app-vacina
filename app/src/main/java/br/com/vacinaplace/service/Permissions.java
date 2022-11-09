package br.com.vacinaplace.service;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;

import br.com.vacinaplace.constants.Constants;

public class Permissions {

    //VALIDAR SE O USUÁRIO ATIVOU AS PERMISSÕES
    //CASO CONTRÁRIO, SOLICITAR PERMISSÃO
    public void checkPermission(Activity context){
        if (!hasPermissions(context, Constants.PERMISSIONS)) {
            requestPermission(context);
        }
    }

    //VALIDAR SE O USUÁRIO ATIVOU AS PERMISSÕES
    private boolean hasPermissions(Context context, String... permissions) {
        if (context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    //CASO NÃO, SOLICITA AS PERMISSÕES PARA O USUÁRIO
    private void requestPermission(Activity context) {
        ActivityCompat.requestPermissions(context, Constants.PERMISSIONS, 200);
    }


}

package br.com.vacinaplace.viewmodel;

import android.app.Activity;
import android.media.Image;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import br.com.vacinaplace.R;
import br.com.vacinaplace.service.Permissions;
import br.com.vacinaplace.view.WelcomeActivity;

public class WelcomeActivityViewModel {

    private Permissions permissions;
    private GlideDrawableImageViewTarget imageViewTarget;
    private Activity activity;

    //CONSTRUTOR DA CLASSE, RECEBE A ACTIVITY AO SER INSTANCIADO
    public WelcomeActivityViewModel(Activity activity){
        this.activity = activity;
    }

    public void init(ImageView background){
        //SOLICITAR PERMISSÕES
        permissions = new Permissions();
        permissions.checkPermission(activity);

        //BACKGROUND DA ACTIVITY
        imageViewTarget = new GlideDrawableImageViewTarget(background);
        Glide.with(activity).load(R.drawable.welcome3).into(imageViewTarget);
    }

}

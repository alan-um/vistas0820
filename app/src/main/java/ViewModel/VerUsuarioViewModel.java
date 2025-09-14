package ViewModel;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import Model.Usuario;

public class VerUsuarioViewModel extends AndroidViewModel {

    private MutableLiveData<Usuario> mutableUsuario;
    public VerUsuarioViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Usuario> getMutableUsuario() {
        if(mutableUsuario==null) {
            mutableUsuario = new MutableLiveData<>();
        }
        return mutableUsuario;
    }

    public void recuperaIntent(Intent intent){
        Usuario usuario = intent.getSerializableExtra("usuario", Usuario.class);
        //Usuario usuario = (Usuario) intent.getSerializableExtra("usuario");
        if(usuario!=null) {
            mutableUsuario.setValue(usuario);
        }
    }
}

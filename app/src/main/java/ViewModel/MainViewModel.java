package ViewModel;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.vistas0820.VerUsuario;

import Model.Usuario;

public class MainViewModel extends AndroidViewModel {

    private MutableLiveData<String> mutableMsg;
    private MutableLiveData<Usuario> mutableUsuario;

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<String> getMutableMsg() {
        if(mutableMsg==null) {
            mutableMsg = new MutableLiveData<>();
        }
        return mutableMsg;
    }

    public LiveData<Usuario> getMutableUsuario() {
        if(mutableUsuario==null) {
            mutableUsuario = new MutableLiveData<>();
        }return mutableUsuario;
    }

    public void login(String usuario, String password){
        if(usuario.equals("mari13") && password.equals("123")){
            Usuario usuario1 = new Usuario(37466909,"Maria","mari13","123");
            //mutableMsg.setValue("LOGEADO!!");
            mutableUsuario.setValue(usuario1);

            /*Intent intent = new Intent(getApplication(), VerUsuario.class);
            intent.putExtra("usuario", usuario1);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplication().startActivity(intent);*/
        }else{
            mutableMsg.setValue("Usuario y/o contraseña incorrectos.");
        }
    }
}

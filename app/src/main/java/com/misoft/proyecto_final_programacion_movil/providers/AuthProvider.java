package com.misoft.proyecto_final_programacion_movil.providers;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class AuthProvider {

    private FirebaseAuth mAuth;

    public AuthProvider() {
        mAuth = FirebaseAuth.getInstance();
    }

    // Función de ayuda para manejar el resultado de las tareas de autenticación
    private LiveData<String> ayudarAuth(Task<AuthResult> tarea) {
        MutableLiveData<String> resultadoAuth = new MutableLiveData<>();
        tarea.addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> tarea) {
                if (tarea.isSuccessful() && mAuth.getCurrentUser() != null) {
                    resultadoAuth.setValue(mAuth.getCurrentUser().getUid());
                } else {
                    resultadoAuth.setValue(null); // Si no es exitoso, devuelve null
                }
            }
        });
        return resultadoAuth;
    }

    // Inicio de sesión en Firebase
    public LiveData<String> iniciarSesion(String correo, String contrasena) {
        return ayudarAuth(mAuth.signInWithEmailAndPassword(correo, contrasena));
    }

    // Registro en Firebase
    public LiveData<String> registrarUsuario(String correo, String contrasena) {
        return ayudarAuth(mAuth.createUserWithEmailAndPassword(correo, contrasena));
    }

    // Obtener el ID del usuario actual
    public String obtenerIDUsuarioActual() {
        return mAuth.getCurrentUser() != null ? mAuth.getCurrentUser().getUid() : null;
    }
}

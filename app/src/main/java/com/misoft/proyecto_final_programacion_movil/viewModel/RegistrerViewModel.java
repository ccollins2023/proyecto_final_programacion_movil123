package com.misoft.proyecto_final_programacion_movil.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.misoft.proyecto_final_programacion_movil.providers.AuthProvider;

public class RegistrerViewModel extends ViewModel {
    private final AuthProvider authProvider;

    public RegistrerViewModel() {
        authProvider = new AuthProvider();
    }

    public LiveData<String> registrarUsuario(String correo, String contrasena) {
        return authProvider.registrarUsuario(correo, contrasena);
    }
}
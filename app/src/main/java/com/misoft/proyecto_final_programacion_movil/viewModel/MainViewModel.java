package com.misoft.proyecto_final_programacion_movil.viewmodel;

import androidx.lifecycle.ViewModel;
import com.misoft.proyecto_final_programacion_movil.providers.AuthProvider;

public class MainViewModel extends ViewModel {
    private final AuthProvider authProvider;

    public MainViewModel() {
        authProvider = new AuthProvider();
    }

    public boolean isLogged() {
        return authProvider.isLogged();
    }

    public void logout() {
        authProvider.logout();
    }
}

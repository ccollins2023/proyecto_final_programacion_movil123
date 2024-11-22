package com.misoft.proyecto_final_programacion_movil.util;

public class Validaciones {

    public static boolean validarUsuario(String usuario) {
        // Verifica que el usuario no sea nulo, que no esté vacío y que tenga más de 3 caracteres.
        return usuario != null && !usuario.isEmpty() && usuario.length() > 3;
    }

    public static boolean validarMail(String email) {
        // Patrón para un email válido.
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email != null && email.matches(emailPattern);
    }

    public static String validarPass(String pass, String pass1) {
        // Verifica que las contraseñas no estén vacías y que tengan al menos 6 caracteres.
        if (pass == null || pass.isEmpty() || pass1 == null || pass1.isEmpty()) {
            return "La contraseña no puede estar vacía";
        }
        if (pass.length() < 6) {
            return "La contraseña debe tener al menos 6 caracteres";
        }
        if (!pass.equals(pass1)) {
            return "Las contraseñas no coinciden";
        }
        return null; // Contraseña válida
    }

    public static boolean controlarPassword(String pass) {
        // Verifica que la contraseña no sea nula y tenga al menos 6 caracteres.
        return pass != null && pass.length() >= 6;
    }
}


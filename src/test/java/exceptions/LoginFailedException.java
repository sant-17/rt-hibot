package exceptions;

public class LoginFailedException extends RuntimeException {

    public LoginFailedException(String username, String password) {
        super(String.format(
                "No se pudo iniciar sesión con las credenciales suministradas [ Username = [%s] ] [Password = [%s] ]",
                username,
                password)
        );
    }
}

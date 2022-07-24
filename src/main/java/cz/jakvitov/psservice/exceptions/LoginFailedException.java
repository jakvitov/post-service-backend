package cz.jakvitov.psservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Author Jakub Vítovec
 *  <h1>Thrown in case of invalid login</h1>
 */
@ResponseStatus(code= HttpStatus.NOT_FOUND, reason = "Invalid login information")
public class LoginFailedException extends RuntimeException {

    public LoginFailedException(Throwable t) {
        super(t);
    }

    public LoginFailedException(){
    };
}

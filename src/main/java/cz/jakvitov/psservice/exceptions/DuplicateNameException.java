package cz.jakvitov.psservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Name already exists in database")
public class DuplicateNameException extends RuntimeException{
    public DuplicateNameException(Throwable t){
        super(t);
    }
}

package netology.Homework_MongoDB;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotException extends RuntimeException {
    public ResourceNotException(String message) {
        super (message);

    }
}

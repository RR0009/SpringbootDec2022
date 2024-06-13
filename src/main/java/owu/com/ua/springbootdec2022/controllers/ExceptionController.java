package owu.com.ua.springbootdec2022.controllers;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> blankException (ConstraintViolationException e){
        String message = e.getMessage();
        System.out.println(message);

        return new ResponseEntity<>(message,HttpStatusCode.valueOf(500));

    }


}

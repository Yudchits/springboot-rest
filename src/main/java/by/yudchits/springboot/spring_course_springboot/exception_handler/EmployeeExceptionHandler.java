package by.yudchits.springboot.spring_course_springboot.exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class EmployeeExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<Map<String, String>> noSuchEmployee(NoSuchEmployeeException ex){
        Map<String, String> response = new HashMap<>();
        response.put("info", ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Map<String,String>> otherException(Exception ex){
        Map<String, String> response = new HashMap<>();
        response.put("info", ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}

package by.yudchits.springboot.spring_course_springboot.exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<IncorrectEmployeeData> employeeDoesNotExist(NoSuchEmployeeException ex){
        IncorrectEmployeeData data = new IncorrectEmployeeData();
        data.setInfo(ex.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<IncorrectEmployeeData> otherException(Exception ex){
        IncorrectEmployeeData data = new IncorrectEmployeeData();
        data.setInfo(ex.getMessage());

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}

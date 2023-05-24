package by.yudchits.springboot.spring_course_springboot.exception_handler;

public class NoSuchEmployeeException extends RuntimeException{
    public NoSuchEmployeeException(String message){
        super(message);
    }
}

package customer_metrics.customer_metrics.exception;

import customer_metrics.customer_metrics.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiResponse> handleUserNotFoundException(UserNotFoundException userNotFoundException){
        return new ResponseEntity<>(new ApiResponse(userNotFoundException.getMessage(), false), HttpStatus.NOT_FOUND);
    }
}

package com.twitter.api.config;




import com.twitter.api.error.ErrorResponseBody;
import com.twitter.api.error.ExceptionMessages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.WebExchangeBindException;

@ControllerAdvice
@Slf4j
public class ApiAdvisor {

    public static final String ERROR_CONFLICT = "Connection error";


    @ExceptionHandler(value = WebExchangeBindException.class)
    @ResponseBody
    public final ResponseEntity<ErrorResponseBody> handleWebExchangeBindExceptionException(
            WebExchangeBindException ex) {
        if (log.isErrorEnabled()) {
            log.error(ExceptionMessages.TWITTER_0001.description(), ex.getMessage());
        }
        return new ResponseEntity<>(new ErrorResponseBody(ExceptionMessages.TWITTER_0001.description(), ExceptionMessages.TWITTER_0001.name()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public final ResponseEntity<ErrorResponseBody> handleUnknownException(Exception ex) {
        if (log.isErrorEnabled()) {
            log.error(ExceptionMessages.TWITTER_0001.description(), ex);
        }
        return new ResponseEntity<>(new ErrorResponseBody(ERROR_CONFLICT,ex.getMessage()), HttpStatus.CONFLICT);
    }


}
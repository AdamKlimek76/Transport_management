package pl.coderslab.exeptions;


import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.NestedServletException;

import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class ErrorControllerCascadeDelete {


    @ExceptionHandler(CouldNotDeleteCascadeException.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    @ResponseBody
    public String handleExceptionIfTryingCascadeDelete(Exception exeption) {

        return "Nie można usunąć ponieważ obiekt jest użyty w powiązanej tableli...";
    }
}

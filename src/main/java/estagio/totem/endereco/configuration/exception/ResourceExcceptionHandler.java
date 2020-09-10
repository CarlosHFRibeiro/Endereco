package estagio.totem.endereco.configuration.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ResourceExcceptionHandler {
    private MessageSource msg;

    @Autowired
    public ResourceExcceptionHandler(MessageSource messageSource) {
        this.msg = messageSource;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrorValidation> handle(MethodArgumentNotValidException ex){
        List<ErrorValidation> erros = new ArrayList<>();
        List<FieldError> propriedades = ex.getBindingResult().getFieldErrors();

        propriedades.forEach(erro ->{
            String msgError = msg.getMessage(erro,LocaleContextHolder.getLocale());
            erros.add(new ErrorValidation(erro.getField(),msgError));
        });
        return erros;
    }


    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    private ErrorDto handle(IllegalArgumentException ex){
        return new ErrorDto(msg.getMessage(ex.getMessage(),null, LocaleContextHolder.getLocale()));
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFound.class)
    private ErrorDto handle(NotFound ex){
        return new ErrorDto(msg.getMessage(ex.getMessage(),null, LocaleContextHolder.getLocale()));
    }
}

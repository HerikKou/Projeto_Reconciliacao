package ProjetoReconciliacao.Reconciliacao.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
    

    @ExceptionHandler(NaoEncontrado.class)
    public ResponseEntity<String> handleNaoEncontrado(NaoEncontrado ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }
}

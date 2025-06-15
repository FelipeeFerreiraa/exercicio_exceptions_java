package model.exceptions;

/**
 *
 * @author felip
 */
// extends RuntimeException
// extends Exception --> OBRIGA TRATAMENTO
public class DomainException extends RuntimeException {

    public DomainException(String msg) {
        super(msg);
    }
}

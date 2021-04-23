package pl.coderslab.exeptions;

public class CouldNotDeleteCascadeException extends RuntimeException {

    public CouldNotDeleteCascadeException(String message) {
        super(message);
    }
}

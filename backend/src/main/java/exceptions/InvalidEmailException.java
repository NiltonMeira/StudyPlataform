package exceptions;

public class InvalidEmailException extends ResponseException {
    public InvalidEmailException() {
        super("Your email has a invalid sintax",400);
    }
}

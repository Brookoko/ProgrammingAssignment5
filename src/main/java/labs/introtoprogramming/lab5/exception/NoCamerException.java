package labs.introtoprogramming.lab5.exception;

public class NoCamerException extends RuntimeException {

  public NoCamerException(String message) {
    super(message);
  }

  public NoCamerException() {
    this("No camera found");
  }
}

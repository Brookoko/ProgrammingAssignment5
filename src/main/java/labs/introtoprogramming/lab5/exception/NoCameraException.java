package labs.introtoprogramming.lab5.exception;

public class NoCameraException extends RuntimeException {

  public NoCameraException(String message) {
    super(message);
  }

  public NoCameraException() {
    this("No camera found");
  }
}

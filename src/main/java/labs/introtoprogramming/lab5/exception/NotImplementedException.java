package labs.introtoprogramming.lab5.exception;

public class NotImplementedException extends RuntimeException {

  public NotImplementedException(String message) {
    super(message);
  }

  public NotImplementedException() {
    this("Not implemented yet");
  }

}

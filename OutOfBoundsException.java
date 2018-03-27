class OutOfBoundsException extends Exception{

  private String message;

  public OutOfBoundsException(String message){
    this.message = message;
  }

  @Override
  public String toString() {
    return "OutOfBoundsException: " + message;
  }
}

package student_management;

public class StringException extends Exception{
    public StringException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

}

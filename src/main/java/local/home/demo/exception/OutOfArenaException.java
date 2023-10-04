package local.home.demo.exception;

public class OutOfArenaException extends Exception {

    @Override
    public String getMessage() {
        return "Робот не может выходить за границы арены";
    }
}

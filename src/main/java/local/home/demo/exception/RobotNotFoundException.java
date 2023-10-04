package local.home.demo.exception;

public class RobotNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return "В исходной позиции нет робота";
    }
}
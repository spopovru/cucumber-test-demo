package local.home.demo.exception;

public class RobotsCollapseException  extends Exception {

    @Override
    public String getMessage() {
        return "Робот не может находиться в ячейке с другим роботом";
    }
}

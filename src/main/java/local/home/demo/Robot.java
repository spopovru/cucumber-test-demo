package local.home.demo;

import local.home.demo.exception.OutOfArenaException;
import local.home.demo.exception.RobotNotFoundException;
import local.home.demo.exception.RobotsCollapseException;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Robot {

    private final String name;
    @Setter
    private Arena arena;
    @Setter
    private Integer x;
    @Setter
    private Integer y;

    public Robot(String name) {
        this.name = name;
    }

    public void moveUp(Integer steps) throws RobotNotFoundException, RobotsCollapseException, OutOfArenaException {
        move(x, y - steps);
    }

    public void moveDown(Integer steps) throws RobotNotFoundException, RobotsCollapseException, OutOfArenaException {
        move(x, y + steps);
    }

    public void moveLeft(Integer steps) throws RobotNotFoundException, RobotsCollapseException, OutOfArenaException {
        move(x - steps, y);
    }

    public void moveRight(Integer steps) throws RobotNotFoundException, RobotsCollapseException, OutOfArenaException {
        move(x + steps, y);
    }

    private void move(Integer newX, Integer newY) throws RobotNotFoundException, RobotsCollapseException, OutOfArenaException {
        this.arena.moveRobot(this.x, this.y, newX, newY);
        this.x = newX;
        this.y = newY;
    }

}

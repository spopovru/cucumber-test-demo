package local.home.demo;

import local.home.demo.exception.OutOfArenaException;
import local.home.demo.exception.RobotNotFoundException;
import local.home.demo.exception.RobotsCollapseException;
import lombok.Getter;

@Getter
public class Arena {

    private final Integer width;    // x
    private final Integer height;   // y
    private Robot[][] robots;

    public Arena(Integer width, Integer height) {
        this.width = width;
        this.height = height;
        this.robots = new Robot[width][height];
    }

    public Robot addRobot(String name, Integer x, Integer y) throws OutOfArenaException, RobotsCollapseException {
        var newRobot = new Robot(name);
        checkPosition(x, y);
        robots[x][y] = newRobot;
        newRobot.setX(x);
        newRobot.setY(y);
        newRobot.setArena(this);
        return newRobot;
    }

    public void moveRobot(Integer oldX, Integer oldY, Integer newX, Integer newY) throws RobotsCollapseException, OutOfArenaException, RobotNotFoundException {
        if (robots[oldX][oldY] == null) {
            throw new RobotNotFoundException();
        }
        checkPosition(newX, newY);
        var robot = robots[oldX][oldY];
        robots[newX][newY] = robot;
        robots[oldX][oldY] = null;
    }

    public Integer robotsCount() {
        Integer count = 0;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (robots[x][y] != null) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (robots[x][y] != null) {
                    s.append(robots[x][y].getName().charAt(0));
                } else {
                    s.append("+");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }

    private void checkPosition(Integer x, Integer y) throws OutOfArenaException, RobotsCollapseException {
        if ((x >= width) || (y >= height) || (x < 0) || (y < 0)) {
            throw new OutOfArenaException();
        }
        if (robots[x][y] != null) {
            throw new RobotsCollapseException();
        }
    }

}

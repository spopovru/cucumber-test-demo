package local.home.demo.test.steps;

import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import local.home.demo.Arena;
import local.home.demo.Robot;
import local.home.demo.exception.OutOfArenaException;
import local.home.demo.exception.RobotsCollapseException;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class ArenaSteps {

    private Arena arena;
    private Map<String, Robot> robots = new HashMap<>();

    @Пусть("создана арена шириной {int} и высотой {int}")
    public void createArena(Integer width, Integer height) {
        arena = new Arena(width, height);
    }

    @Тогда("количество роботов на арене равно {int}")
    public void robotsCount(Integer count) {
        assertThat(arena.robotsCount()).isEqualTo(count);
    }

    @Если("добавлен робот {string} в позицию \\({int}; {int})")
    public void addRobot(String name, Integer x, Integer y) {
        assertThatNoException().isThrownBy(() -> robots.put(name, arena.addRobot(name, x, y)));
    }

    @Если("добавление робота {string} в позицию \\({int}; {int}) приводит к {string}")
    public void addRobotWithException(String name, Integer x, Integer y, String errorType) {
        Class exceptionClass = Exception.class;
        switch (errorType) {
            case "выходу за пределы арены":
                exceptionClass = OutOfArenaException.class;
                break;
            case "столкновению с другим роботом":
                exceptionClass = RobotsCollapseException.class;
                break;
        }
        assertThatExceptionOfType(exceptionClass).isThrownBy(() -> robots.put(name, arena.addRobot(name, x, y)));
    }

    @Тогда("робот {string} находится в позиции \\({int}; {int})")
    public void robotPosition(String name, Integer x, Integer y) {
        var robot = robots.get(name);
        assertThat(robot.getX()).isEqualTo(x);
        assertThat(robot.getY()).isEqualTo(y);
    }

    @Когда("^робот \"(.*)\" переместился (вверх|вниз|влево|вправо) на (\\d+) шаг(?:|а|ов)$")
    public void moveRobot(String name, String direction, int steps) {
        var robot = robots.get(name);
        switch (direction) {
            case "вверх":
                assertThatNoException().isThrownBy(() -> robot.moveUp(steps));
                break;
            case "вниз":
                assertThatNoException().isThrownBy(() -> robot.moveDown(steps));
                break;
            case "влево":
                assertThatNoException().isThrownBy(() -> robot.moveLeft(steps));
                break;
            case "вправо":
                assertThatNoException().isThrownBy(() -> robot.moveRight(steps));
                break;
        }
    }

    @Когда("^робот \"(.*)\" переместился (вверх|вниз|влево|вправо) на (\\d+) шаг(?:|а|ов) происходит ошибка (выхода за пределы арены|столкновения с другим роботом)$")
    public void moveRobotWithException(String name, String direction, int steps, String errorType) {
        var robot = robots.get(name);
        Class exceptionClass = Exception.class;
        switch (errorType) {
            case "выхода за пределы арены":
                exceptionClass = OutOfArenaException.class;
                break;
            case "столкновения с другим роботом":
                exceptionClass = RobotsCollapseException.class;
                break;
        }
        switch (direction) {
            case "вверх":
                assertThatExceptionOfType(exceptionClass).isThrownBy(() -> robot.moveUp(steps));
                break;
            case "вниз":
                assertThatExceptionOfType(exceptionClass).isThrownBy(() -> robot.moveDown(steps));
                break;
            case "влево":
                assertThatExceptionOfType(exceptionClass).isThrownBy(() -> robot.moveLeft(steps));
                break;
            case "вправо":
                assertThatExceptionOfType(exceptionClass).isThrownBy(() -> robot.moveRight(steps));
                break;
        }
    }
}

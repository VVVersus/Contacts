public static void moveRobot(Robot robot, int toX, int toY) {
    int x = robot.getX();
    int y = robot.getY();

    if (toX > x) {
        switch (robot.getDirection()) {
            case UP:
                robot.turnRight();
                break;
            case LEFT:
                robot.turnRight();
                robot.turnRight();
                break;
            case DOWN:
                robot.turnLeft();
                break;
        }

        for (int i = x; i < toX; i++) {
            robot.stepForward();
        }
    }

    if (toX < x) {
        switch (robot.getDirection()) {
            case UP:
                robot.turnLeft();
                break;
            case RIGHT:
                robot.turnRight();
                robot.turnRight();
                break;
            case DOWN:
                robot.turnRight();
                break;
        }

        for (int i = x; i > toX; i--) {
            robot.stepForward();
        }
    }

    if (toY < y) {
        switch (robot.getDirection()) {
            case UP:
                robot.turnLeft();
                robot.turnLeft();
                break;
            case LEFT:
                robot.turnLeft();
                break;
            case RIGHT:
                robot.turnRight();
                break;
        }

        for (int i = y; i > toY; i--) {
            robot.stepForward();
        }
    }

    if (toY > y) {
        switch (robot.getDirection()) {
            case DOWN:
                robot.turnLeft();
                robot.turnLeft();
                break;
            case LEFT:
                robot.turnRight();
                break;
            case RIGHT:
                robot.turnLeft();
                break;
        }

        for (int i = y; i < toY; i++) {
            robot.stepForward();
        }
    }
}
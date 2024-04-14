package DataAccess;

import java.util.ArrayList;

import DataObjects.ItemDataObject;
import DataObjects.RobotDataObject;

public class RobotDataAccess {

    public static ArrayList<RobotDataObject> robots = new ArrayList<RobotDataObject>();
    private static int nextId = 0;    

    public RobotDataAccess() {
        initialize();
    }

    private void initialize() {
        robots.add(new RobotDataObject(0, "zero"));
        robots.add(new RobotDataObject(1, "one"));
        nextId = 2;
    }

    private static int getNextId() {
        int thisId = nextId;
        nextId++;
        return thisId;
    }

    public static ArrayList<RobotDataObject> GetAllRobots() {
        ArrayList<RobotDataObject> robotsList = new ArrayList<RobotDataObject>();
        //Create a copy of robots to return.
        for (RobotDataObject robot: robots) {
            robotsList.add(new RobotDataObject(robot));
        }
        return robotsList;
    }

    public static RobotDataObject GetRobotById(int id) {
        for( RobotDataObject robot : robots) {
            if (robot.id == id) {
                return new RobotDataObject(robot);
            }
        }
        return null;
    }

    public static RobotDataObject GetAvailableRobot() {
        for( RobotDataObject robot : robots) {
            if (robot.rackId == -1) {
                return new RobotDataObject(robot);
            }
        }
        return null;
    }


    public static RobotDataObject AddRobot(RobotDataObject newRobot) {
        newRobot.id = getNextId(); 
        robots.add(newRobot);
        return newRobot;
    }


    public static void Save(RobotDataObject robotToSave) {
        for( RobotDataObject robot : robots) {
            if (robot.id == robotToSave.id) {
                robot.name = robotToSave.name;
                robot.rackId = robotToSave.rackId;
            }
        }
    }


}

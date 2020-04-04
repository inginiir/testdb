package main;

import dbService.DBException;
import dbService.DBService;
import dbService.dataSets.UserDataSet;

public class Main {

    public static void main(String[] args) {

        DBService dbService = new DBService();

        dbService.printConnectInfo();
        try {
            long userId = dbService.addUser("inginiir3");
            System.out.println("Added user id: " + userId);
            UserDataSet userDataSet = dbService.getUser(userId);
            System.out.println("User data set: " + userDataSet);

            //dbService.cleanUp();
        }  catch (DBException e) {
            e.printStackTrace();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package foofle;

import java.util.Scanner;

public class Foofle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        while (true) {
            System.out.println("Please Select from Menu");
            System.out.println("-----------------------");
            System.out.println("1- Create Account");
            System.out.println("2- Login");
            System.out.println("3- Update Account");
            System.out.println("4- Delete Account");
            System.out.println("9- Exit");
            Scanner in = new Scanner(System.in);
            int num = in.nextInt();
            switch (num) {
                case 1:
                    System.out.println("please enter complete account info in this format: firstname lastname nikname username pass address mobile");
                    in = new Scanner(System.in);
                    String formattedAccountInfo = in.nextLine();
                    String[] splittedAccountInfo = formattedAccountInfo.split(" ");
                    foofle.MySqlHandler.addAccount(splittedAccountInfo);
                    break;
                case 2:
                    System.out.println("please enter login info: username password");
                    in = new Scanner(System.in);
                    formattedAccountInfo = in.nextLine();
                    splittedAccountInfo = formattedAccountInfo.split(" ");
                    foofle.MySqlHandler.login(splittedAccountInfo);
                    break;
                case 3:
                    System.out.println("please edit your account info: firstname lastname nikname username pass address mobile");
                    in = new Scanner(System.in);
                    formattedAccountInfo = in.nextLine();
                    splittedAccountInfo = formattedAccountInfo.split(" ");
                    foofle.MySqlHandler.updateAccount(splittedAccountInfo);
                    break;
                case 4:
                    System.out.println("delete my account");
                    in = new Scanner(System.in);
                    foofle.MySqlHandler.deleteAccount();
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
    }

}

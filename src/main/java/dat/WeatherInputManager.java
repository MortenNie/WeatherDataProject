package dat;


import java.util.Scanner;

public class WeatherInputManager {


    public void cityInput() {


        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter your city of interest : ");

            String city = sc.nextLine();
            System.out.println("You have search for : " + city);

            sc.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        }
}

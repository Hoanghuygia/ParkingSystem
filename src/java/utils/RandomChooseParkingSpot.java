/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Random;

/**
 *
 * @author LAPTOP
 */
public class RandomChooseParkingSpot {
    public static String chooseRandomParkingSpot(String marker){
        return marker + RandomChooseParkingSpot.generateRandomChar('A', 'O') + RandomChooseParkingSpot.generateRandomNumber(51);
    }
    public static char generateRandomChar(char start, char end) {
        Random random = new Random();
        return (char) (start + random.nextInt(end - start + 1));
    }
    public static int generateRandomNumber(int end){
        Random random = new Random();
        return random.nextInt(end);
    }
}

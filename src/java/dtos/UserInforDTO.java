/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 *
 * @author LAPTOP
 */
public class UserInforDTO {
    private String username;
    private String firstName;
    private String lastName;
    private String creditNumber;
    private int coin;
    private String phoneNumber;
    private int vehicleNumber;
    
    public UserInforDTO(String username, String firstName, String lastName, String creditNumber, String phoneNumber){
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.creditNumber = creditNumber;
        this.phoneNumber = phoneNumber;
        this.coin = 0;
        this.vehicleNumber = 0;
    }
    public UserInforDTO(String username, String firstName, String lastName, String creditNumber, String phoneNumber, int coin, int vehicle_number){
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.creditNumber = creditNumber;
        this.phoneNumber = phoneNumber;
        this.coin = coin;
        this.vehicleNumber = vehicle_number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCreditNumber() {
        return creditNumber;
    }

    public void setCreditNumber(String creditNumber) {
        this.creditNumber = creditNumber;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(int vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    
    
}


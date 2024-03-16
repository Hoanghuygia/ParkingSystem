/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;


/**
 *
 * @author LAPTOP
 */
public class ParkingDTO {
    private String username ;
    private String code;
    private String spot;
    private String startTime;
    private String endTime;
    private String typeTransportation;
    
    public ParkingDTO(String username, String code){
        this.username = username;
        this.code = code;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSpot() {
        return spot;
    }

    public void setSpot(String spot) {
        this.spot = spot;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTypeTransportation() {
        return typeTransportation;
    }

    public void setTypeTransportation(String typeTransportation) {
        this.typeTransportation = typeTransportation;
    }
  
}

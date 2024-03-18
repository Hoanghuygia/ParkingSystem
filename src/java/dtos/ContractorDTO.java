/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 *
 * @author LAPTOP
 */
public class ContractorDTO {
    private String username;
    private String typeTransportation;
    private String code;
    private String date;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getTypeTransportation() {
        return typeTransportation;
    }

    public void setTypeTransportation(String typeTransportation) {
        this.typeTransportation = typeTransportation;
    }

}

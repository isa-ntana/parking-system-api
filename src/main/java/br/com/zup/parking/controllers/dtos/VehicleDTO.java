package br.com.zup.parking.controllers.dtos;

import java.time.*;

public class VehicleDTO {
    private String plate; //placa
    private LocalDateTime arrival_time; //entrada
    private LocalDateTime departure_time; //saida
    private int price;

    //padrão BEAN - todo DTO deve ter um construtor vázio
    public VehicleDTO() {
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public LocalDateTime getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(LocalDateTime arrival_time) {
        this.arrival_time = arrival_time;
    }

    public LocalDateTime getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(LocalDateTime departure_time) {
        this.departure_time = departure_time;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

package br.com.zup.parking.controllers.dtos;

import jakarta.validation.constraints.*;

public class PlateDTO {
    @NotNull(message = "Numero da Placa obrigatório")
    @Size(min = 7, max = 7, message = "Formato da placa invalido")
    private String plate;

    public PlateDTO(String plate) {
        this.plate = plate;
    }

    public PlateDTO() {}

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }
}

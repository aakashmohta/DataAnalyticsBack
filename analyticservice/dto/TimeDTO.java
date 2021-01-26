package com.example.analyticservice.dto;

import java.time.LocalDateTime;

public class TimeDTO {
    LocalDateTime dateStartDTO;
    LocalDateTime dateEndDTO;

    public LocalDateTime getDateStartDTO() {
        return dateStartDTO;
    }

    public void setDateStartDTO(LocalDateTime dateStartDTO) {
        this.dateStartDTO = dateStartDTO;
    }

    public LocalDateTime getDateEndDTO() {
        return dateEndDTO;
    }

    public void setDateEndDTO(LocalDateTime dateEndDTO) {
        this.dateEndDTO = dateEndDTO;
    }
}

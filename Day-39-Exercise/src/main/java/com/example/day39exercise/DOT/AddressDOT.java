package com.example.day39exercise.DOT;

import com.example.day39exercise.Model.Teacher;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDOT {

    private Integer teacher_id;

    @NotEmpty(message = "area cannot be empty")
    private String area;


    @NotNull(message = "building number cannot be empty")
    @Positive(message = "building number cannot be negative")
    private Integer buildingNumber;

    @NotEmpty(message = "street cannot be empty")
    private String street;


}

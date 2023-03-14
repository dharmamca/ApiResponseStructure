package com.flight.schedule.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.flight.schedule.demo.util.CustomDateDeserializer;
import com.flight.schedule.demo.util.FlightUtil;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;


import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.format.DateTimeFormatter;

@Data
@Validated
public class FlightSearchRequest {

    @NotBlank(message = "departure airport should not be blank")
    private String departureAirport;

    @NotBlank(message = "arrival airport should not be blank")
    private String arrivalAirport;

    @JsonDeserialize(using = CustomDateDeserializer.class)
    private OffsetDateTime travelDate;

    @NotNull(message = "sortBy should not be null")
    private FlightSearchSort sortBy;




}

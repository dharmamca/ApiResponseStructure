package com.flight.schedule.demo.controller;

import com.flight.schedule.demo.annotation.IgnoreResponseBinding;
import com.flight.schedule.demo.common.response.ApiResponse;
import com.flight.schedule.demo.model.FlightEntryRequest;
import com.flight.schedule.demo.model.FlightSearchRequest;
import com.flight.schedule.demo.model.FlightSearchResponse;
import com.flight.schedule.demo.service.FlightService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flight")
@AllArgsConstructor
@Validated
public class FlightController {

    private FlightService flightService;


    @PostMapping("/entry")
    public ApiResponse makeFlightEntry(@Valid @RequestBody List<FlightEntryRequest> flightEntryRequests){
        flightService.createFlightEntry(flightEntryRequests);
        return ApiResponse.voidResponse();
    }

    @PostMapping("/search")
    @IgnoreResponseBinding
    public List<FlightSearchResponse> searchFlights(@Valid @RequestBody FlightSearchRequest flightSearchRequest){
        return flightService.searchFlight(flightSearchRequest);
    }

    @PostMapping("/search/map")
    public List<FlightSearchResponse> searchFlightsApiResponse(@Valid @RequestBody FlightSearchRequest flightSearchRequest){
        return flightService.searchFlight(flightSearchRequest);
    }
}

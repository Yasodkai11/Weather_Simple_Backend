package com.weathersite.weatherms.controller;

import com.weathersite.weatherms.dto.WeatherDTO;
import com.weathersite.weatherms.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/weather")

public class WeatherController {
    @Autowired
    private WeatherService weatherService;
    @PostMapping(value = "/saveWeather")
    public ResponseEntity saveWeather(@RequestBody WeatherDTO weatherDTO){
        try {
            String res = weatherService.saveWeather(weatherDTO);
            if(res.equals("00")){
                return new ResponseEntity(weatherDTO , HttpStatus.ACCEPTED);
            }else if(res.equals("06")) {
                return new ResponseEntity("Weather is Registered", HttpStatus.BAD_REQUEST);
            }
            else{
                return  new ResponseEntity("Error",HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping(value = "/updateWeather")
    public ResponseEntity updateWeather(@RequestBody WeatherDTO weatherDTO){
        try {
            String res = weatherService.updateWeather(weatherDTO);
            if(res.equals("00")){
                return new ResponseEntity(weatherDTO , HttpStatus.ACCEPTED);
            }else if(res.equals("01")) {
                return new ResponseEntity("Weather is not Registered", HttpStatus.BAD_REQUEST);
            }
            else{
                return  new ResponseEntity("Error",HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping(value =" /getAllWeather")
    public ResponseEntity<?> getAllPublishers() {
        try {

            List<WeatherDTO> weatherDTOList = weatherService.getAllWeather();
            return new ResponseEntity<>(weatherDTOList, HttpStatus.ACCEPTED);
        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/searchWeather/{weather_id}")
    public ResponseEntity searchWeather(@PathVariable int weather_id) {
        try {

            WeatherDTO weatherDTO = weatherService.searchWeather(weather_id);
            if (weatherDTO != null) {

                return new ResponseEntity<>(weatherDTO, HttpStatus.ACCEPTED);
            } else {

                return new ResponseEntity<>("No weather Available For this weather_id", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/deleteWeather/{weather_id}")
    public ResponseEntity<?> deleteWeather(@PathVariable int weather_id) {
        try {

            String res = weatherService.deleteWeather(weather_id);
            if (res.equals("00")) {

                return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
            } else {

                return new ResponseEntity<>("No Weather Available For this weather_id", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}



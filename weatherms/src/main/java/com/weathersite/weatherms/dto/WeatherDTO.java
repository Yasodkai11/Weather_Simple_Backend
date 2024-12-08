package com.weathersite.weatherms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class WeatherDTO {
    private int weather_id;
    private int temperature;
    private String weather_type;
    private String country;
}

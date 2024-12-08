package com.weathersite.weatherms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Weather")

public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int weather_id;
    private int temperature;
    private String weather_type;
    private String country;

}

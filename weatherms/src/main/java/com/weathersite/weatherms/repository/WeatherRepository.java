package com.weathersite.weatherms.repository;

import com.weathersite.weatherms.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {
}

package com.weathersite.weatherms.service;

import com.weathersite.weatherms.dto.WeatherDTO;
import com.weathersite.weatherms.entity.Weather;
import com.weathersite.weatherms.repository.WeatherRepository;
import com.weathersite.weatherms.utill.VariableList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional

public class WeatherService {

    @Autowired
    private WeatherRepository weatherRepository;

    @Autowired
    private ModelMapper modelMapper;

public String saveWeather(WeatherDTO weatherDTO){
    if(weatherRepository.existsById(weatherDTO.getWeather_id())){
        return VariableList.RESPONSE_DUPLICATED;
    }else{
        weatherRepository.save(modelMapper.map(weatherDTO, Weather.class));
        return VariableList.RESPONSE_SUCCESS;

    }

}
public String updateWeather(WeatherDTO weatherDTO){
    if(weatherRepository.existsById(weatherDTO.getWeather_id())){
        weatherRepository.save(modelMapper.map(weatherDTO, Weather.class));
        return VariableList.RESPONSE_SUCCESS;

    }else{
        return VariableList.RESPONSE_NO_DATA_FOUND;
    }
}
public List<WeatherDTO>getAllWeather(){
    List<Weather> weatherList = weatherRepository.findAll();
    return modelMapper.map(weatherList,new TypeToken<ArrayList<WeatherDTO>>(){}.getType());
}
    public WeatherDTO searchWeather(int weather_id) {
        if (weatherRepository.existsById(weather_id)) {
            Weather weather = weatherRepository.findById(weather_id).orElse(null);
            return modelMapper.map(weather, WeatherDTO.class);
        } else {
            return null;
        }
    }
    public String deleteWeather(int weather_id) {
        if (weatherRepository.existsById(weather_id)) {
            weatherRepository.deleteById(weather_id);
            return VariableList.RESPONSE_SUCCESS;
        } else {
            return VariableList.RESPONSE_NO_DATA_FOUND;
        }
    }
}

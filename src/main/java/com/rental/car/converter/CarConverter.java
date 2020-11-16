package com.rental.car.converter;

import java.util.List;

import com.rental.car.dto.CarDTO;
import com.rental.car.model.Car;
import com.rental.car.request.CarRequest;

public interface CarConverter {
	
	Car convert(CarDTO carDto) throws Exception;
	
	List<Car> convertAll(List<CarDTO> carDto) throws Exception;
	
	CarDTO reverseConvert(Car car);
	
	List<CarDTO> reverseConvertAll(List<Car> car);

	Car convert(CarRequest carRequest);
}

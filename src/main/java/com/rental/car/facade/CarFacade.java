package com.rental.car.facade;

import java.util.List;

import com.rental.car.dto.CarDTO;
import com.rental.car.request.CarRequest;

public interface CarFacade {

	List<CarDTO> getAllCars();
	
	CarDTO getCarDtoById(Long id);
	
	List<CarDTO> getCarDtoByCategory(Long id);
	
	CarDTO createCar(CarRequest carReqeust) throws Exception;
	
	CarDTO updateCarDto(Long id, CarRequest carReqeust) throws Exception;
	
	void deleteCarDto(Long id);

}
package com.rental.car.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rental.car.converter.CarConverter;
import com.rental.car.dto.CarDTO;
import com.rental.car.model.Car;
import com.rental.car.model.Category;
import com.rental.car.request.CarRequest;
import com.rental.car.service.CarService;

@Component("carFacade")
public class CarFacadeImpl implements CarFacade {

	@Autowired
	private CarService carService;
	
	@Autowired
	private CarConverter carConverter;
	
	@Override
	public List<CarDTO> getAllCars() {
		List<Car> car = carService.getAllCars();
		return carConverter.reverseConvertAll(car);
	}

	@Override
	public CarDTO getCarDtoById(Long id) {
		Car car = carService.getCarById(id);
		CarDTO carDto = carConverter.reverseConvert(car);
		return carDto;
	}

	@Override
	public List<CarDTO> getCarDtoByCategory(Long idCategory) {
		List<Car> car = carService.getCarByCategory(idCategory);
		List<CarDTO> carDto = carConverter.reverseConvertAll(car);
		return carDto;
	}
	
	@Override
	public CarDTO createCar(CarRequest carRequest) throws Exception {
		Car car = carConverter.convert(carRequest);
		carService.createCar(car);
		return carConverter.reverseConvert(car);
	}

	@SuppressWarnings("unused")
	@Override
	public CarDTO updateCarDto(Long id, CarRequest carRequest) throws Exception {
		Car car = carConverter.convert(carRequest);
		
		String model = car.getCarModel();
		String manufacturer = car.getManufacturer();
		int year = car.getYearOfRegistration();
		String license = car.getCarLicensePlate();
		Category category = car.getCategory();
		
		if(car!=null) {
			car = carService.updateCar(id, model, manufacturer, license, year, category);
			CarDTO carDto = carConverter.reverseConvert(car);
			return carDto;
		}
		return null;
	}

	@Override
	public void deleteCarDto(Long id) {
		carService.deleteCar(id);
	}

}
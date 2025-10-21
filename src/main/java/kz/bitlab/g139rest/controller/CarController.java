package kz.bitlab.g139rest.controller;

import kz.bitlab.g139rest.entity.Car;
import kz.bitlab.g139rest.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping
    public List<Car> getCars() {
        List<Car> cars = carService.getCars();
        return cars;
    }

    @PostMapping
    public Car addCar(@RequestBody Car car) {
        return carService.addCar(car);
    }

    @PutMapping
    public Car updateCar(@RequestBody Car car) {
        return carService.editCar(car);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCarById(id);
    }
}

package Service;

import Domain.Car;
import Repository.IRepository;

import java.util.List;

public class CarService {

    private IRepository<Car> repository;

    public CarService(IRepository<Car> repository) {
        this.repository = repository;
    }

    public List<Car> getAll() {
        return repository.getAll();
    }

    public void addOrUpdate(String id, String Model, int Km, double Price) {
            Car car = new Car(id, Model, Km, Price);
            repository.upsert(car);
        }

}

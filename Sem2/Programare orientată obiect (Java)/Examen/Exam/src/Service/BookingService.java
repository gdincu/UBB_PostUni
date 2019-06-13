package Service;

import Domain.Booking;
import Domain.Car;
import Repository.IRepository;

import java.util.ArrayList;
import java.util.List;

public class BookingService {

    private IRepository<Booking> repository;
    private IRepository<Car> carRepository;

    public BookingService(IRepository<Booking> repository, IRepository<Car> carRepository) {
        this.repository = repository;
        this.carRepository = carRepository;
    }

    public List<Booking> getAll() {
        return repository.getAll();
    }

    public void addOrUpdate(String bookingId, String carId, int days, int km) {
        Booking booking = new Booking(bookingId, carId, days, km);

        for (Booking c : repository.getAll())
            if (c.getBookingId().equals(bookingId))
                throw new RuntimeException("A booking with the same ID already exists!");

            List<String> carIdList = new ArrayList<>();
            for(Car t : carRepository.getAll())
                carIdList.add(t.getId());

            if(!carIdList.contains(carId))
                throw new RuntimeException("The car Id is invalid!");

        repository.upsert(booking);
    }
}

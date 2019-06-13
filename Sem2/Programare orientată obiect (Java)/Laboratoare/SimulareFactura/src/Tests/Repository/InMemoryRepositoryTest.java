package Repository;

import Domain.Factura;
import Domain.FacturaValidator;
import Domain.IValidator;
import Service.FacturaService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryRepositoryTest {

    Factura A = new Factura(1,2.2,"DDD","12.12.2012");
    IValidator<Factura> receiptValidator = new FacturaValidator();
    IRepository<Factura> receiptRepository = new InMemoryRepository<>(receiptValidator);
    FacturaService receiptService = new FacturaService(receiptRepository);

    @Test
    void findById() {
        receiptRepository.upsert(A);
    assertEquals(A,receiptRepository.findById(1));
    }

    @Test
    void upsert() {
        receiptRepository.upsert(A);
        assertEquals(A,receiptRepository.findById(1));
    }

    @Test
    void remove() {
        receiptRepository.upsert(A);
        receiptRepository.remove(1);
        assertEquals(null,receiptRepository.findById(1));
    }

    @Test
    void getAll() {
        assertEquals(true,receiptRepository.getAll().isEmpty());
    }
}
package Service;

import Domain.Factura;
import Domain.FacturaValidator;
import Domain.IValidator;
import Repository.IRepository;
import Repository.InMemoryRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsSearchableTest {

    IValidator<Factura> receiptValidator = new FacturaValidator();
    IRepository<Factura> receiptRepository = new InMemoryRepository<>(receiptValidator);
    FacturaService receiptService = new FacturaService(receiptRepository);

    @Test
    void fullTextSearch() {
        Factura A = new Factura(1,2.2,"tofind","12.12.2012");
        receiptService.addReceipt(1,2.2,"tofind","12.12.2012");
        assertEquals(true,receiptService.fullTextSearch("tofind").isEmpty());
    }
}
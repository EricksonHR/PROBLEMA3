import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BasicReceiptTest {
    Receipt rebut;

    @BeforeEach
    void initReceipt() throws IsClosedException {
        rebut = new Receipt();
        rebut.addLine(BigDecimal.valueOf(2.5), 4);
    }

    @Test
    void addLineTest() {
        BigDecimal result = BigDecimal.valueOf(10.0);
        assertEquals(result, rebut.total);
    }

    @Test
    void getTotalTest() {
        assertEquals(BigDecimal.valueOf(10.0), rebut.getTotal());
    }

    @Test
    void addTaxesTest() throws IsClosedException {
        rebut.addTaxes(BigDecimal.valueOf(0.21));
        BigDecimal tax = BigDecimal.valueOf(10.0).multiply(BigDecimal.valueOf(0.21));
        BigDecimal total = tax.add(BigDecimal.valueOf(10.0));
        assertEquals(total, rebut.getTotal());
    }

}

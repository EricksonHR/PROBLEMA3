import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class EmptyReceiptTest {
    Receipt rebut;

    @BeforeEach
    void initReceipt() {
        rebut = new Receipt();
    }

    @Test
    void getTotalEmpty() {
        assertEquals(BigDecimal.valueOf(0), rebut.getTotal());
    }

    @Test
    void addTaxesEmpty() throws IsClosedException {
        rebut.addTaxes(BigDecimal.valueOf(0.21));
        BigDecimal expected = BigDecimal.valueOf(0).multiply(BigDecimal.valueOf(0.21));
        assertEquals(expected, rebut.getTotal());
    }
}

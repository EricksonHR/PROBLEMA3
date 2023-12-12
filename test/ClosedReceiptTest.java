import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ClosedReceiptTest {
    Receipt rebut;

    @BeforeEach
    void initReceipt() throws IsClosedException {
        rebut = new Receipt();
        rebut.addTaxes(BigDecimal.valueOf(0.21));
    }

    @Test
    void addLineClosed() throws IsClosedException {
        assertThrows(IsClosedException.class, () -> {rebut.addLine(BigDecimal.valueOf(1.1), 2);});
    }

    @Test
    void addTaxesClosed() throws IsClosedException {
        assertThrows(IsClosedException.class, () -> {rebut.addTaxes(BigDecimal.valueOf(0.1));});
    }

    @Test
    void getTotalClosed() throws IsClosedException {
        assertEquals(BigDecimal.valueOf(0.0), rebut.getTotal());
    }
}

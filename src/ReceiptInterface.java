import java.math.BigDecimal;

public interface ReceiptInterface {
    public void addLine(BigDecimal pricePerUnit, int numUnits) throws IsClosedException;
    public void addTaxes(BigDecimal percent) throws IsClosedException;
    public BigDecimal getTotal();
}

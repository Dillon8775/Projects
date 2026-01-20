package other;

public class InvoiceTest {

    public static void main(String[] args) {
        Invoice invoice = new Invoice("1", "Invoice for clothes.", 7, 25.99);

        printInvoice(invoice);

        invoice.setNumber("2");
        invoice.setDescription("Invoice for greeting cards.");
        invoice.setQuantity(25);
        invoice.setPricePerItem(1.99);

        printInvoice(invoice);
    }

    private static void printInvoice(Invoice invoice) {
        System.out.printf("Invoice Number: %s %nDescription: %s\n %nQuantity of Items: %s %nPrice per item: $%s %nInvoice Total: $%s%n%n---%n",
                invoice.getNumber(), invoice.getDescription(), invoice.getQuantity(), invoice.getPricePerItem(), invoice.getInvoiceTotal());
    }
}
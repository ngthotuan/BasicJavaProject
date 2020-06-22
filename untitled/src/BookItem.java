public class BookItem extends Book {
    private String barcode;

    public BookItem() {
    }

//    public BookItem(String name){
//        super(name);
//    }
    public BookItem(String name, String barcode) {
        super(name);
        this.barcode = barcode;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}

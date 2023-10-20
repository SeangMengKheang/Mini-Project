package database;

import java.time.LocalDate;

public class Product {
    public short ID;
    public String Name;
    public double UnitPrice;
    public short Qty;
    public LocalDate ImportDate;

    public Product() {}
    public Product(short ID, String Name, double UnitPrice, short Qty, LocalDate ImportDate) {
        this.ID = ID;
        this.Name = Name;
        this.UnitPrice = UnitPrice;
        this.Qty = Qty;
        this.ImportDate = ImportDate;
    }
    public short getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public short getQty() {
        return Qty;
    }
    public void setID(short ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setUnitPrice(double unitPrice) {
        UnitPrice = unitPrice;
    }

    public void setQty(short qty) {
        Qty = qty;
    }

    public void setImportDate(LocalDate importDate) {
        ImportDate = importDate;
    }

    public LocalDate getImportDate() {
        return ImportDate;
    }
    @Override
    public String toString() {
        return "Product{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Price=" + UnitPrice +
                ", Qty=" + Qty +
                ", ImportDate=" + ImportDate +
                '}';
    }

}

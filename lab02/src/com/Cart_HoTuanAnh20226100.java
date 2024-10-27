package com;
public class Cart_HoTuanAnh20226100 {
    public static final int MAX_NUMBERS_ORDERED = 20;   // Số lượng đĩa tối đa
    private DigitalVideoDisc_HoTuanAnh20226100 itemOrdered[] = new DigitalVideoDisc_HoTuanAnh20226100[MAX_NUMBERS_ORDERED];  // Mảng chứa danh sách đĩa
    private int qtyOrdered = 0;    // SỐ lượng đĩa hiện tại

    // Getter
    public DigitalVideoDisc_HoTuanAnh20226100[] getDigitalVideoDisc() {
        return itemOrdered;
    }
    
    public int getQtyOrdered() {
        return qtyOrdered;
    }

    // Thêm đĩa mới
    public void addDigitalVideoDisc(DigitalVideoDisc_HoTuanAnh20226100 disc) {
        if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("HoTuanAnh-20226100 The card is almost full");
            return;
        }
        itemOrdered[qtyOrdered++] = disc;
        System.out.println("HoTuanAnh-20226100 The disc has been added");
    }

    // Xóa đĩa
    public void removeDigitalVideoDisc(DigitalVideoDisc_HoTuanAnh20226100 disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            // Tìm vị trí đĩa
            if (itemOrdered[i].equals(disc)) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemOrdered[j] = itemOrdered[j + 1];
                }
                itemOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                break;
            }
        }
        System.out.println("HoTuanAnh-20226100 The disc has been removed");
    }

    // Tính tổng tiền
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemOrdered[i].getCost();
        }
        return total;
    }

    // In hóa đơn
    public void print() {
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println(i+1 +". "+itemOrdered[i].getDirector()+", "+itemOrdered[i].getCatelogy()+", "+itemOrdered[i].getTitle()+
                                ", "+itemOrdered[i].getLength()+", "+itemOrdered[i].getCost());
        }
        System.out.printf("HoTuanAnh-20226100 Total cost is: %.2f\n\n", totalCost());
    }

}

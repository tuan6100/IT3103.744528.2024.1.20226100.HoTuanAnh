package hotuananh20226100;

public class Aims_HoTuanAnh20226100 {
    public static void main(String[] args) {
          //Tạo giỏ hàng trống
        Cart_HoTuanAnh20226100 cart = new Cart_HoTuanAnh20226100();
    
        //Thêm đĩa vào giỏ hàng
        DigitalVideoDisc_HoTuanAnh20226100 dvd1 = new DigitalVideoDisc_HoTuanAnh20226100("The Lion King","Animation", "Roger Allers",87,19.95f);
        cart.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc_HoTuanAnh20226100 dvd2 = new DigitalVideoDisc_HoTuanAnh20226100("Star wars","Science Fiction", "Geogre Lucas",87,24.95f);
        cart.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc_HoTuanAnh20226100 dvd3 = new DigitalVideoDisc_HoTuanAnh20226100("Aladin","Animation",18.99f);
        cart.addDigitalVideoDisc(dvd3);
    
        //Kiểm tra khi chưa thực hiện hàm xoá            
        cart.print();
    
        //Kiểm tra khi dã thực hiện hàm xoá
        cart.removeDigitalVideoDisc(dvd2);
        //Hàm System.out.printf() định dạng in như ngôn ngữ C/C++
         cart.print();
    }
}

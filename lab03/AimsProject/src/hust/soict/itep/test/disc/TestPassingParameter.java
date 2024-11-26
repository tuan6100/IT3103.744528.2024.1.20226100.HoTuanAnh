package hust.soict.itep.test.disc;


import java.lang.reflect.Field;
import hust.soict.itep.aims.disc.DigitalVideoDisc_HoTuanAnh20226100;

public class TestPassingParameter {
 
    public static void main(String[] args) {
        DigitalVideoDisc_HoTuanAnh20226100 jungleDVD = new DigitalVideoDisc_HoTuanAnh20226100("Jungle");
        DigitalVideoDisc_HoTuanAnh20226100 cinderellaDVD = new DigitalVideoDisc_HoTuanAnh20226100("Cinderella");
    
        swap(jungleDVD, cinderellaDVD);
        System.out.println("Jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle() +"\n");

        correctSwap(jungleDVD, cinderellaDVD);
        System.out.println("Jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle() +"\n");

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("Junge dvd title: " + jungleDVD.getTitle());

        
    }


    public static void swap(Object o1, Object o2) {
        Object temp = o1;
        o1 = o2;
        o2 = temp;
    }


    public static void correctSwap(DigitalVideoDisc_HoTuanAnh20226100 dvd1, DigitalVideoDisc_HoTuanAnh20226100 dvd2) {
        // Tạo mảng chứa các thuộc tính 
        Field[] fields = dvd1.getClass().getDeclaredFields();
        for (Field field : fields) {
            // Cho phép truy cập private
            field.setAccessible(true);  
            try {
                Object temp = field.get(dvd1);
                field.set(dvd1, field.get(dvd2));
                field.set(dvd2, temp);
            } catch (IllegalAccessException e) {
                e.getMessage();
            }
        }
    }


    public static void changeTitle(DigitalVideoDisc_HoTuanAnh20226100 dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc_HoTuanAnh20226100(oldTitle);
    }

    
}

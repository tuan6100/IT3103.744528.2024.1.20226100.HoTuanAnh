package hotuananh20226100;

import java.util.List;

public class TestPassingParameter {
 
    public static void main(String[] args) {
        DigitalVideoDisc_HoTuanAnh20226100 jungleDVD = new DigitalVideoDisc_HoTuanAnh20226100("Jungle");
        DigitalVideoDisc_HoTuanAnh20226100 cinderellaDVD = new DigitalVideoDisc_HoTuanAnh20226100("Cinderella");

    
        swap(jungleDVD, cinderellaDVD);
        System.out.println("Jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle() +"\n");

        // Truyền tham chiếu thông qua mảng
        DigitalVideoDisc_HoTuanAnh20226100[] dvds = {jungleDVD, cinderellaDVD};
        correctSwap(dvds, 0, 1);
        System.out.println("Jungle dvd title: " + dvds[0].getTitle());
        System.out.println("cinderella dvd title: " + dvds[1].getTitle() +"\n");

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("Junge dvd title:" + jungleDVD.getTitle());

        List<String> names = (List) Co
    }


    public static void swap(Object o1, Object o2) {
        Object temp = o1;
        o1 = o2;
        o2 = temp;
    }


    public static void correctSwap(DigitalVideoDisc_HoTuanAnh20226100[] dvds, int index1, int index2) {
        DigitalVideoDisc_HoTuanAnh20226100 temp = dvds[index1];
        dvds[index1] = dvds[index2];
        dvds[index2] = temp;
    }


    public static void changeTitle(DigitalVideoDisc_HoTuanAnh20226100 dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc_HoTuanAnh20226100(oldTitle);
    }

    
}

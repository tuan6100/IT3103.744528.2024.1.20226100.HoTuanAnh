package hust.soict.itep.aims;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hust.soict.itep.aims.cart.Cart;
import hust.soict.itep.aims.media.*;
import hust.soict.itep.aims.store.Store;


public class Aims {


    public static void showMenu(Scanner scanner, Store store, Cart cart) {
        while (true) {
            System.out.println("\n AIMS: ");
		    System.out.println("--------------------------------");
            System.out.println("1. View store");
            System.out.println("2. Update store");
		    System.out.println("3. See current cart");
		    System.out.println("0. Exit");
		    System.out.println("--------------------------------");
		    System.out.println("Please choose a number: 0-1-2-3");

            int option = scanner.nextInt();
            switch (option) {

                case 0 : {
                    System.out.println("Thank you.\n");
                    scanner.close();
                    System.exit(0);
                }

                case 1 : {
                    storeMenu(scanner, store, cart);
                    break;
                }

                case 2 : { 
                    updateStoreMenu(scanner, store);
                    break;
                }

                case 3 : {
                    cart.print();
                    cartMenu(scanner,cart);
                    break;
                }

                default : {
                    System.out.println("No option. Try again.");
                    break;
                }
            }
        }
    }


    public static void storeMenu(Scanner scanner, Store store, Cart cart) {
        System.out.println("\n");
        store.print();
        while (true) {
            System.out.println("\n Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {

                case 0 : return;

                case 1 : {
                    mediaDetailsMenu(scanner, store, cart);
                    break;
                }

                case 2 : {
                    System.out.print("Enter media's title: ");
                    String title = scanner.nextLine();
                    Media media = store.searchByTitle(title);
                    if (media == null) {
                        System.out.println("No media found");
                    } else {
                        try {
                            cart.addMedia(media);
                        } catch (Exception e) {
                            e.getMessage();
                        }
                    }
                    break;
                }

                case 3 : {
                    System.out.print("Enter media's title: ");
                    String title = scanner.nextLine();
                    Media media = store.searchByTitle(title);
                    if (media == null) {
                        System.out.println("No media found");
                    } else {
                        if (media.getClass().getSimpleName().equals("Book")) {
                            System.out.println("This media is not disc");
                        } else {
                            if (media instanceof DigitalVideoDisc) {
                                DigitalVideoDisc dvd = (DigitalVideoDisc) media;
                                dvd.play();
                            } else if (media instanceof CompactDisc) {
                                CompactDisc cd = (CompactDisc) media;
                                cd.play();
                            }
                            
                        }
                    }
                    break;
                }

                case 4 : {
                    cart.print();
                    cartMenu(scanner,cart);
                    break;
                }

                default: {
                    System.out.println("No option. Try again.");
                    break;
                }
            }
        }
    }


    public static void updateStoreMenu(Scanner scanner, Store store) {
        System.out.println("\n Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add media");
		System.out.println("2. Remove media");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
        int option = scanner.nextInt();
        switch (option) {

            case 0 : return;

            case 1 : {
                System.out.println("Choose media type: ");
                System.out.println("------------------------");
                System.out.println("1. Book");
                System.out.println("2. DVD");
                System.out.println("3. CD");
                System.out.println("0. Back");
                System.out.println("------------------------");
                System.out.println("Please choose a number: 0-1-2-3");
                int option2 = scanner.nextInt();
                scanner.nextLine();
                switch (option2) {

                    case 0 : return;

                    case 1 : {
                        System.out.print("Enter id: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter category: ");
                        String category = scanner.nextLine();
                        System.out.print("Enter cost: ");
                        float cost = scanner.nextFloat();
                        scanner.nextLine();
                        System.out.println("Enter amount of authors: ");
                        int num = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter author name: ");
                        List<String> authors = new ArrayList<>();
                        for (int i = 0; i < num; i++) {
                            System.out.printf("Enter name of author %d: ", i + 1);
                            String author = scanner.nextLine();
                            authors.add(author);
                        }                              
                        try {
                            store.addMedia(new Book(id,title,category,cost,authors));
                        } catch (Exception e) {
                            e.getMessage();
                        }
                        break;
                    }

                    case 2 : {
                        System.out.print("Enter id: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter category: ");
                        String category = scanner.nextLine();
                        System.out.print("Enter cost: ");
                        float cost = scanner.nextFloat();
                        scanner.nextLine();
                        System.out.print("Enter director's name: ");
                        String director = scanner.nextLine();
                        System.out.print("Enter dvd's length: ");
                        int length = scanner.nextInt();
                        scanner.nextLine();
                        try {
                            store.addMedia(new DigitalVideoDisc(id, title, category, cost, length, director));
                        } catch (Exception e) {
                            e.getMessage();
                        }
                        break;
                    }

                    case 3 : {
                        System.out.print("Enter id: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter category: ");
                        String category = scanner.nextLine();
                        System.out.print("Enter cost: ");
                        float cost = scanner.nextFloat();
                        scanner.nextLine();
                        System.out.print("Enter director's name: ");
                        String director = scanner.nextLine();
                        System.out.print("Enter artist's name: ");
                        String artist = scanner.nextLine();
                        System.out.print("Enter amount of tracks: ");
                        int num = scanner.nextInt();
                        scanner.nextLine();
                        List<Track> tracks = new ArrayList<>();
                        for (int i = 0 ;i < num; i++) {
                            System.out.printf("Enter title of track %d : ", i + 1);
                            String trackTitle = scanner.nextLine();
                            System.out.printf("Enter length of track %d: ", i + 1);
                            int lenght = scanner.nextInt();
                            scanner.nextLine();
                            tracks.add(new Track(trackTitle, lenght));
                        }
                        try {
                            store.addMedia(new CompactDisc(id, title, category, cost, director, artist, tracks));
                        } catch (Exception e) {
                            e.getMessage();
                        }
                        break;
                    }

                    default : {
                        System.out.println("No option. Try again.");
                        break;
                    }
                }
                break;
            }

            case 2 : {
                System.out.println("Enter media's title: ");
                scanner.nextLine();
                String title = scanner.nextLine();
                Media media = store.searchByTitle(title);
                try {
                    store.removeMedia(media);
                } catch (Exception e) {
                    e.getMessage();
                }
                break;
            }

            default : {
                System.out.println("No option. Try again.");
                break;
            } 
        }
    }


    public static void mediaDetailsMenu(Scanner scanner, Store store, Cart cart) {
        System.out.print("Enter media's title: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if(media == null) {
            System.out.println("No media found");
            return;
        }
        System.out.println(media);
        while (true) {
            System.out.println("\n Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");

            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 : {
                    try {
                        cart.addMedia(media);
                    } catch (Exception e) {
                        e.getMessage();
                    } 
                    break;
                }

                case 2 : {
                    if (media.getClass().getSimpleName().equals("Book")) {
                        System.out.println("This media is unplayable");
                    } else {
                        if (media instanceof DigitalVideoDisc) {
                            DigitalVideoDisc dvd = (DigitalVideoDisc) media;
                            dvd.play();
                        } else if (media instanceof CompactDisc) {
                            CompactDisc cd = (CompactDisc) media;
                            cd.play();
                        }                       
                    }
                    break;
                }

                case 0 : {
                    return;
                }
            }
        }
    }

    

    public static void cartMenu(Scanner scanner,Cart cart) {
        while (true) {
            System.out.println("\n Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4-5");    
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 0 : {
                    return;
                }
                case 1 : {
                    System.out.println("Option: ");
                    System.out.println("______________");
                    System.out.println("1. Filter by title");
                    System.out.println("2. Filter by id");
                    System.out.println("______________");
                    System.out.println("Please choose a number: 1-2"); 
                    int option2 = scanner.nextInt();
                    scanner.nextLine();
                    if (option2 == 1) {
                        int id = scanner.nextInt();
                        System.out.println(cart.searchById(id).toString());
                    } else if (option2 == 2) {
                        String title = scanner.nextLine();
                        System.out.println(cart.searchByTitle(title).toString());
                    } else {
                        System.out.println("No option. Try again.");
                    }
                    break;
                }
                case  2 : {
                    System.out.println("Option: ");
                    System.out.println("______________");
                    System.out.println("1. Sort by title");
                    System.out.println("2. Sort by cost");
                    System.out.println("______________");
                    System.out.println("Please choose a number: 1-2"); 
                    int option2 = scanner.nextInt();
                    scanner.nextLine();
                    if (option2 == 1) {
                        cart.sortByTitleCost();
                        cart.print();
                    } else if (option2 == 2) {
                        cart.sortByCostTitle();
                        cart.print();
                    } else {
                        System.out.println("No option. Try again.");
                    }
                    break;
                }

                case 3 : {
                    System.out.print("Enter media's title: ");
                    String title = scanner.nextLine();
                    Media media = cart.searchByTitle(title);
                    if (media == null) {
                        System.out.println("No media found");
                    } else {
                        try {
                            cart.removeMedia(media);
                        } catch (Exception e) {
                            e.getMessage();
                        }
                    }
                    break;
                }

                case 4 : {
                    System.out.print("Enter media's title: ");
                    String title = scanner.nextLine();
                    Media media = cart.searchByTitle(title);
                    if (media == null) {
                        System.out.println("No media found");
                    } else {
                        if (media.getClass().getSimpleName().equals("Book")) {
                            System.out.println("This media is unplayable");
                        } else {
                            if (media instanceof DigitalVideoDisc) {
                                DigitalVideoDisc dvd = (DigitalVideoDisc) media;
                                dvd.play();
                            } else if (media instanceof CompactDisc) {
                                CompactDisc cd = (CompactDisc) media;
                                cd.play();
                            }                         
                        }
                    }
                    break;
                }

                case  5 : {
                    System.out.println("An order is created. ");
                    cart.empty();
                    break;
                }

                default : { 
                    System.out.println("No option. Try again.");
                    break;
                }
            }
        }
    }


    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();
        Scanner scanner = new Scanner(System.in);
        showMenu(scanner, store, cart);
    }
}

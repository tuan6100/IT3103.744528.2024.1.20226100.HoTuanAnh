package hust.soict.itep.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
     public static void main(String[] args) throws IOException {
        String filename = "hust/soict/itep/garbage/test.txt";
        byte[] inputBytes = {0};
        long startTime, endTime;
        try {
            String filePath = ClassLoader.getSystemResource(filename).getPath();
            inputBytes = Files.readAllBytes(Paths.get(filePath));
        } catch (NullPointerException e) {
            System.out.println("File not found: " + filename);
            return;
        }
        startTime = System.currentTimeMillis();
        StringBuilder outputStringBuilder = new StringBuilder();
        for(byte b : inputBytes) {
        	outputStringBuilder.append((char)b);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Execution time: " + (endTime - startTime) + " ms");
    }
}

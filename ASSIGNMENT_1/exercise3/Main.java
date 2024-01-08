package exercise3;

//imports 
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        // i exluded the file which i used to figure out X should be (hope thats ok?)
        int X = 150000000;
        

        // ArrayList test 
        ArrayList<Byte> AL = new ArrayList<>();
        long ALAddStartTime = System.currentTimeMillis();
        for (int i = 0; i < X; i++) {
            byte randomByte = (byte) (random.nextInt(256) - 128); //ngl i googled how to make a random int with in a range and then just casted it so it would be a byte, here's the site: https://mkyong.com/java/java-generate-random-integers-in-a-range/
            AL.add(randomByte);
        }
        long ALAddEndTime = System.currentTimeMillis();

        long  ALSumStartTime = System.currentTimeMillis();
        int sumArrayList = 0;
        for (Byte b : AL) {
            sumArrayList += b;
        }
        long ALSumEndTime = System.currentTimeMillis();

        // LinkedList test
        LinkedList<Byte> linkl = new LinkedList<>();
        long LLAddStartTime = System.currentTimeMillis();
        for (int i = 0; i < X; i++) {
            byte randomByte = (byte) (random.nextInt(256) - 128);
            linkl.add(randomByte);
        }
        long LLAddEndTime = System.currentTimeMillis();

        long LLSumStartTime = System.currentTimeMillis();
        int sumLinkedList = 0;
        for (Byte b : linkl) {
            sumLinkedList += b;
        }
        long LLSumEndTime = System.currentTimeMillis();

        // Array test 
        byte[] array = new byte[X];
        long arrayAddStartTime = System.currentTimeMillis();
        for (int i = 0; i < X; i++) {
            byte randomByte = (byte) (random.nextInt(256) - 128);
            array[i] = randomByte;
        }
        long arrayAddEndTime = System.currentTimeMillis();

        long arraySumStartTime = System.currentTimeMillis();
        int sumArray = 0;
        for (byte b : array) {
            sumArray += b;
        }
        long arraySumEndTime = System.currentTimeMillis();

        // Printing out the timing results
        System.out.println("ArrayList - Add: " + (ALAddEndTime - ALAddStartTime) + " ms");
        System.out.println("ArrayList - Sum: " + (ALSumEndTime - ALSumStartTime) + " ms");

        System.out.println("LinkedList - Add: " + (LLAddEndTime - LLAddStartTime) + " ms");
        System.out.println("LinkedList - Sum: " + (LLSumEndTime - LLSumStartTime) + " ms");

        System.out.println("Array - Add: " + (arrayAddEndTime - arrayAddStartTime) + " ms");
        System.out.println("Array - Sum: " + (arraySumEndTime - arraySumStartTime) + " ms");
    }
}

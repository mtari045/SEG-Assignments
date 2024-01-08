package exercise2;
//imports 
import design1.PointCP;
import design5.PointCP3;
import design5.PointCP5;
//so i can sort
import java.util.Arrays;

public class Test {
    
    //for table 1 
    public static String Test1(){
        
        int[] results = new int[5];
        int[] results5 = new int[5];
        
        for(int i = 1; i <= 5; i++ ) {
            int  interval  = i*5000;
            long realTime = 0;
            int design1Count = 0;

            long startTime = System.currentTimeMillis();
            
            while(realTime < interval) {
                PointCP point1 = new PointCP('C',i,i);

                point1.getX();
                point1.getY();
                point1.getRho();
                point1.getTheta();
                point1.convertStorageToCartesian();
                point1.convertStorageToPolar();
                point1.getDistance(point1);
                point1.rotatePoint(45);
                point1.toString();

               realTime = System.currentTimeMillis() - startTime;

               design1Count++;
               results[i-1] = design1Count;
            }

        }

        for(int i = 1; i <= 5; i++ ) {
            int  interval  = i*5000;
            long realTime = 0;
            int design5Count = 0;
            
            long startTime = System.currentTimeMillis();
            
            while(realTime < interval) {
                PointCP5 point5 = new PointCP3(i,i);

                point5.getX();
                point5.getY();
                point5.getRho();
                point5.getTheta();
                point5.convertStorageToCartesian();
                point5.convertStorageToPolar();
                point5.getDistance(point5);
                point5.rotatePoint(45);
                point5.toString();
            
               realTime = System.currentTimeMillis() - startTime;
               design5Count++;

               results5[i-1] = design5Count;
            }
        }

      String s = "\n design1:" + results[0] + "," + results[1] + "," + results[2] + "," + results[3] + "," + results[4] + "\n" + "design5:" + results5[0] + "," + results5[1] + "," + results5[2] + "," + results5[3] + "," + results5[4];
      return s;
    }
    
    //for table 2 
    public static String Test2() {
        
        int[] design1Counts = new int[20];
        int[] design5Counts = new int[20];

        for (int i =1; i<=20; i++){
            long realTime = 0;
            int pointsDesign1 = 0;
           
            long startTime = System.currentTimeMillis();

            while (realTime < 10000) {
                 PointCP point1 = new PointCP('C', i,i);
                 pointsDesign1++;
                 realTime = System.currentTimeMillis() - startTime;
            }
            design1Counts[i-1] = pointsDesign1;
        }

        for (int i =1; i<=20; i++){
            long realTime = 0;
            int pointsDesign5 = 0;
           
            long startTime = System.currentTimeMillis();

            while (realTime < 10000) {
                 PointCP5 point2 = new PointCP3(i,i);
                 pointsDesign5++;
                 realTime = System.currentTimeMillis() - startTime;
            }
            design5Counts[i-1] = pointsDesign5;
        }
       
        Arrays.sort(design1Counts);
        Arrays.sort(design5Counts);

        int maxDesign1 = design1Counts[design1Counts.length - 1];
        int minDesign1 = design1Counts[0];
        int medianDesign1 = findMedian(design1Counts);

        int maxDesign5 = design5Counts[design5Counts.length - 1];
        int minDesign5 = design5Counts[0];
        int medianDesign5 = findMedian(design5Counts);

        return "Design 1 - Max: " + maxDesign1 + ", Min: " + minDesign1 + ", Median: " + medianDesign1 +
               "\nDesign 5 - Max: " + maxDesign5 + ", Min: " + minDesign5 + ", Median: " + medianDesign5;
    }

    //calculate median for table 2, num of points 
    private static int findMedian(int[] array) {
        Arrays.sort(array);
        int middle = array.length / 2;
        return array[middle];
    }

    //for table 3 
    public static String Test3(){

        String result1 = "";

        for (int m =100; m <=10000000; m*=10){
            long startTime = System.currentTimeMillis();
            for (int i = 0; i< m;i ++){
                PointCP point1 = new PointCP('C', i, i);
                point1.getX();
                point1.getY();
                point1.getRho();
                point1.getTheta();
                point1.convertStorageToCartesian();
                point1.convertStorageToPolar();
                point1.getDistance(point1);
                point1.rotatePoint(45);
                point1.toString();
            }
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            result1 += "m = " + m + ", Time = " + elapsedTime + " ms\n";
        }
             
         String result2 = "";

        for (int m =100; m <=10000000; m*=10){
            long startTime2 = System.currentTimeMillis();
            for (int i = 0; i< m;i ++){
                PointCP5 point2 = new PointCP3( i, i);
                point2.getX();
                point2.getY();
                point2.getRho();
                point2.getTheta();
                point2.convertStorageToCartesian();
                point2.convertStorageToPolar();
                point2.getDistance(point2);
                point2.rotatePoint(45);
                point2.toString();
            }
            long endTime2 = System.currentTimeMillis();
            long elapsedTime2 = endTime2 - startTime2;
            result2 += "m = " + m + ", Time = " + elapsedTime2 + " ms\n";
        }

       String bothResults = result1+ result2;
       return  bothResults;
    }

    // for table 4 
    public static String Test4(){
        String result1 = "";
        long[] runTimes = new long[20];
        long[] runTimes2 = new long[20];

        for (int i = 1; i <=20; i++) {
            long startTime = System.nanoTime();
            for (long m = 0; m <1000000000; m++){
                PointCP point = new PointCP('C', i, i);
            }
            long endTime = System.nanoTime();
            runTimes[i-1] = endTime - startTime;
        }

         for (int i = 1; i <=20; i++) {
            
            long startTime = System.nanoTime();
            for (long m = 0; m <1000000000; m++){
                PointCP5 point2 = new PointCP3( 1.0, 1.0);
            }
            long endTime = System.nanoTime();
            runTimes2[i-1] = endTime - startTime;
        }
    
    //sort the arrays 
    Arrays.sort(runTimes);
    Arrays.sort(runTimes2);

    //calculate results for table 
    long median1 = calculateMedian(runTimes);
    long minimum1 = runTimes[0];
    long maximum1 = runTimes[runTimes.length - 1];

    long median2 = calculateMedian(runTimes2);
    long minimum2 = runTimes2[0];
    long maximum2 = runTimes2[runTimes2.length - 1];

    //return results 
    return "PointCP Results:\n" +
           "Median Time: " + median1 + " ns\n" +
           "Minimum Time: " + minimum1 + " ns\n" +
           "Maximum Time: " + maximum1 + " ns\n" +
           "PointCP5 Results:\n" +
           "Median Time: " + median2 + " ns\n" +
           "Minimum Time: " + minimum2 + " ns\n" +
           "Maximum Time: " + maximum2 + " ns";
    }

    // method to calculate median of the times held inside the array 
    private static long calculateMedian(long[] array) {
        int middle = array.length / 2;
        if (array.length % 2 == 1) {
            return array[middle];
        } else {
            return (array[middle - 1] + array[middle]) / 2;
        }
    }
    
    //calling all methods 
    public static void main (String[] args) {
        System.out.println("Test 1: " + Test1());
        System.out.println("Test 2: " + Test2());
        System.out.println("Test 3: " + Test3());
        System.out.println("Test 4: " + Test4());
    }

}
    


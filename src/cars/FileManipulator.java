package cars;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileManipulator {

    /**
     * This class contains the main method.
     * In the main method, the file manipulation functionality is implemented.
     * That is reading from a file and extracting the useful information.
     * The following ints hold the following information:
     * The number of cars, the numbers of types, the number of workers.
     */

    public static int carsN,typesN, workersN;

    public static void main(String[] args){
        try {


            File file = new File("/home/ioannis/IdeaProjects/2000Beijing/2000Beijing/src/cars/CAR.IN");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String info = br.readLine(); // The information part of the file. (includes the ints described above)
            String cars = br.readLine(); // The formation of the parking part of the file.

            int[] infoA = extractor(info); // Remove spaces from the string, store the ints in an array.
            int[] carsA = extractor(cars); // Remove spaces from the string, store the ints in an array. (Representing the parking)

            carsN = infoA[0]; // The first cell of the array holds the number of cars.
            typesN = infoA[1]; // The second cell of the array holds the number of types.
            workersN = infoA[2]; // The third cell of the array holds the number of workers.

            CarShorter shorter = new CarShorter(carsA, carsN, typesN, workersN); // Car
            shorter.segmentCreator(typesN);
            shorter.debugger();

        } catch(IOException e){
            System.err.println("IO Error occured");
        }
    }



    /**
     * Gets a string returns an array with the ints only
     * @param data the String inserted
     * @return The array with the numerical data
     */

    public static int[] extractor(String data){
        String[] s= data.split(" ");

        int[] intarray= new int[s.length];

        for(int i=0;i<s.length;i++){

            intarray[i]=Integer.parseInt(s[i]);
        }

        return intarray;
    }



}

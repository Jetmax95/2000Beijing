package cars;

import java.util.ArrayList;

public class CarShorter {

    private int[] carsA;
    private int carsN, typesN, workersN;
    private ArrayList<Integer> cars_per_type;
    private ArrayList<Segment> segments;

    /**
     * This class is responsible for producing the results and running the algorithm
     * @param carsA The array containing the cars position
     * @param carsN The number of cars in the arrayList
     * @param typesN The number of different types in the arraylist
     * @param workersN The number of workers that can work
     */
    public CarShorter(int[] carsA, int carsN, int typesN, int workersN){
            this.carsA = carsA; // car positioning
            this.carsN = carsN; // no of cars
            this.typesN = typesN; // no of car types.
            this.workersN = workersN; //no. of workers
            this.cars_per_type = new ArrayList<Integer>(); // This holds the ammount of cars that each type has
            this.segments = new ArrayList<Segment>(); //This ArrayList holds segment elements
    }

    /**
     * Every Segment holds information about the types of the car that it holds
     * Each segment's size is determined by the number of cars that we have per type.
     * Ex. If we have 3 cars of type 1, Segment 1 will have size 3.
     * @param types The total number of types that we have (typeN from FileManipulator)
     */

    public void segmentCreator(int types){

        // For every type of car that we have..
        for(int i = 1; i <= types; i++){
            int sum = 0; // holds the number of cars of type i
            for(int j = 0; j < carsA.length; j++){
                if(carsA[j] == i){
                    sum++; // if car at position j is of type i, add it to the sum.
                }
            }
            cars_per_type.add(sum); // For type i, add the total amount of cars that exist in the parking.
        }


        // For each type of car create a new segment
        // cars_per_type holds the number of cars it is supposed to hold
        // i+1 is the type of the car that it will hold
        for(int i = 0; i < types; i++){
            segments.add(new Segment((cars_per_type.get(i)),(i+1)));
            // The first parameter sets the size of the segment, the second one the type of it.
            // Essentially this "allocates" the number of parking slots that each type is supposed to have.
        }

        // Now, we are going to add the cars that each segment ACTUALLY holds.
        // Remember, previously we just allocated space, in that space, there could be any type of car initially.
        int pointer = 0;
        for(int i = 0; i < segments.size(); i++){
            for(int j = 0; j < segments.get(i).getSize(); j++){
                //System.out.println("POINTER = " + carsA[pointer]);
                segments.get(i).addCar(carsA[pointer]);
                pointer++;
            }
        }

        //Every Segment now is created but we need some extra information for our algorithm.
        //So to make it easier, we create a new object called Segment info that holds 2 integers.
        //One int holds the type and the other the number of types.

        for(int i=0; i < segments.size(); i++){
            segments.get(i).initSegmentInfo(types);
        }
    }


    public void debugger(){
        System.out.println("carsN = " + carsN + " typesN = " + typesN + " workersN = " + workersN);
        System.out.println("");
        for(int i = 0; i < carsA.length; i++){
            System.out.print(carsA[i]);
        }
        System.out.println("");

        for(int i = 0; i < cars_per_type.size(); i++){
            System.out.println("Type : " +  (i+1) + " " + cars_per_type.get(i));
        }

        System.out.println("");

        for(int i = 0; i < segments.size(); i++){
            System.out.println("============================================");
            System.out.println("Segment label : " + segments.get(i).getLabel() + " cars: " + segments.get(i).getSize());
            segments.get(i).printCarInfo();
            segments.get(i).areCarsCorrect();
            System.out.println("Correct cars: " + segments.get(i).getCorrectCars());
            System.out.println("Wrong cars: " + segments.get(i).getWrongCars());
            System.out.println("============================================");
        }
    }

}

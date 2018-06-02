package cars;

import java.util.ArrayList;

public class Segment {

    private int size; // How many cars it holds
    private int label; // What type of cars it should holdv
    private ArrayList<Integer> cars; // What cars it actually holds;
    private int correct_cars;
    private int wrong_cars;
    private ArrayList<SegmentInfo> info;

    /**
     * Constructor
     * @param size The amount of cars that this segment holds.
     * @param label The id of the segment, that the amount of x type cars that it should hold.
     */
    public Segment(int size, int label){
        this.size = size;
        this.label = label;
        this.cars = new ArrayList<Integer>();
     //   initSegmentInfo();
    }

    /**
     * Adds a car to the list
     * @param n the car's type
     */
    public void addCar(int n){
        cars.add(n);
    }

    /**
     * Create an arraylist that holds information about how many cars of each type are contained
     * inside this segment
     *
     * @param types The total number of types that we got.
     */

    public void initSegmentInfo(int types){

        this.info = new ArrayList<SegmentInfo>();


    }

    /**
     * Check how many cars are correct in the segment
     * and how many are not
     */
    public void areCarsCorrect(){
        this.correct_cars = 0;
        this.wrong_cars = 0;
        for(int i = 0; i < getSize(); i++){
            if(cars.get(i) == label) correct_cars++;
            if(cars.get(i) != label) wrong_cars++;
        }
    }

    /**
     * Get how many cars are correctly placed in the segment
     * @return the number of correct cars
     */
    public int getCorrectCars(){
        areCarsCorrect();
        return this.correct_cars;
    }

    /**
     * Get how many cars are wrongly placed in the segment
     * @return the number of wrong cars
     */
    public int getWrongCars(){
        areCarsCorrect();
        return this.wrong_cars;
    }

    /**
     * Return the size of the segment
     * @return The size of the segment
     */
    public int getSize(){
        return this.size;
    }

    /**
     * Returns the label of the segment
     * That is, what types of car this segment should hold
     * @return The type of cars this segment should hold
     */
    public int getLabel(){
        return this.label;
    }

    /**
     * Debugging method
     * Prints the cars contained in the segment
     *
     * TODO:
     *
     * Fix the SegmentInfo part
     */
    public void printCarInfo(){
        System.out.println("\n Cars : ");
        for(int i = 0; i < getSize(); i++){
            System.out.print("  " + cars.get(i));
        }
        System.out.println("");

        System.out.println("Types in segment " + this.getLabel());
     //   for(int i = 0; i < info.size(); i++){
     //       System.out.println(info.get(i).getType());
     //       System.out.println("SIZE : " + info.get(i).getSize());
     //   }


    }
}

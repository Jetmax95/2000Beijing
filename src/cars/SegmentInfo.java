package cars;

public class SegmentInfo {

    private int type;
    private int size;


    /**
     * This class is essentially a car info class.
     * get the amount of cars (size) of type (type) cars in a segment
     * @param type The type
     * @param size The amount of cars of that type
     */
    public SegmentInfo(int type, int size){
        this.type = type;
        this.size = size;
    }

    public void setType(int type){
        this.type = type;
    }

    public void setSize(int size){
        this.size = size;
    }

    public int getType(){
        return this.type;
    }

    public int getSize(){
        return this.size;
    }

}

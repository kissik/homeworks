package ua.org.training.model;

public class Dimensions {

    public final int PRIME_NUMBER = 31;
    public final int STRING_BUFFER_SIZE = 20;
    public final String DIMENSION_STRING_DELIMITER = " * ";

    private int width;
    private int height;
    private int depth;

    public Dimensions(){
        width = 0;
        height = 0;
        depth = 0;
    }

    public Dimensions(int width, int height, int depth){
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public int getWidth() {
        return width;
    }

    public Dimensions setWidth(int width) {
        this.width = width;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public Dimensions setHeight(int height) {
        this.height = height;
        return this;
    }

    public int getDepth() {
        return depth;
    }

    public Dimensions setDepth(int depth) {
        this.depth = depth;
        return this;
    }

    @Override
    public int hashCode(){
        return (width * PRIME_NUMBER + height) * PRIME_NUMBER + depth;
    }

    @Override
    public String toString(){
        StringBuffer stringBuffer = new StringBuffer(STRING_BUFFER_SIZE);
        return stringBuffer
                .append(width)
                .append(DIMENSION_STRING_DELIMITER)
                .append(height)
                .append(DIMENSION_STRING_DELIMITER)
                .append(depth)
                .toString();
    }
}

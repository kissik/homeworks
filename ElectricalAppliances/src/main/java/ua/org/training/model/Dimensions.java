package ua.org.training.model;

import ua.org.training.view.GlobalConstants;

public class Dimensions {

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
        return (width * GlobalConstants.PRIME_NUMBER + height) * GlobalConstants.PRIME_NUMBER + depth;
    }

    @Override
    public String toString(){
        StringBuffer stringBuffer = new StringBuffer(GlobalConstants.STRING_BUFFER_SIZE);
        return stringBuffer
                .append(width)
                .append(GlobalConstants.DIMENSION_STRING_DELIMITER)
                .append(height)
                .append(GlobalConstants.DIMENSION_STRING_DELIMITER)
                .append(depth)
                .toString();
    }
}

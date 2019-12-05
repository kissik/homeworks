package ua.org.training.model;

import ua.org.training.view.GlobalConstants;

/**
 * Dimensions is the class of such dimensions as width, height and depth of a thing
 * @author      <a href="mailto:iryna.v.afanasieva@gmail.com">Ira Afanasieva</a>
 * @version     1.0, 12/4/2019
 */
public class Dimensions {

    private int width;
    private int height;
    private int depth;

    /**
     * Dimensions default constructor
     * with default values:
     * the width field is   DIMENSION_SIZE_DEFAULT_VALUE
     * the height field is  DIMENSION_SIZE_DEFAULT_VALUE
     * the depth field is   DIMENSION_SIZE_DEFAULT_VALUE
     * Please see the {@link ua.org.training.view.GlobalConstants} interface for values
     */
    public Dimensions(){
        width = GlobalConstants.DIMENSION_SIZE_DEFAULT_VALUE;
        height = GlobalConstants.DIMENSION_SIZE_DEFAULT_VALUE;
        depth = GlobalConstants.DIMENSION_SIZE_DEFAULT_VALUE;
    }

    /**
     * Dimensions constructor with parameters
     * @param width     integer value of the width in the centimeters
     * @param height    integer value of the height in the centimeters
     * @param depth     integer value of the depth in the centimeters
     */
    public Dimensions(int width, int height, int depth){
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    /**
     * The width field getter method
     * @return integer value of the width in the centimeters
     */
    public int getWidth() {
        return width;
    }

    /**
     * The width field setter method
     * @param width     integer value of the width in the centimeters
     * @return          reference to the current Dimensions object
     */
    public Dimensions setWidth(int width) {
        this.width = width;
        return this;
    }

    /**
     * The height field getter method
     * @return          integer value of the height in the centimeters
     */
    public int getHeight() {
        return height;
    }

    /**
     * The height field setter method
     * @param height    integer value of the height in the centimeters
     * @return          reference to the current Dimensions object
     */
    public Dimensions setHeight(int height) {
        this.height = height;
        return this;
    }

    /**
     * The depth field getter method
     * @return          integer value of the depth in the centimeters
     */
    public int getDepth() {
        return depth;
    }

    /**
     * The depth field setter method
     * @param depth     integer value of the depth in the centimeters
     * @return          reference to the current Dimensions object
     */
    public Dimensions setDepth(int depth) {
        this.depth = depth;
        return this;
    }

    /**
     * <p>The overridden method of hash code computation.
     * The formula for computation is:</p>
     * <code>(width * PRIME_NUMBER + height) * PRIME_NUMBER + depth,</code>
     * <p>where:</p>
     * <ul>
     * <li>width, height, depth are fields of the current Dimensions object</li>
     * <li>PRIME_NUMBER is constant.
     * Please see the {@link ua.org.training.view.GlobalConstants} interface for values</li>
     * </ul>
     * @return          integer value of hash code;
     */
    @Override
    public int hashCode(){
        return (width * GlobalConstants.PRIME_NUMBER + height) * GlobalConstants.PRIME_NUMBER + depth;
    }

    /**
     * <p>The overridden method for representing dimensions information as a string</p>
     * @return          String value of dimensions information in human readable format
     */
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

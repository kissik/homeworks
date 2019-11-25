package ua.org.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.org.training.Model;
import ua.org.training.View;

public class TestModel {
    public static final int REPEAT_GET_RANDOM = 10000;
    private static Model m;

    @BeforeClass
    public static void testInit(){
        m = new Model(View.LEFT_BORDER, View.RIGHT_BORDER);
    }

    @Test
    public void testGetRandom(){
        for(int i = 0; i < REPEAT_GET_RANDOM; i++){
            Assert.assertTrue((m.getLeftBorder() < m.getNumber()) && (m.getNumber() < m.getRightBorder()));
            m.setNumber();
        }
    }

    @Test
    public void testWin(){
        int value = m.getNumber();
        Assert.assertTrue(m.guessNumber(value));
    }

    @Test
    public void testLeftBorderInvalid(){
        int value = m.getLeftBorder() - 1;
        m.guessNumber(value);
        Assert.assertFalse(value == m.getLeftBorder());
    }

    @Test
    public void testRightBorderInvalid(){
        int value = m.getRightBorder() + 1;
        m.guessNumber(value);
        Assert.assertFalse(value == m.getRightBorder());
    }

    @Test
    public void testLeftBorderValid(){
        int value = m.getLeftBorder() + 1;
        m.guessNumber(value);
        Assert.assertTrue(value == m.getLeftBorder());
    }

    @Test
    public void testRightBorderValid(){
        int value = m.getRightBorder() - 1;
        m.guessNumber(value);
        Assert.assertTrue(value == m.getRightBorder());
    }

}

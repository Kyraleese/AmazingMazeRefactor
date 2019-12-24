import org.junit.Test;

import static org.junit.Assert.*;
import java.util.Random;

public class AmazingTest  {

    @Test
    public void testSeed0size15x20() {
        String expected =
                "Amazing - Copyright by Creative Computing, Morristown, NJ\n" +
                        "+--+--+--+--+--+--+--+--+--+--+  +--+--+--+--+\n" +
                        "|  |           |        |     |     |        | \n" +
                        "+  +  +  +  +  +  +--+  +  +  +  +--+  +--+  +\n" +
                        "|     |  |  |  |     |     |     |     |  |  | \n" +
                        "+--+--+  +  +--+  +  +--+--+--+--+  +  +  +  +\n" +
                        "|     |  |        |  |              |  |     | \n" +
                        "+  +  +  +--+--+--+  +  +  +--+--+--+--+--+--+\n" +
                        "|  |     |        |     |  |     |        |  | \n" +
                        "+--+--+  +--+  +--+  +--+  +  +  +  +--+  +  +\n" +
                        "|     |        |        |  |  |     |     |  | \n" +
                        "+  +  +--+--+--+  +--+  +  +  +--+--+  +--+  +\n" +
                        "|  |              |     |  |  |     |  |     | \n" +
                        "+  +--+--+--+--+--+--+  +  +  +  +--+  +--+  +\n" +
                        "|        |           |  |  |  |     |  |     | \n" +
                        "+  +--+  +--+  +  +  +  +  +  +--+  +  +  +--+\n" +
                        "|  |     |     |  |  |  |  |     |  |  |  |  | \n" +
                        "+  +  +--+  +--+  +  +  +  +--+  +  +  +  +  +\n" +
                        "|  |        |     |  |  |        |  |  |  |  | \n" +
                        "+  +--+  +--+  +--+  +  +--+--+--+  +  +  +  +\n" +
                        "|     |     |  |  |  |  |     |        |     | \n" +
                        "+--+  +--+  +  +  +  +--+  +  +  +--+--+  +--+\n" +
                        "|  |     |  |     |     |  |  |     |  |     | \n" +
                        "+  +--+  +--+--+--+  +  +  +  +--+  +  +  +  +\n" +
                        "|     |     |     |  |  |  |     |  |  |  |  | \n" +
                        "+  +  +--+  +  +  +--+  +  +--+  +  +  +  +  +\n" +
                        "|  |        |  |     |  |     |     |  |  |  | \n" +
                        "+  +--+--+  +--+  +  +  +--+  +--+--+  +  +--+\n" +
                        "|  |     |        |  |     |     |     |     | \n" +
                        "+  +  +--+--+--+--+  +  +--+  +  +  +--+--+  +\n" +
                        "|     |           |  |     |  |  |  |     |  | \n" +
                        "+  +--+  +--+--+--+  +--+  +  +  +  +  +  +  +\n" +
                        "|  |                 |     |  |  |     |  |  | \n" +
                        "+  +  +--+--+--+--+--+  +--+  +--+  +--+  +  +\n" +
                        "|  |  |  |           |     |     |  |     |  | \n" +
                        "+  +  +  +  +--+  +  +--+  +--+  +  +  +--+  +\n" +
                        "|  |  |     |     |  |  |     |     |  |     | \n" +
                        "+--+  +--+--+  +  +  +  +  +  +--+--+  +--+  +\n" +
                        "|     |        |  |  |  |  |  |     |        | \n" +
                        "+  +--+  +--+--+  +  +  +  +  +--+  +  +--+--+\n" +
                        "|        |        |     |  |        |        | \n" +
                        "+--+--+--+--+--+--+--+--+  +--+--+--+--+--+--+\n";

        MazeGenerator.random = new Random(0);
        Amazing.doit(15, 20);

        assertEquals("Should have the maze that was expected", expected, Amazing.result.toString());
    }

    @Test
    public void testSeed100size4x5() {
        String expected =
                "Amazing - Copyright by Creative Computing, Morristown, NJ\n" +
                        "+--+--+  +--+\n" +
                        "|     |     | \n" +
                        "+  +--+  +  +\n" +
                        "|  |     |  | \n" +
                        "+  +  +--+  +\n" +
                        "|  |  |     | \n" +
                        "+  +  +  +  +\n" +
                        "|  |  |  |  | \n" +
                        "+  +--+  +  +\n" +
                        "|  |  |  |  | \n" +
                        "+--+--+  +--+\n";

        MazeGenerator.random = new Random(100);
        Amazing.doit(4, 5);
        assertEquals("Should have the maze that was expected", expected, Amazing.result.toString());

    }

    @Test
    public void testSeed100size1x1() {
        String expected = "Amazing - Copyright by Creative Computing, Morristown, NJ\n";

        MazeGenerator.random = new Random(100);
        Amazing.doit(1, 1);
        assertEquals("Should have the maze that was expected", expected, Amazing.result.toString());
    }

    @Test
    public void testSeed100size2x2() {
        String expected = "Amazing - Copyright by Creative Computing, Morristown, NJ\n" +
                "+--+  +\n" +
                "|     | \n" +
                "+--+  +\n" +
                "|     | \n" +
                "+  +--+\n";

        MazeGenerator.random = new Random(100);
        Amazing.doit(2, 2);
        assertEquals("Should have the maze that was expected", expected, Amazing.result.toString());
    }

    @Test
    public void testSeed0size2x2() {
        String expected = "Amazing - Copyright by Creative Computing, Morristown, NJ\n" +
                "+--+  +\n" +
                "|  |  | \n" +
                "+  +--+\n" +
                "|  |  | \n" +
                "+--+--+\n";

        MazeGenerator.random = new Random(10);
        Amazing.doit(2, 2);
        assertEquals("Should have the maze that was expected", expected, Amazing.result.toString());
    }
}
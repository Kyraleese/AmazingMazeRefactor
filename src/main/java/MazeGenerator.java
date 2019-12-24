import java.util.Random;

public class MazeGenerator {
    public static Random random = new Random(0);

    private static int x;
    private static int mazeWidth;
    private static int mazeHeight;
    private static int q;
    private static int z;
    private static int row;
    private static int column;
    private static int c;
    private static int[][] visitedCells;
    private static int[][] mazeGrid;

    public static int[][] getVisitedCells() {
        return visitedCells;
    }

    public static int[][] getMazeGrid() {
        return mazeGrid;
    }

    public MazeGenerator(int[][] mazeCells, int[][] mazeVisitedCells) {
        mazeHeight = mazeCells[0].length - 1;
        mazeWidth = mazeCells.length - 1;
        visitedCells = mazeVisitedCells;
        mazeGrid = mazeCells;

        q = 0;
        z = 0;
        int startingColumn = rnd(mazeWidth);

        c = 1;
        visitedCells[startingColumn][1] = c;
        c++;

        column = startingColumn;
        row = 1;
    }

    private static int rnd(int count) {
        return (int) (count * random.nextFloat()) + 1;
    }

    public static void generate() {
        case270();
    }

    private static void case1180() {
        mazeGrid[column][row] = 1;
        q = 0;
        moveToUpperLeftCornerOfMaze();
    }

    private static void case1170() {
        mazeGrid[column][row] = 3;
        q = 0;
        case210();
    }

    private static void case1160() {
        if (mazeGrid[column][row] == 0)
            case1180();
        else
            case1170();
    }

    private static void case1150() {
        z = 1;
        case1160();
    }

    private static void case1130() {
        row++;
        if (c < mazeHeight * mazeWidth + 1)
            case270();
    }

    private static void case1120() {
        mazeGrid[column][row] = 1;
        case1130();
    }

    private static void case1110() {
        mazeGrid[column][row] = 3;
        case1130();
    }

    private static void case1100() {
        visitedCells[column][row + 1] = c;
        c++;
        if (mazeGrid[column][row] == 0)
            case1120();
        else
            case1110();
    }

    private static void case1090() {
        if (q == 1)
            case1150();
        else
            case1100();
    }

    private static void case1070() {
        if (c < mazeWidth * mazeHeight + 1) {
            case600();
        }
    }

    private static void case1060() {
        column++;
        case1070();
    }

    private static void case1050() {
        mazeGrid[column][row] = 2;
        case1060();
    }

    private static void case1040() {
        mazeGrid[column][row] = 3;
        case1060();
    }

    private static void case1030() {
        c++;
        if (mazeGrid[column][row] == 0)
            case1050();
        else
            case1040();
    }

    private static void case1020() {
        visitedCells[column + 1][row] = c;
        case1030();
    }

    private static void case1000() {
        mazeGrid[column][row - 1] = 1;
        row--;
        case960();
    }

    private static void case990() {
        c++;
        case1000();
    }

    private static void case980() {
        visitedCells[column][row - 1] = c;
        case990();
    }

    private static void case1010() {
        q = 0;
        case270();
    }

    private static void case960() {
        if (c < mazeWidth * mazeHeight + 1)
            case1010();
    }

    private static void case950() {
        c++;
        mazeGrid[column - 1][row] = 2;
        column--;
        case960();
    }

    private static void case940() {
        visitedCells[column - 1][row] = c;
        case950();
    }

    private static void case910() {
        if (visitedCells[column][row + 1] != 0)
            case210();
        else
            case1090();
    }

    private static void case900() {
        q = 1;
        case1090();
    }

    private static void case890() {
        if (z == 1)
            case210();
        else
            case900();
    }

    private static void case880() {
        if (row != mazeHeight)
            case910();
        else
            case890();
    }

    private static void case860() {
        if (x == 1)
            case1020();
        else if (x == 2)
            case1090();
        else
            case1020();
    }

    private static void case850() {
        x = rnd(2);
        case860();
    }

    private static void case840() {
        if (visitedCells[column][row + 1] != 0)
            case1020();
        else
            case850();
    }

    private static void case830() {
        q = 1;
        case990();
    }

    private static void case820() {
        if (z == 1)
            case1020();
        else
            case830();
    }

    private static void case810() {
        if (row != mazeHeight)
            case840();
        else
            case820();
    }

    private static void case800() {
        if (visitedCells[column + 1][row] != 0)
            case880();
        else
            case810();
    }

    private static void case790() {
        if (column == mazeWidth)
            case880();
        else
            case800();
    }

    private static void case770() {
        if (x == 1)
            case980();
        else if (x == 2)
            case1090();
        else
            case980();
    }

    private static void case760() {
        x = rnd(2);
        case770();
    }

    private static void case750() {
        if (visitedCells[column][row + 1] != 0)
            case980();
        else
            case760();
    }

    private static void case740() {
        q = 1;
        case760();
    }

    private static void case730() {
        if (z == 1)
            case980();
        else
            case740();
    }

    private static void case720() {
        if (row != mazeHeight)
            case750();
        else
            case730();
    }

    private static void case710() {
        if (x == 1)
            case980();
        else if (x == 2)
            case1020();
        else
            case720();
    }

    private static void case700() {
        x = rnd(2);
        case710();
    }

    private static void case690() {
        if (x == 1)
            case980();
        else if (x == 2)
            case1020();
        else if (x == 3)
            case1090();
        else
            case700();
    }

    private static void case680() {
        x = rnd(3);
        case690();
    }

    private static void case670() {
        if (visitedCells[column][row + 1] != 0)
            case700();
        else
            case680();
    }

    private static void case660() {
        q = 1;
        case680();
    }

    private static void case650() {
        if (z == 1)
            case700();
        else
            case660();
    }

    private static void case640() {
        if (row != mazeHeight)
            case670();
        else
            case650();
    }

    private static void case630() {
        if (visitedCells[column + 1][row] != 0)
            case720();
        else
            case640();
    }

    private static void case620() {
        if (column == mazeWidth)
            case720();
        else
            case630();
    }

    private static void case610() {
        if (visitedCells[column][row - 1] != 0)
            case790();
        else
            case620();
    }

    private static void case600() {
        if (row - 1 == 0)
            case790();
        else
            case610();
    }

    private static void case580() {
        if (x == 1)
            case940();
        else if (x == 2)
            case1090();
        else
            case940();
    }

    private static void case570() {
        x = rnd(2);
        case580();
    }

    private static void case560() {
        if (visitedCells[column][row + 1] != 0)
            case940();
        else
            case570();
    }

    private static void case550() {
        q = 1;
        case570();
    }

    private static void case540() {
        if (z == 1)
            case940();
        else
            case550();
    }

    private static void case530() {
        if (row != mazeHeight)
            case560();
        else
            case540();
    }

    private static void case520() {
        if (x == 1)
            case940();
        else if (x == 2)
            case1020();
        else
            case530();
    }

    private static void case510() {
        x = rnd(2);
        case520();
    }

    private static void case500() {
        if (x == 1)
            case940();
        else if (x == 2)
            case1020();
        else if (x == 3)
            case1090();
        else
            case510();
    }

    private static void case490() {
        x = rnd(3);
        case500();
    }

    private static void case480() {
        if (visitedCells[column][row + 1] != 0)
            case510();
        else
            case490();
    }

    private static void case470() {
        q = 1;
        case490();
    }

    private static void case460() {
        if (z == 1)
            case510();
        else
            case470();
    }

    private static void case450() {
        if (row != mazeHeight)
            case480();
        else
            case460();
    }

    private static void case440() {
        if (visitedCells[column + 1][row] != 0)
            case530();
        else
            case450();
    }

    private static void case430() {
        if (column == mazeWidth)
            case530();
        else
            case440();
    }

    private static void case420() {
        if (x == 1)
            case940();
        else if (x == 2)
            case980();
        else
            case430();
    }

    private static void case410() {
        x = rnd(2);
        case420();
    }

    private static void case400() {
        if (x == 1)
            case940();
        else if (x == 2)
            case980();
        else if (x == 3)
            case1090();
        else
            case410();
    }

    private static void case390() {
        x = rnd(3);
        case400();
    }

    private static void case380() {
        if (visitedCells[column][row + 1] != 0)
            case410();
        else
            case390();
    }

    private static void case370() {
        q = 1;
        case390();
    }

    private static void case360() {
        if (z == 1)
            case410();
        else
            case370();
    }

    private static void case350() {
        if (row != mazeHeight)
            case380();
        else
            case360();
    }

    private static void case340() {
        if (x == 1)
            case940();
        else if (x == 2)
            case980();
        else if (x == 3)
            case1020();
        else
            case350();
    }

    private static void case330() {
        x = rnd(3);
        case340();
    }

    private static void case320() {
        if (visitedCells[column + 1][row] != 0)
            case350();
        else
            case330();
    }

    private static void case310() {
        if (column == mazeWidth)
            case350();
        else
            case320();
    }

    private static void case300() {
        if (visitedCells[column][row - 1] != 0)
            case430();
        else
            case310();
    }

    private static void case290() {
        if (row - 1 == 0)
            case430();
        else
            case300();
    }

    private static void case280() {
        if (visitedCells[column - 1][row] != 0)
            case600();
        else
            case290();
    }

    private static void case270() {
        if (column - 1 == 0)
            case600();
        else
            case280();
    }

    private static void case260() {
        if (visitedCells[column][row] == 0)
            case210();
        else
            case270();
    }

    private static void case250() {
        column++;
        case260();
    }

    private static void case240() {
        column = 1;
        row++;
        case260();
    }

    private static void moveToUpperLeftCornerOfMaze() {
        column = 1;
        row = 1;
        case260();
    }

    private static void case220() {
        if (row != mazeHeight)
            case240();
        else
            moveToUpperLeftCornerOfMaze();
    }

    private static void case210() {
        if (column != mazeWidth)
            case250();
        else
            case220();
    }

}

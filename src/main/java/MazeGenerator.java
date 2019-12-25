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

    private static int RIGHT_BOTTOM_CORNER = 0;
    private static int RIGHT_WALL = 1;
    private static int BOTTOM_WALL = 2;
    private static int NO_WALLS = 3;

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
        beginProcessing();
    }

    private static void case1090() {
        if (q == 1) {
            z = 1;
            q = 0;

            if (mazeGrid[column][row] == RIGHT_BOTTOM_CORNER) {
                setCellToRightWall();
                moveToUpperLeftCornerOfMaze();
                if (currentCellUnchecked())
                    moveToNextCell();
                else
                    beginProcessing();
            }
            else {
                setCellToNoWalls();
                moveToNextCell();
            }
        }
        else {
            visitedCells[column][row + 1] = c;
            c++;
            if (mazeGrid[column][row] == RIGHT_BOTTOM_CORNER) {
                setCellToRightWall();
            }
            else {
                setCellToNoWalls();
            }

            moveDownARow();
            beginProcessingIfNotAllCellsVisited();
        }
    }

    private static void case1020() {
        if (mazeGrid[column][row] == RIGHT_BOTTOM_CORNER)
            setCellToBottomWall();
        else {
            setCellToNoWalls();
        }

        moveToNextColumnOfMaze();
        setCellAsVisited();
        continueIfNotAllCellsVisited();
    }

    private static void case990() {
        c++;
        moveUpARow();
        setCellToRightWall();
        case960();
    }

    private static void case960() {
        if (unvisitedCellsRemain()) {
            q = 0;
            beginProcessing();
        }
    }

    private static void case910() {
        if (cellBelowUsAlreadyChecked())
            moveToNextCell();
        else
            case1090();
    }

    private static void case900() {
        q = 1;
        case1090();
    }

    private static void case890() {
        if (z == 1)
            moveToNextCell();
        else
            case900();
    }

    private static void case880() {
        if (!isLastRow())
            case910();
        else
            case890();
    }

    private static void case850() {
        x = rnd(2);
        if (x == 1)
            case1020();
        else if (x == 2)
            case1090();
    }

    private static void case840() {
        if (cellBelowUsAlreadyChecked())
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
        if (!isLastRow())
            case840();
        else
            case820();
    }

    private static void case800() {
        if (cellToOurRightAlreadyChecked())
            case880();
        else
            case810();
    }

    private static void case790() {
        if (isLastColumn())
            case880();
        else
            case800();
    }

    private static void case760() {
        x = rnd(2);
        if (x == 1) {
            setCellAboveAsRightWall();
            case960();
        }
        else if (x == 2)
            case1090();
    }

    private static void case750() {
        if (cellBelowUsAlreadyChecked()) {
            setCellAboveAsRightWall();
            case960();
        }
        else
            case760();
    }

    private static void case740() {
        q = 1;
        case760();
    }

    private static void case730() {
        if (z == 1) {
            setCellAboveAsRightWall();
            case960();
        }
        else
            case740();
    }

    private static void case720() {
        if (!isLastRow())
            case750();
        else
            case730();
    }

    private static void case700() {
        x = rnd(2);
        if (x == 1) {
            setCellAboveAsRightWall();
            case960();
        }
        else if (x == 2)
            case1020();
    }

    private static void case680() {
        x = rnd(3);
        if (x == 1) {
            setCellAboveAsRightWall();
            case960();
        }
        else if (x == 2)
            case1020();
        else if (x == 3)
            case1090();
    }

    private static void case670() {
        if (cellBelowUsAlreadyChecked())
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
        if (!isLastRow())
            case670();
        else
            case650();
    }

    private static void case630() {
        if (cellToOurRightAlreadyChecked())
            case720();
        else
            case640();
    }

    private static void case620() {
        if (isLastColumn())
            case720();
        else
            case630();
    }

    private static void case610() {
        if (cellAboveUsAlreadyChecked())
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

    private static void case570() {
        x = rnd(2);
        if (x == 1) {
            setCellToLeftAsBottomWall();
            case960();
        }
        else if (x == 2)
            case1090();
    }

    private static void case560() {
        if (cellBelowUsAlreadyChecked()) {
            setCellToLeftAsBottomWall();
            case960();
        }
        else
            case570();
    }

    private static void case550() {
        q = 1;
        case570();
    }

    private static void case540() {
        if (z == 1) {
            setCellToLeftAsBottomWall();
            case960();
        }
        else
            case550();
    }

    private static void case530() {
        if (!isLastRow())
            case560();
        else
            case540();
    }

    private static void case510() {
        x = rnd(2);
        if (x == 1) {
            setCellToLeftAsBottomWall();
            case960();
        }
        else if (x == 2)
            case1020();
    }

    private static void case490() {
        x = rnd(3);
        if (x == 1) {
            setCellToLeftAsBottomWall();
            case960();
        }
        else if (x == 2)
            case1020();
        else if (x == 3)
            case1090();
    }

    private static void case480() {
        if (cellBelowUsAlreadyChecked())
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
        if (!isLastRow())
            case480();
        else
            case460();
    }

    private static void case440() {
        if (cellToOurRightAlreadyChecked())
            case530();
        else
            case450();
    }

    private static void case430() {
        if (isLastColumn())
            case530();
        else
            case440();
    }

    private static void case410() {
        x = rnd(2);

        if (x == 1) {
            setCellToLeftAsBottomWall();
            case960();
        }
        else if (x == 2) {
            setCellAboveAsRightWall();
            case960();
        }
    }

    private static void case390() {
        x = rnd(3);
        if (x == 1) {
            setCellToLeftAsBottomWall();
            case960();
        }
        else if (x == 2) {
            setCellAboveAsRightWall();
            case960();
        }
        else if (x == 3)
            case1090();
    }

    private static void case380() {
        if (cellBelowUsAlreadyChecked())
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
        if (!isLastRow())
            case380();
        else
            case360();
    }

    private static void case330() {
        x = rnd(3);
        if (x == 1) {
            setCellToLeftAsBottomWall();
            case960();
        }
        else if (x == 2) {
            setCellAboveAsRightWall();
            case960();
        }
        else if (x == 3)
            case1020();
    }

    private static void case320() {
        if (cellToOurRightAlreadyChecked())
            case350();
        else
            case330();
    }

    private static void case310() {
        if (isLastColumn())
            case350();
        else
            case320();
    }

    private static void case300() {
        if (cellAboveUsAlreadyChecked())
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
        if (cellToLeftOfUsAlreadyChecked())
            case600();
        else
            case290();
    }

    private static void beginProcessing() {
        if (column - 1 == 0)
            case600();
        else
            case280();
    }

    private static void moveToNextCell() {
        if (!isLastColumn()) {
            moveToNextColumnOfMaze();
        }
        else if (!isLastRow()) {
            moveToNextRowOfMaze();
        }
        else {
            moveToUpperLeftCornerOfMaze();
        }

        if (currentCellUnchecked())
            moveToNextCell();
        else
            beginProcessing();
    }

    private static boolean isLastColumn() {
        return column == mazeWidth;
    }

    private static boolean isLastRow() {
        return row == mazeHeight;
    }

    private static void moveToNextColumnOfMaze() {
        column++;
    }

    private static void moveToPreviousColumnOfMaze() {
        column--;
    }

    private static void moveToNextRowOfMaze() {
        column = 1;
        row++;
    }

    private static void moveUpARow() {
        row--;
    }

    private static void moveDownARow() {
        row++;
    }

    private static void moveToUpperLeftCornerOfMaze() {
        column = 1;
        row = 1;
    }

    private static boolean currentCellUnchecked() {
        return visitedCells[column][row] == 0;
    }

    private static boolean cellToLeftOfUsAlreadyChecked() {
        return visitedCells[column - 1][row] != 0;
    }

    private static boolean cellAboveUsAlreadyChecked() {
        return visitedCells[column][row - 1] != 0;
    }

    private static boolean cellBelowUsAlreadyChecked() {
        return visitedCells[column][row + 1] != 0;
    }

    private static boolean cellToOurRightAlreadyChecked() {
        return visitedCells[column + 1][row] != 0;
    }

    private static void setCellAsVisited() {
        visitedCells[column][row] = c;
        c++;
    }

    private static void setCellToBottomWall() {
        mazeGrid[column][row] = BOTTOM_WALL;
    }

    private static void setCellToRightWall() {
        mazeGrid[column][row] = RIGHT_WALL;
    }

    private static void setCellToNoWalls() {
        mazeGrid[column][row] = NO_WALLS;
    }

    private static boolean unvisitedCellsRemain() {
        return c < mazeWidth * mazeHeight + 1;
    }

    private static void continueIfNotAllCellsVisited() {
        if (unvisitedCellsRemain())
            case600();
    }

    private static void beginProcessingIfNotAllCellsVisited() {
        if (unvisitedCellsRemain())
            beginProcessing();
    }

    private static void setCellToLeftAsBottomWall() {
        moveToPreviousColumnOfMaze();
        setCellToBottomWall();
        setCellAsVisited();
    }

    private static void setCellAboveAsRightWall() {
        moveUpARow();
        setCellToRightWall();
        setCellAsVisited();
    }
}

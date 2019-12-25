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

    static int[][] getVisitedCells() {
        return visitedCells;
    }

    static int[][] getMazeGrid() {
        return mazeGrid;
    }

    MazeGenerator(int[][] mazeCells, int[][] mazeVisitedCells) {
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

    static void generate() {
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

    private static void case760() {
        x = rnd(2);
        if (x == 1) {
            setCellAboveAsRightWall();
            beginProcessingAndSetQToZeroIfNotAllCellsVisited();
        }
        else if (x == 2)
            case1090();
    }

    private static void case700() {
        x = rnd(2);
        if (x == 1) {
            setCellAboveAsRightWall();
            beginProcessingAndSetQToZeroIfNotAllCellsVisited();
        }
        else if (x == 2)
            case1020();
    }

    private static void case680() {
        x = rnd(3);
        if (x == 1) {
            setCellAboveAsRightWall();
            beginProcessingAndSetQToZeroIfNotAllCellsVisited();
        }
        else if (x == 2)
            case1020();
        else if (x == 3)
            case1090();
    }

    private static void case600() {
        if (cannotProcessCellAboveUs() && cannotProcessCellToOurRight() && isNotLastRow() && cellBelowUsAlreadyChecked())
            moveToNextCell();
        else if (cannotProcessCellAboveUs() && cannotProcessCellToOurRight() && isNotLastRow())
            case1090();
        else if (cannotProcessCellAboveUs() && cannotProcessCellToOurRight() && z == 1)
            moveToNextCell();
        else if (cannotProcessCellAboveUs() && cannotProcessCellToOurRight()){
            q = 1;
            case1090();
        }
        else if (cannotProcessCellAboveUs() && isNotLastRow() && cellBelowUsAlreadyChecked())
            case1020();
        else if (cannotProcessCellAboveUs() && isNotLastRow()) {
            x = rnd(2);
            if (x == 1)
                case1020();
            else if (x == 2)
                case1090();
        }
        else if (cannotProcessCellAboveUs() && z == 1)
            case1020();
        else if (cannotProcessCellAboveUs()){
            q = 1;
            c++;
            moveUpARow();
            setCellToRightWall();
            beginProcessingAndSetQToZeroIfNotAllCellsVisited();
        }
        else if (cannotProcessCellToOurRight() && isNotLastRow() && cellBelowUsAlreadyChecked()) {
            setCellAboveAsRightWall();
            beginProcessingAndSetQToZeroIfNotAllCellsVisited();
        }
        else if (cannotProcessCellToOurRight() && isNotLastRow())
            case760();
        else if (cannotProcessCellToOurRight() && z == 1) {
            setCellAboveAsRightWall();
            beginProcessingAndSetQToZeroIfNotAllCellsVisited();
        }
        else if (cannotProcessCellToOurRight()){
            q = 1;
            case760();
        }
        else if (isNotLastRow() && cellBelowUsAlreadyChecked())
            case700();
        else if (isNotLastRow())
            case680();
        else if (z == 1)
            case700();
        else {
            q = 1;
            case680();
        }
    }

    private static void case570() {
        x = rnd(2);
        if (x == 1) {
            setCellToLeftAsBottomWall();
            beginProcessingAndSetQToZeroIfNotAllCellsVisited();
        }
        else if (x == 2)
            case1090();
    }

    private static void case510() {
        x = rnd(2);
        if (x == 1) {
            setCellToLeftAsBottomWall();
            beginProcessingAndSetQToZeroIfNotAllCellsVisited();
        }
        else if (x == 2)
            case1020();
    }

    private static void case490() {
        x = rnd(3);
        if (x == 1) {
            setCellToLeftAsBottomWall();
            beginProcessingAndSetQToZeroIfNotAllCellsVisited();
        }
        else if (x == 2)
            case1020();
        else if (x == 3)
            case1090();
    }

    private static void case410() {
        x = rnd(2);

        if (x == 1) {
            setCellToLeftAsBottomWall();
            beginProcessingAndSetQToZeroIfNotAllCellsVisited();
        }
        else if (x == 2) {
            setCellAboveAsRightWall();
            beginProcessingAndSetQToZeroIfNotAllCellsVisited();
        }
    }

    private static void case390() {
        x = rnd(3);
        if (x == 1) {
            setCellToLeftAsBottomWall();
            beginProcessingAndSetQToZeroIfNotAllCellsVisited();
        }
        else if (x == 2) {
            setCellAboveAsRightWall();
            beginProcessingAndSetQToZeroIfNotAllCellsVisited();
        }
        else if (x == 3)
            case1090();
    }

    private static void beginProcessing() {
        if (cannotProcessCellToOurLeft())
            case600();
        else if (cannotProcessCellAboveUs() && cannotProcessCellToOurRight() && isNotLastRow() && cellBelowUsAlreadyChecked()) {
            setCellToLeftAsBottomWall();
            beginProcessingAndSetQToZeroIfNotAllCellsVisited();
        }
        else if (cannotProcessCellAboveUs() && cannotProcessCellToOurRight() && isNotLastRow())
            case570();
        else if (cannotProcessCellAboveUs() && cannotProcessCellToOurRight() && z == 1) {
            setCellToLeftAsBottomWall();
            beginProcessingAndSetQToZeroIfNotAllCellsVisited();
        }
        else if (cannotProcessCellAboveUs() && cannotProcessCellToOurRight()) {
            q = 1;
            case570();
        }
        else if (cannotProcessCellAboveUs() && isNotLastRow() && cellBelowUsAlreadyChecked())
            case510();
        else if (cannotProcessCellAboveUs() && isNotLastRow())
            case490();
        else if (cannotProcessCellAboveUs() && z == 1)
            case510();
        else if (cannotProcessCellAboveUs()) {
            q = 1;
            case490();
        }
        else if (cannotProcessCellToOurRight() && isNotLastRow() && cellBelowUsAlreadyChecked())
            case410();
        else if (cannotProcessCellToOurRight() && isNotLastRow())
            case390();
        else if (cannotProcessCellToOurRight() && z == 1)
            case410();
        else if (cannotProcessCellToOurRight()){
            q = 1;
            case390();
        }
        else {
            x = rnd(3);
            if (x == 1) {
                setCellToLeftAsBottomWall();
                beginProcessingAndSetQToZeroIfNotAllCellsVisited();
            }
            else if (x == 2) {
                setCellAboveAsRightWall();
                beginProcessingAndSetQToZeroIfNotAllCellsVisited();
            }
            else if (x == 3)
                case1020();
        }
    }

    private static void moveToNextCell() {
        if (!isLastColumn()) {
            moveToNextColumnOfMaze();
        }
        else if (isNotLastRow()) {
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

    private static boolean isNotLastRow() {
        return row != mazeHeight;
    }

    private static boolean isFirstRow() {
        return row == 1;
    }

    private static boolean isFirstColumn() {
        return column == 1;
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

    private static boolean cannotProcessCellToOurRight() {
        return isLastColumn() || cellToOurRightAlreadyChecked();
    }

    private static boolean cannotProcessCellAboveUs() {
        return isFirstRow() || cellAboveUsAlreadyChecked();
    }

    private static boolean cannotProcessCellToOurLeft() {
        return isFirstColumn() || cellToLeftOfUsAlreadyChecked();
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

    private static void beginProcessingAndSetQToZeroIfNotAllCellsVisited() {
        if (unvisitedCellsRemain()) {
            q = 0;
            beginProcessing();
        }
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

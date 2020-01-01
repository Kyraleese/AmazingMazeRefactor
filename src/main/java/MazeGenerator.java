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
        mazeHeight = mazeCells[0].length - 2;
        mazeWidth = mazeCells.length - 2;
        visitedCells = mazeVisitedCells;
        mazeGrid = mazeCells;

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
        if (isLastRow()) {
            z = 1;

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
        if ((isNotLastRow() || z == 1) && endOfPath())
            moveToNextCell();
        else if (onlyCellBelowUnchecked()) {
            case1090();
        }
        else if ((isNotLastRow() || z == 1) && onlyCellToRightUnchecked())
            case1020();
        else if (cellToLeftOfUsAlreadyChecked() && cellAboveUsAlreadyChecked()  && !cellBelowUsAlreadyChecked() && !cellToRightOfUsAlreadyChecked() && isNotLastRow()) {
            x = rnd(2);
            if (x == 1)
                case1020();
            else if (x == 2)
                case1090();
            }
        else if (onlyCellToRightUnchecked()){
            c++;
            moveUpARow();
            setCellToRightWall();
            beginProcessingAndSetQToZeroIfNotAllCellsVisited();
        }
        else if (onlyCellAboveUnchecked() && isNotLastRow()) {
            setCellAboveAsRightWall();
            beginProcessingAndSetQToZeroIfNotAllCellsVisited();
        }
        else if (cellToLeftOfUsAlreadyChecked() && cellToRightOfUsAlreadyChecked() && isNotLastRow())
            case760();
        else if (cellToLeftOfUsAlreadyChecked() && cellToRightOfUsAlreadyChecked() && z == 1) {
            setCellAboveAsRightWall();
            beginProcessingAndSetQToZeroIfNotAllCellsVisited();
        }
        else if (cellToLeftOfUsAlreadyChecked() && cellToRightOfUsAlreadyChecked()){
            case760();
        }
        else if (cellToLeftOfUsAlreadyChecked() && isNotLastRow() && cellBelowUsAlreadyChecked())
            case700();
        else if (cellToLeftOfUsAlreadyChecked() && isNotLastRow())
            case680();
        else if (cellToLeftOfUsAlreadyChecked() && z == 1)
            case700();
        else if (cellToLeftOfUsAlreadyChecked()){
            case680();
        }
        else if (onlyCellToLeftUnchecked() && isNotLastRow()) {
            setCellToLeftAsBottomWall();
            beginProcessingAndSetQToZeroIfNotAllCellsVisited();
        }
        else if (cellAboveUsAlreadyChecked() && cellToRightOfUsAlreadyChecked() && isNotLastRow())
            case570();
        else if (cellAboveUsAlreadyChecked() && cellToRightOfUsAlreadyChecked() && z == 1) {
            setCellToLeftAsBottomWall();
            beginProcessingAndSetQToZeroIfNotAllCellsVisited();
        }
        else if (cellAboveUsAlreadyChecked() && cellToRightOfUsAlreadyChecked()) {
            case570();
        }
        else if (cellAboveUsAlreadyChecked() && isNotLastRow() && cellBelowUsAlreadyChecked())
            case510();
        else if (cellAboveUsAlreadyChecked() && isNotLastRow())
            case490();
        else if (cellAboveUsAlreadyChecked() && z == 1)
            case510();
        else if (cellAboveUsAlreadyChecked()) {
            case490();
        }
        else if (cellToRightOfUsAlreadyChecked() && isNotLastRow() && cellBelowUsAlreadyChecked())
            case410();
        else if (cellToRightOfUsAlreadyChecked() && isNotLastRow())
            case390();
        else if (cellToRightOfUsAlreadyChecked() && z == 1)
            case410();
        else if (cellToRightOfUsAlreadyChecked()){
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
        return column >= mazeWidth;
    }

    private static boolean isNotLastRow() {
        return row < mazeHeight;
    }

    private static boolean isLastRow() {
        return !isNotLastRow();
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

    private static boolean cellToRightOfUsAlreadyChecked() {
        return visitedCells[column + 1][row] != 0;
    }

    private static boolean endOfPath() {
        return cellToLeftOfUsAlreadyChecked() && cellToRightOfUsAlreadyChecked() && cellAboveUsAlreadyChecked() && cellBelowUsAlreadyChecked();
    }

    private static boolean onlyCellBelowUnchecked() {
        return cellToLeftOfUsAlreadyChecked() && cellToRightOfUsAlreadyChecked() && cellAboveUsAlreadyChecked() && !cellBelowUsAlreadyChecked();
    }

    private static boolean onlyCellToRightUnchecked() {
        return cellBelowUsAlreadyChecked() && cellAboveUsAlreadyChecked() && cellToLeftOfUsAlreadyChecked() && !cellToRightOfUsAlreadyChecked();
    }

    private static boolean onlyCellAboveUnchecked() {
        return cellToLeftOfUsAlreadyChecked() && cellToRightOfUsAlreadyChecked() && cellBelowUsAlreadyChecked() && !cellAboveUsAlreadyChecked();
    }

    private static boolean onlyCellToLeftUnchecked() {
        return cellAboveUsAlreadyChecked() && cellBelowUsAlreadyChecked() && cellToRightOfUsAlreadyChecked() && !cellToLeftOfUsAlreadyChecked();
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
            beginProcessing();
    }

    private static void beginProcessingIfNotAllCellsVisited() {
        if (unvisitedCellsRemain())
            beginProcessing();
    }

    private static void beginProcessingAndSetQToZeroIfNotAllCellsVisited() {
        if (unvisitedCellsRemain()) {
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

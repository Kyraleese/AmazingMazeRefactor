public class Amazing {
    static StringBuffer result = new StringBuffer();

    private static int x;
    private static int mazeWidth;
    private static int mazeHeight;
    private static int q;
    private static int z;
    private static int row;
    private static int column;
    private static int c;
    private static int[][] visitedCells;
    private static int[][] mazeCells;
    private static MazeGenerator generator;

    private static int RIGHT_BOTTOM_CORNER = 0;
    private static int RIGHT_WALL = 1;
    private static int BOTTOM_WALL = 2;
    private static int NO_WALLS = 3;


    private static void clear() {
        result.setLength(0);
    }

    private static void println() {
        result.append("\n");
    }

    private static void print(String text) {
        result.append(text);
    }

    private static void displayMaze() {
        print("Amazing - Copyright by Creative Computing, Morristown, NJ");
        println();

        if (mazeWidth != 1 && mazeHeight != 1) {
            // 130:170
            for (int i = 1; i <= mazeWidth; i++) {
                if (visitedCells[i][1] == RIGHT_WALL)
                    print("+  ");
                else
                    print("+--");
            }
            // 180
            print("+");
            println();

            // 1200:
            for (int j = 1; j <= mazeHeight; j++) {
                print("|");        // 1210

                for (int i = 1; i <= mazeWidth; i++) {
                    if (mazeCells[i][j] == RIGHT_BOTTOM_CORNER)
                        print("  |");
                    if (mazeCells[i][j] == RIGHT_WALL)
                        print("  |");
                    else if (mazeCells[i][j] == BOTTOM_WALL)
                        print("   ");  // 1240
                    else if (mazeCells[i][j] == NO_WALLS)
                        print("   ");  // 1240
                }

                print(" ");   // 1280
                println();

                for (int i = 1; i <= mazeWidth; i++) {
                    if (mazeCells[i][j] == RIGHT_BOTTOM_CORNER)
                        print("+--");   // 1300, 1340
                    else if (mazeCells[i][j] == RIGHT_WALL)
                        print("+  ");
                    else if (mazeCells[i][j] == BOTTOM_WALL)
                        print("+--");  // 1310, 1340
                    else if (mazeCells[i][j] == NO_WALLS)
                        print("+  "); // 1320
                }

                print("+");    // 1360
                println();
            }
        }
    }

    private static void initializeCells(int[][] cellArray) {
        for (int i = 0; i <= mazeWidth; i++) cellArray[i] = new int[mazeHeight + 1];
    }

    public static void doit(int width, int height) {
        clear();
        mazeWidth = width;
        mazeHeight = height;

        mazeCells = new int[mazeWidth + 1][mazeHeight + 1];
        visitedCells = new int[mazeWidth + 1][mazeHeight + 1];

        initializeCells(mazeCells);
        initializeCells(visitedCells);

        if (mazeWidth != 1 && mazeHeight != 1) {
            generator = new MazeGenerator(mazeCells, visitedCells);
            MazeGenerator.generate();
            mazeCells = MazeGenerator.getMazeGrid();
            visitedCells = MazeGenerator.getVisitedCells();
        }

        displayMaze();

    }

}

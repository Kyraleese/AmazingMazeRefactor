import java.util.Random;

public class MazeGenerator {
    private static int target = 0;
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

        target = 270;
    }

    private static int rnd(int count) {
        return (int) (count * random.nextFloat()) + 1;
    }

    public static void generate() {
        while (target != -1) {
            switch (target) {
                case 210:
                    if (column != mazeWidth)
                        target = 250;
                    else
                        target = 220;
                    continue;
                case 220:
                    if (row != mazeHeight)
                        target = 240;
                    else
                        target = 230;
                    continue;
                case 230:
                    column = 1;
                    row = 1;
                    target = 260;
                    continue;
                case 240:
                    column = 1;
                    row++;
                    target = 260;
                    continue;
                case 250:
                    column++;
                    target = 260;
                    continue;
                case 260:
                    if (visitedCells[column][row] == 0)
                        target = 210;
                    else
                        target = 270;
                    continue;
                case 270:
                    if (column - 1 == 0)
                        target = 600;
                    else
                        target = 280;
                    continue;
                case 280:
                    if (visitedCells[column - 1][row] != 0)
                        target = 600;
                    else
                        target = 290;
                    continue;
                case 290:
                    if (row - 1 == 0)
                        target = 430;
                    else
                        target = 300;
                    continue;
                case 300:
                    if (visitedCells[column][row - 1] != 0)
                        target = 430;
                    else
                        target = 310;
                    continue;
                case 310:
                    if (column == mazeWidth)
                        target = 350;
                    else
                        target = 320;
                    continue;
                case 320:
                    if (visitedCells[column + 1][row] != 0)
                        target = 350;
                    else
                        target = 330;
                    continue;
                case 330:
                    x = rnd(3);
                    target = 340;
                    continue;
                case 340:
                    if (x == 1)
                        target = 940;
                    else if (x == 2)
                        target = 980;
                    else if (x == 3)
                        target = 1020;
                    else
                        target = 350;
                    continue;
                case 350:
                    if (row != mazeHeight)
                        target = 380;
                    else
                        target = 360;
                    continue;
                case 360:
                    if (z == 1)
                        target = 410;
                    else
                        target = 370;
                    continue;
                case 370:
                    q = 1;
                    target = 390;
                    continue;
                case 380:
                    if (visitedCells[column][row + 1] != 0)
                        target = 410;
                    else
                        target = 390;
                    continue;
                case 390:
                    x = rnd(3);
                    target = 400;
                    continue;
                case 400:
                    if (x == 1)
                        target = 940;
                    else if (x == 2)
                        target = 980;
                    else if (x == 3)
                        target = 1090;
                    else
                        target = 410;
                    continue;
                case 410:
                    x = rnd(2);
                    target = 420;
                    continue;
                case 420:
                    if (x == 1)
                        target = 940;
                    else if (x == 2)
                        target = 980;
                    else
                        target = 430;
                    continue;
                case 430:
                    if (column == mazeWidth)
                        target = 530;
                    else
                        target = 440;
                    continue;
                case 440:
                    if (visitedCells[column + 1][row] != 0)
                        target = 530;
                    else
                        target = 450;
                    continue;
                case 450:
                    if (row != mazeHeight)
                        target = 480;
                    else
                        target = 460;
                    continue;
                case 460:
                    if (z == 1)
                        target = 510;
                    else
                        target = 470;
                    continue;
                case 470:
                    q = 1;
                    target = 490;
                    continue;
                case 480:
                    if (visitedCells[column][row + 1] != 0)
                        target = 510;
                    else
                        target = 490;
                    continue;
                case 490:
                    x = rnd(3);
                    target = 500;
                    continue;
                case 500:
                    if (x == 1)
                        target = 940;
                    else if (x == 2)
                        target = 1020;
                    else if (x == 3)
                        target = 1090;
                    else
                        target = 510;
                    continue;
                case 510:
                    x = rnd(2);
                    target = 520;
                    continue;
                case 520:
                    if (x == 1)
                        target = 940;
                    else if (x == 2)
                        target = 1020;
                    else
                        target = 530;
                    continue;
                case 530:
                    if (row != mazeHeight)
                        target = 560;
                    else
                        target = 540;
                    continue;
                case 540:
                    if (z == 1)
                        target = 590;
                    else
                        target = 550;
                    continue;
                case 550:
                    q = 1;
                    target = 570;
                    continue;
                case 560:
                    if (visitedCells[column][row + 1] != 0)
                        target = 590;
                    else
                        target = 570;
                    continue;
                case 570:
                    x = rnd(2);
                    target = 580;
                    continue;
                case 580:
                    if (x == 1)
                        target = 940;
                    else if (x == 2)
                        target = 1090;
                    else
                        target = 590;
                    continue;
                case 590:
                    target = 940;
                    continue;
                case 600:
                    if (row - 1 == 0)
                        target = 790;
                    else
                        target = 610;
                    continue;
                case 610:
                    if (visitedCells[column][row - 1] != 0)
                        target = 790;
                    else
                        target = 620;
                    continue;
                case 620:
                    if (column == mazeWidth)
                        target = 720;
                    else
                        target = 630;
                    continue;
                case 630:
                    if (visitedCells[column + 1][row] != 0)
                        target = 720;
                    else
                        target = 640;
                    continue;
                case 640:
                    if (row != mazeHeight)
                        target = 670;
                    else
                        target = 650;
                    continue;
                case 650:
                    if (z == 1)
                        target = 700;
                    else
                        target = 660;
                    continue;
                case 660:
                    q = 1;
                    target = 680;
                    continue;
                case 670:
                    if (visitedCells[column][row + 1] != 0)
                        target = 700;
                    else
                        target = 680;
                    continue;
                case 680:
                    x = rnd(3);
                    target = 690;
                    continue;
                case 690:
                    if (x == 1)
                        target = 980;
                    else if (x == 2)
                        target = 1020;
                    else if (x == 3)
                        target = 1090;
                    else
                        target = 700;
                    continue;
                case 700:
                    x = rnd(2);
                    target = 710;
                    continue;
                case 710:
                    if (x == 1)
                        target = 980;
                    else if (x == 2)
                        target = 1020;
                    else
                        target = 720;
                    continue;
                case 720:
                    if (row != mazeHeight)
                        target = 750;
                    else
                        target = 730;
                    continue;
                case 730:
                    if (z == 1)
                        target = 780;
                    else
                        target = 740;
                    continue;
                case 740:
                    q = 1;
                    target = 760;
                    continue;
                case 750:
                    if (visitedCells[column][row + 1] != 0)
                        target = 780;
                    else
                        target = 760;
                    continue;
                case 760:
                    x = rnd(2);
                    target = 770;
                    continue;
                case 770:
                    if (x == 1)
                        target = 980;
                    else if (x == 2)
                        target = 1090;
                    else
                        target = 780;
                    continue;
                case 780:
                    target = 980;
                    continue;
                case 790:
                    if (column == mazeWidth)
                        target = 880;
                    else
                        target = 800;
                    continue;
                case 800:
                    if (visitedCells[column + 1][row] != 0)
                        target = 880;
                    else
                        target = 810;
                    continue;
                case 810:
                    if (row != mazeHeight)
                        target = 840;
                    else
                        target = 820;
                    continue;
                case 820:
                    if (z == 1)
                        target = 870;
                    else
                        target = 830;
                    continue;
                case 830:
                    q = 1;
                    target = 990;
                    continue;
                case 840:
                    if (visitedCells[column][row + 1] != 0)
                        target = 870;
                    else
                        target = 850;
                    continue;
                case 850:
                    x = rnd(2);
                    target = 860;
                    continue;
                case 860:
                    if (x == 1)
                        target = 1020;
                    else if (x == 2)
                        target = 1090;
                    else
                        target = 870;
                    continue;
                case 870:
                    target = 1020;
                    continue;
                case 880:
                    if (row != mazeHeight)
                        target = 910;
                    else
                        target = 890;
                    continue;
                case 890:
                    if (z == 1)
                        target = 930;
                    else
                        target = 900;
                    continue;
                case 900:
                    q = 1;
                    target = 920;
                    continue;
                case 910:
                    if (visitedCells[column][row + 1] != 0)
                        target = 930;
                    else
                        target = 920;
                    continue;
                case 920:
                    target = 1090;
                    continue;
                case 930:
                    target = 1190;
                    continue;
                case 940:
                    visitedCells[column - 1][row] = c;
                    target = 950;
                    continue;
                case 950:
                    c++;
                    mazeGrid[column - 1][row] = 2;
                    column--;
                    target = 960;
                    continue;
                case 960:
                    if (c == mazeWidth * mazeHeight + 1)
                        target = 1200;
                    else
                        target = 1010;
                    continue;
                case 1010:
                    q = 0;
                    target = 270;
                    continue;
                case 980:
                    visitedCells[column][row - 1] = c;
                    target = 990;
                    continue;
                case 990:
                    c++;
                    target = 1000;
                    continue;
                case 1000:
                    mazeGrid[column][row - 1] = 1;
                    row--;
                    if (c == mazeWidth * mazeHeight + 1)
                        target = 1200;
                    else
                        target = 1010;
                    continue;
                case 1020:
                    visitedCells[column + 1][row] = c;
                    target = 1030;
                    continue;
                case 1030:
                    c++;
                    if (mazeGrid[column][row] == 0)
                        target = 1050;
                    else
                        target = 1040;
                    continue;
                case 1040:
                    mazeGrid[column][row] = 3;
                    target = 1060;
                    continue;
                case 1050:
                    mazeGrid[column][row] = 2;
                    target = 1060;
                    continue;
                case 1060:
                    column++;
                    target = 1070;
                    continue;
                case 1070:
                    if (c == mazeWidth * mazeHeight + 1)
                        target = 1200;
                    else
                        target = 1080;
                    continue;
                case 1080:
                    target = 600;
                    continue;
                case 1090:
                    if (q == 1)
                        target = 1150;
                    else
                        target = 1100;
                    continue;
                case 1100:
                    visitedCells[column][row + 1] = c;
                    c++;
                    if (mazeGrid[column][row] == 0)
                        target = 1120;
                    else
                        target = 1110;
                    continue;
                case 1110:
                    mazeGrid[column][row] = 3;
                    target = 1130;
                    continue;
                case 1120:
                    mazeGrid[column][row] = 1;
                    target = 1130;
                    continue;
                case 1130:
                    row++;
                    if (c == mazeHeight * mazeWidth + 1)
                        target = 1200;
                    else
                        target = 1140;
                    continue;
                case 1140:
                    target = 270;
                    continue;
                case 1150:
                    z = 1;
                    target = 1160;
                    continue;
                case 1160:
                    if (mazeGrid[column][row] == 0)
                        target = 1180;
                    else
                        target = 1170;
                    continue;
                case 1170:
                    mazeGrid[column][row] = 3;
                    q = 0;
                    target = 1190;
                    continue;
                case 1180:
                    mazeGrid[column][row] = 1;
                    q = 0;
                    column = 1;
                    row = 1;
                    target = 260;
                    continue;
                case 1190:
                    target = 210;
                    continue;
                case 1200:
                    target = -1;
            }

        }
    }
}

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


    private static boolean shouldContinueGenerating() {
        return target != -1;
    }

    public static void generate() {
        while (shouldContinueGenerating()) {
            switch (target) {
                case 210:
                    case210();
                    continue;
                case 220:
                    case220();
                    continue;
                case 230:
                    case230();
                    continue;
                case 240:
                    case240();
                    continue;
                case 250:
                    case250();
                    continue;
                case 260:
                    case260();
                    continue;
                case 270:
                    case270();
                    continue;
                case 280:
                    case280();
                    continue;
                case 290:
                    case290();
                    continue;
                case 300:
                    case300();
                    continue;
                case 310:
                    case310();
                    continue;
                case 320:
                    case320();
                    continue;
                case 330:
                    case330();
                    continue;
                case 340:
                    case340();
                    continue;
                case 350:
                    case350();
                    continue;
                case 360:
                    case360();
                    continue;
                case 370:
                    case370();
                    continue;
                case 380:
                    case380();
                    continue;
                case 390:
                    case390();
                    continue;
                case 400:
                    case400();
                    continue;
                case 410:
                    case410();
                    continue;
                case 420:
                    case420();
                    continue;
                case 430:
                    case430();
                    continue;
                case 440:
                    case440();
                    continue;
                case 450:
                    case450();
                    continue;
                case 460:
                    case460();
                    continue;
                case 470:
                    case470();
                    continue;
                case 480:
                    case480();
                    continue;
                case 490:
                    case490();
                    continue;
                case 500:
                    case500();
                    continue;
                case 510:
                    case510();
                    continue;
                case 520:
                    case520();
                    continue;
                case 530:
                    case530();
                    continue;
                case 540:
                    case540();
                    continue;
                case 550:
                    case550();
                    continue;
                case 560:
                    case560();
                    continue;
                case 570:
                    case570();
                    continue;
                case 580:
                    case580();
                    continue;
                case 590:
                    target = 940;
                    continue;
                case 600:
                    case600();
                    continue;
                case 610:
                    case610();
                    continue;
                case 620:
                    case620();
                    continue;
                case 630:
                    case630();
                    continue;
                case 640:
                    case640();
                    continue;
                case 650:
                    case650();
                    continue;
                case 660:
                    case660();
                    continue;
                case 670:
                    case670();
                    continue;
                case 680:
                    case680();
                    continue;
                case 690:
                    case690();
                    continue;
                case 700:
                    case700();
                    continue;
                case 710:
                    case710();
                    continue;
                case 720:
                    case720();
                    continue;
                case 730:
                    case730();
                    continue;
                case 740:
                    case740();
                    continue;
                case 750:
                    case750();
                    continue;
                case 760:
                    case760();
                    continue;
                case 770:
                    case770();
                    continue;
                case 790:
                    case790();
                    continue;
                case 800:
                    case800();
                    continue;
                case 810:
                    case810();
                    continue;
                case 820:
                    case820();
                    continue;
                case 830:
                    case830();
                    continue;
                case 840:
                    case840();
                    continue;
                case 850:
                    case850();
                    continue;
                case 860:
                    case860();
                    continue;
                case 880:
                    case880();
                    continue;
                case 890:
                    case890();
                    continue;
                case 900:
                    case900();
                    continue;
                case 910:
                    case910();
                    continue;
                case 940:
                    case940();
                    continue;
                case 950:
                    case950();
                    continue;
                case 960:
                    case960();
                    continue;
                case 1010:
                    case1010();
                    continue;
                case 980:
                    case980();
                    continue;
                case 990:
                    case990();
                    continue;
                case 1000:
                    case1000();
                    continue;
                case 1020:
                    case1020();
                    continue;
                case 1030:
                    case1030();
                    continue;
                case 1040:
                    case1040();
                    continue;
                case 1050:
                    case1050();
                    continue;
                case 1060:
                    case1060();
                    continue;
                case 1070:
                    case1070();
                    continue;
                case 1090:
                    case1090();
                    continue;
                case 1100:
                    case1100();
                    continue;
                case 1110:
                    case1110();
                    continue;
                case 1120:
                    case1120();
                    continue;
                case 1130:
                    case1130();
                    continue;
                case 1150:
                    case1150();
                    continue;
                case 1160:
                    case1160();
                    continue;
                case 1170:
                    case1170();
                    continue;
                case 1180:
                    case1180();
            }

        }
    }

    private static void case1180() {
        mazeGrid[column][row] = 1;
        q = 0;
        case230();
    }

    private static void case1170() {
        mazeGrid[column][row] = 3;
        q = 0;
        target = 210;
    }

    private static void case1160() {
        if (mazeGrid[column][row] == 0)
            target = 1180;
        else
            target = 1170;
    }

    private static void case1150() {
        z = 1;
        target = 1160;
    }

    private static void case1130() {
        row++;
        if (c == mazeHeight * mazeWidth + 1)
            target = -1;
        else
            target = 270;
    }

    private static void case1120() {
        mazeGrid[column][row] = 1;
        target = 1130;
    }

    private static void case1110() {
        mazeGrid[column][row] = 3;
        target = 1130;
    }

    private static void case1100() {
        visitedCells[column][row + 1] = c;
        c++;
        if (mazeGrid[column][row] == 0)
            target = 1120;
        else
            target = 1110;
    }

    private static void case1090() {
        if (q == 1)
            target = 1150;
        else
            target = 1100;
    }

    private static void case1070() {
        if (c == mazeWidth * mazeHeight + 1)
            target = -1;
        else
            target = 600;
    }

    private static void case1060() {
        column++;
        target = 1070;
    }

    private static void case1050() {
        mazeGrid[column][row] = 2;
        target = 1060;
    }

    private static void case1040() {
        mazeGrid[column][row] = 3;
        target = 1060;
    }

    private static void case1030() {
        c++;
        if (mazeGrid[column][row] == 0)
            target = 1050;
        else
            target = 1040;
    }

    private static void case1020() {
        visitedCells[column + 1][row] = c;
        target = 1030;
    }

    private static void case1000() {
        mazeGrid[column][row - 1] = 1;
        row--;
        case960();
    }

    private static void case990() {
        c++;
        target = 1000;
    }

    private static void case980() {
        visitedCells[column][row - 1] = c;
        target = 990;
    }

    private static void case1010() {
        q = 0;
        target = 270;
    }

    private static void case960() {
        if (c == mazeWidth * mazeHeight + 1)
            target = -1;
        else
            target = 1010;
    }

    private static void case950() {
        c++;
        mazeGrid[column - 1][row] = 2;
        column--;
        target = 960;
    }

    private static void case940() {
        visitedCells[column - 1][row] = c;
        target = 950;
    }

    private static void case910() {
        if (visitedCells[column][row + 1] != 0)
            target = 210;
        else
            target = 1090;
    }

    private static void case900() {
        q = 1;
        target = 1090;
    }

    private static void case890() {
        if (z == 1)
            target = 210;
        else
            target = 900;
    }

    private static void case880() {
        if (row != mazeHeight)
            target = 910;
        else
            target = 890;
    }

    private static void case860() {
        if (x == 1)
            target = 1020;
        else if (x == 2)
            target = 1090;
        else
            target = 1020;
    }

    private static void case850() {
        x = rnd(2);
        target = 860;
    }

    private static void case840() {
        if (visitedCells[column][row + 1] != 0)
            target = 1020;
        else
            target = 850;
    }

    private static void case830() {
        q = 1;
        target = 990;
    }

    private static void case820() {
        if (z == 1)
            target = 1020;
        else
            target = 830;
    }

    private static void case810() {
        if (row != mazeHeight)
            target = 840;
        else
            target = 820;
    }

    private static void case800() {
        if (visitedCells[column + 1][row] != 0)
            target = 880;
        else
            target = 810;
    }

    private static void case790() {
        if (column == mazeWidth)
            target = 880;
        else
            target = 800;
    }

    private static void case770() {
        if (x == 1)
            target = 980;
        else if (x == 2)
            target = 1090;
        else
            target = 980;
    }

    private static void case760() {
        x = rnd(2);
        target = 770;
    }

    private static void case750() {
        if (visitedCells[column][row + 1] != 0)
            target = 980;
        else
            target = 760;
    }

    private static void case740() {
        q = 1;
        target = 760;
    }

    private static void case730() {
        if (z == 1)
            target = 980;
        else
            target = 740;
    }

    private static void case720() {
        if (row != mazeHeight)
            target = 750;
        else
            target = 730;
    }

    private static void case710() {
        if (x == 1)
            target = 980;
        else if (x == 2)
            target = 1020;
        else
            target = 720;
    }

    private static void case700() {
        x = rnd(2);
        target = 710;
    }

    private static void case690() {
        if (x == 1)
            target = 980;
        else if (x == 2)
            target = 1020;
        else if (x == 3)
            target = 1090;
        else
            target = 700;
    }

    private static void case680() {
        x = rnd(3);
        target = 690;
    }

    private static void case670() {
        if (visitedCells[column][row + 1] != 0)
            target = 700;
        else
            target = 680;
    }

    private static void case660() {
        q = 1;
        target = 680;
    }

    private static void case650() {
        if (z == 1)
            target = 700;
        else
            target = 660;
    }

    private static void case640() {
        if (row != mazeHeight)
            target = 670;
        else
            target = 650;
    }

    private static void case630() {
        if (visitedCells[column + 1][row] != 0)
            target = 720;
        else
            target = 640;
    }

    private static void case620() {
        if (column == mazeWidth)
            target = 720;
        else
            target = 630;
    }

    private static void case610() {
        if (visitedCells[column][row - 1] != 0)
            target = 790;
        else
            target = 620;
    }

    private static void case600() {
        if (row - 1 == 0)
            target = 790;
        else
            target = 610;
    }

    private static void case580() {
        if (x == 1)
            target = 940;
        else if (x == 2)
            target = 1090;
        else
            target = 590;
    }

    private static void case570() {
        x = rnd(2);
        target = 580;
    }

    private static void case560() {
        if (visitedCells[column][row + 1] != 0)
            target = 590;
        else
            target = 570;
    }

    private static void case550() {
        q = 1;
        target = 570;
    }

    private static void case540() {
        if (z == 1)
            target = 590;
        else
            target = 550;
    }

    private static void case530() {
        if (row != mazeHeight)
            target = 560;
        else
            target = 540;
    }

    private static void case520() {
        if (x == 1)
            target = 940;
        else if (x == 2)
            target = 1020;
        else
            target = 530;
    }

    private static void case510() {
        x = rnd(2);
        target = 520;
    }

    private static void case500() {
        if (x == 1)
            target = 940;
        else if (x == 2)
            target = 1020;
        else if (x == 3)
            target = 1090;
        else
            target = 510;
    }

    private static void case490() {
        x = rnd(3);
        target = 500;
    }

    private static void case480() {
        if (visitedCells[column][row + 1] != 0)
            target = 510;
        else
            target = 490;
    }

    private static void case470() {
        q = 1;
        target = 490;
    }

    private static void case460() {
        if (z == 1)
            target = 510;
        else
            target = 470;
    }

    private static void case450() {
        if (row != mazeHeight)
            target = 480;
        else
            target = 460;
    }

    private static void case440() {
        if (visitedCells[column + 1][row] != 0)
            target = 530;
        else
            target = 450;
    }

    private static void case430() {
        if (column == mazeWidth)
            target = 530;
        else
            target = 440;
    }

    private static void case420() {
        if (x == 1)
            target = 940;
        else if (x == 2)
            target = 980;
        else
            target = 430;
    }

    private static void case410() {
        x = rnd(2);
        target = 420;
    }

    private static void case400() {
        if (x == 1)
            target = 940;
        else if (x == 2)
            target = 980;
        else if (x == 3)
            target = 1090;
        else
            target = 410;
    }

    private static void case390() {
        x = rnd(3);
        target = 400;
    }

    private static void case380() {
        if (visitedCells[column][row + 1] != 0)
            target = 410;
        else
            target = 390;
    }

    private static void case370() {
        q = 1;
        target = 390;
    }

    private static void case360() {
        if (z == 1)
            target = 410;
        else
            target = 370;
    }

    private static void case350() {
        if (row != mazeHeight)
            target = 380;
        else
            target = 360;
    }

    private static void case340() {
        if (x == 1)
            target = 940;
        else if (x == 2)
            target = 980;
        else if (x == 3)
            target = 1020;
        else
            target = 350;
    }

    private static void case330() {
        x = rnd(3);
        target = 340;
    }

    private static void case320() {
        if (visitedCells[column + 1][row] != 0)
            target = 350;
        else
            target = 330;
    }

    private static void case310() {
        if (column == mazeWidth)
            target = 350;
        else
            target = 320;
    }

    private static void case300() {
        if (visitedCells[column][row - 1] != 0)
            target = 430;
        else
            target = 310;
    }

    private static void case290() {
        if (row - 1 == 0)
            target = 430;
        else
            target = 300;
    }

    private static void case280() {
        if (visitedCells[column - 1][row] != 0)
            target = 600;
        else
            target = 290;
    }

    private static void case270() {
        if (column - 1 == 0)
            target = 600;
        else
            target = 280;
    }

    private static void case260() {
        if (visitedCells[column][row] == 0)
            target = 210;
        else
            target = 270;
    }

    private static void case250() {
        column++;
        target = 260;
    }

    private static void case240() {
        column = 1;
        row++;
        target = 260;
    }

    private static void case230() {
        column = 1;
        row = 1;
        target = 260;
    }

    private static void case220() {
        if (row != mazeHeight)
            target = 240;
        else
            target = 230;
    }

    private static void case210() {
        if (column != mazeWidth)
            target = 250;
        else
            target = 220;
    }

}

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class XO {
    static Random hodII = new Random();
    static Scanner hodCheloveka = new Scanner(System.in);
    static char[][] gamePanel;
    final static int sizeMap = 3;
    final static char emptyElement = '*';
    final static char emptyElementX = 'X';
    final static char emptyElementY = '0';

    public static void main(String[] args) {
        //запуск игры
        initGame();
        gameMap();
        while (true) {
            hodIroka();
            gameMap();

            if (checkWin(emptyElementX)) {
                System.out.println("Игра окончена, победил игрок");
                break;
            }
            if (checkDraft()) { // Добавлено условие для ничьи
                System.out.println("Ничья!");
                break;
            }
            hodBota();
            gameMap();
            if (checkWin(emptyElementY)) {
                System.out.println("Игра окончена, победил бот");
                break;
            }
            if (checkDraft()) { // Добавлено условие для ничьи
                System.out.println("Ничья!");
                break;
            }
        }
}

    public static boolean checkWin(char playerField){
        //0 1 2 3
        //1 * * *
        //2 * * *
        //3 * * *
        if (gamePanel[0][0] == playerField && gamePanel[0][1] == playerField && gamePanel[0][2] == playerField)
            return true;
        if (gamePanel[1][0] == playerField && gamePanel[1][1] == playerField && gamePanel[1][2] == playerField)
            return true;
        if (gamePanel[2][0] == playerField && gamePanel[2][1] == playerField && gamePanel[2][2] == playerField)
            return true;

        if (gamePanel[0][0] == playerField && gamePanel[1][0] == playerField && gamePanel[2][0] == playerField)
            return true;
        if (gamePanel[0][1] == playerField && gamePanel[1][1] == playerField && gamePanel[2][1] == playerField)
            return true;
        if (gamePanel[0][2] == playerField && gamePanel[1][2] == playerField && gamePanel[2][2] == playerField)
            return true;
        if (gamePanel[0][0] == playerField && gamePanel[1][1] == playerField && gamePanel[2][2] == playerField)
            return true;
        if (gamePanel[0][2] == playerField && gamePanel[1][1] == playerField && gamePanel[2][0] == playerField)
            return true;

            return false;
    }
    public static boolean checkDraft(){
        for (int i = 0; i < sizeMap; i++) {
            for (int j = 0; j < sizeMap; j++) {
                if(gamePanel[i][j] == emptyElement)
                    return false;
            }
        }
    return true;
    }
    public static boolean checkGame(int x,int y){

        if(x < 0 || y < 0 || x >= sizeMap || y >= sizeMap)
            return false;
        if(gamePanel[x][y] != emptyElement)
            return false;
        return true;
    }
    public static void hodBota() {
        int x, y;
        System.out.println("ход компа");
        do {
            x = (int)(Math.random() * sizeMap);
            y = (int)(Math.random() * sizeMap);
        } while (!checkGame(x, y));
        gamePanel[y][x] = emptyElementY;

    }
        public static void hodIroka(){
        int x,y;
        do{
            System.out.println("введи своц ход");
            x = hodCheloveka.nextInt() - 1;
            y = hodCheloveka.nextInt() - 1;
        }while (!checkGame(x,y));
        gamePanel[y][x] = emptyElementX;
        //0 1 2 3
        //1 * * *
        //2 * * *
        //3 * * *

    } public static void gameMap(){
        //поле игры
        for (int i = 0; i <= sizeMap; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < sizeMap; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < sizeMap; j++) {
                System.out.print(gamePanel[i][j] + " ");
            }
            System.out.println();
        }

    }    public static void initGame(){
        //заполнение поля
        gamePanel = new char[sizeMap][sizeMap];
        for (int i = 0; i < sizeMap; i++) {
            for (int j = 0; j < sizeMap; j++) {
                gamePanel[i][j] = emptyElement;
            }
        }
    }
}
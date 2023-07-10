package com.example.hwl4;


import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp  {
    public static int SIZE=3;
    public static int DOTS_TO_WIN = 3;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public  static Scanner scan= new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        initMap();
        printMap();
        while (true){
            humanTurn();
            printMap();
            if(checWin(DOT_X)){
                System.out.println("Победил человек");
                break;
            }
            if(isMapFull()){
                System.out.println("Ничья");
                break;
            }

            compTurn();
            printMap();
            if(checWin(DOT_O)){
                System.out.println("Победил компьютер");
                break;
            }
            if(isMapFull()){
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Конец игры!");

        while (true){
            System.out.println("Начать заново? (y/n)");
            String p = scan.next();
            if(p.equals("y")) {start();}
            else if (p.equals("n")) {System.out.println("Пока!"); break;}
        }
    }

    public static void initMap(){
       map = new char[SIZE][SIZE];
       for (int i = 0; i < SIZE; i++) {
           for (int j = 0; j < SIZE; j++) {
               map[i][j] = DOT_EMPTY;
           }
       }
   }

   public static void printMap(){
       for (int i = 0; i <= SIZE; i++) {
           System.out.print(i+" ");
       }
       System.out.println();
       for (int i = 0; i < SIZE; i++) {
           System.out.print((i + 1) + " ");
           for (int j = 0; j < SIZE; j++) {
               System.out.print(map[i][j] + " ");
           }
           System.out.println();
       }
       System.out.println();
   }
   public static boolean isCellValid(int x, int y){
        if(x<0 || x>SIZE || y<0 ||y>SIZE) return false;
        if (map[y][x]==DOT_EMPTY) return true;
        return false;
   }
   public static void humanTurn(){
        int x,y;
        do{
            System.out.println("Введите координаты в формате X Y");
            x=scan.nextInt()-1;
            y=scan.nextInt()-1;
        }while (!isCellValid(x,y));
        map[y][x]=DOT_X;
   }
   public static void compTurn(){
       int x,y;
       do{

           x=rand.nextInt(SIZE);
           y=rand.nextInt(SIZE);
       }while (!isCellValid(x,y));
       map[y][x]=DOT_O;
       System.out.println("Компьютер выбрал точку: "+(x+1)+" "+(y+1));
   }

   public static boolean checWin(char symb){
        for (int  i=0;i<SIZE;i++){
            if(map[i][0] == symb && map[i][1] == symb && map[i][2] == symb) return true;
            if(map[0][i] == symb && map[1][i] == symb && map[2][i] == symb) return true;
        }
       if(map[0][0] == symb && map[1][1] == symb && map[2][2] == symb) return true;
       if(map[2][0] == symb && map[1][1] == symb && map[0][2] == symb) return true;

       return false;
   }
    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

}
package com.company;

import java.util.Scanner;

public class BookWorm {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String string = input.nextLine();
        int size = Integer.parseInt(input.nextLine());
        String [][] array = new String[size][size];
        int row = 0;
        int col = 0;
        for (int i = 0; i < size ; i++) {
            String data = input.nextLine();
            array[i] = new String[data.length()];
            for (int j = 0; j < data.length(); j++) {
                array[i][j] = String.valueOf(data.charAt(j));
                if (array[i][j].equals("P")){
                    row = i;
                    col = j;
                }
            }
        }
        while (true){
            String txt = input.nextLine();
            if (txt.equals("end")){
                break;
            }
            array[row][col] = "-";
            switch (txt) {
                case "up":
                    row--;
                    if (row < 0) {
                        row = 0;
                        string = Removing(string);
                    } else {
                        string = CheckForLetter(string, array, row, col);
                    }
                    break;
                case "down":
                    row++;
                    if (row == array.length) {
                        row = array.length - 1;
                        string = Removing(string);
                    } else {
                        string = CheckForLetter(string, array, row, col);
                    }
                    break;
                case "left":
                    col--;
                    if (col < 0) {
                        col = 0;
                        string = Removing(string);
                    } else {
                        string = CheckForLetter(string, array, row, col);
                    }
                    break;
                case "right":
                    col++;
                    if (col == array.length) {
                        col = array.length - 1;
                        string = Removing(string);
                    } else {
                        string = CheckForLetter(string, array, row, col);
                    }
                    break;
            }
            array[row][col] = "P";
        }
        System.out.println(string);
        for (String[] strings : array) {
            for (String s : strings) {
                System.out.print(s);
            }
            System.out.println();
        }
    }

    private static String CheckForLetter(String string, String[][] array, int row, int col) {
        char ch = array[row][col].charAt(0);
        if (Character.isLetter(ch)){
            string = string + ch;
        }
        return string;
    }

    private static String Removing(String string) {
       String stringReplace = string.substring(string.length()-1);
       int str = string.lastIndexOf(stringReplace);
      string = string.substring(0,str);

        return string;
    }
}

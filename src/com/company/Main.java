package com.company;

import com.company.db.DeleteDB;
import com.company.db.InsertDB;
import com.company.db.TablesDB;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        for (; ; ) {
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println("|                               Что вы хотите сделать?                             |");
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println("| 1. Вывести данные из БД\t | 2. Добавить данные в БД\t | 3. Удалить данные из БД |");
            //System.out.println("------------------------------------------------------------------------------------");
            System.out.println("| 4. Выйти из программы                                                            |");
            System.out.println("------------------------------------------------------------------------------------");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Выберите операцию: ");
            int number = scanner.nextInt();

            switch (number) {
                case 1 -> new TablesDB().GetTable();
                case 2 -> {
                    Scanner scannerName = new Scanner(System.in);
                    System.out.print("Input product name: ");
                    String name = scannerName.nextLine();
                    System.out.print("Input product price: ");
                    int price = scanner.nextInt();
                    new InsertDB().SetValues(name, price);
                }
                case 3 -> {
                    System.out.print("Введите номер строки который нужно удалить: ");
                    int row = scanner.nextInt();
                    new DeleteDB().Delete(row);
                }
                case 4 -> System.exit(1);
                default -> System.out.println("Error!");
            }
        }
    }
}

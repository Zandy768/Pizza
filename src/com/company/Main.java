/*
Project: Lab 9
Purpose Details: Ordering Application
Course: IST 242
Author: Andy Zhu
Date Developed: 6/9/19
Last Date Changed:
Revision:
*/

package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    int cCount = 1;
    int oCount = 1;
    public static void main(String[] args) {

        Main main = new Main();

        final char EXIT_CODE = 'E';
        final char CUST_CODE = 'C';
        final char MENU_CODE = 'M';
        final char ORDE_CODE = 'O';
        final char TRAN_CODE = 'T';
        final char CUST_PRNT = 'P';
        final char HELP_CODE = '?';
        char userAction;
        final String PROMPT_ACTION = "Add [C]ustomer, [P]rint Customer, List [M]enu, Add [O]rder, List [T]ransaction or [E]xit: ";
        ArrayList<Customer> cList = new ArrayList<>();
        ArrayList<Menu> mList = new ArrayList<>();
        ArrayList<Order> oList = new ArrayList<>();
        ArrayList<Transaction> tList = new ArrayList<>();

        Order o1 = new Order(0);
        Transaction t1 = new Transaction(1, o1, PaymentType.cash);
        tList.add(t1);

        Menu menu1 = new Menu(1, "Plain", 7.50);
        Menu menu2 = new Menu(2, "Meat", 9.00);
        Menu menu3 = new Menu(3, "Extra", 0.50);
        Menu menu4 = new Menu(4, "Veg", 8.00);

        mList.add(menu1);
        mList.add(menu2);
        mList.add(menu3);
        mList.add(menu4);

        userAction = getAction(PROMPT_ACTION);

        while (userAction != EXIT_CODE) {
            switch(userAction) {
                case CUST_CODE : cList.add(main.addCustomer());
                    break;
                case CUST_PRNT : Customer.printCustomer(cList);
                    break;
                case MENU_CODE : Menu.listMenu(mList);
                    break;
                case ORDE_CODE : oList.add(main.addOrder());
                    break;
                case TRAN_CODE : Transaction.listTransactions(tList,oList);
                    break;
            }

            userAction = getAction(PROMPT_ACTION);
        }
    }

    public static char getAction(String prompt) {
        Scanner scnr = new Scanner(System.in);
        String answer = "";
        System.out.println(prompt);
        answer = scnr.nextLine().toUpperCase() + " ";
        char firstChar = answer.charAt(0);
        return firstChar;
    }

    public Customer addCustomer(){
        Customer cust = new Customer(cCount++);
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please Enter your Name: ");
        cust.setCustomerName(scnr.nextLine());
        System.out.println("Please Enter your Phone: ");
        cust.setCustomerPhoneNumber(scnr.nextLine());
        return cust;
    }


    public Order addOrder() {
        final char Add = 'A';
        final char Delete = 'D';
        final char Exit = 'E';
        char user;
        final String option = "[A]dd Item, [D]elete Item, [E]xit ordering menu";
        ArrayList<String> orders = new ArrayList<>();
        Order order = new Order(oCount++);
        Scanner scnr = new Scanner(System.in);
        user = getAction(option);
        while (user != Exit) {
            if(user == Add) {
                System.out.println("Current Order:");
                for (String i: orders){
                    System.out.println(i);
                }
                System.out.println("Enter a item to add:");
                orders.add(scnr.nextLine());
                user = 0;
            }
            else if (user == Delete) {
                System.out.println("Current Order:");
                for (String i: orders){
                    System.out.println(i);
                }
                System.out.println("Enter a item to delete:");
                orders.remove(scnr.nextLine());
                user = 0;
            }
            else if ( user == Exit) {
                user = 'E';
                user = 0;
            }
            else {
                user = getAction(option);
            }
        }
        return order;
    }
}
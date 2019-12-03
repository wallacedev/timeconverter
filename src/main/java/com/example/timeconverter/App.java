package com.example.timeconverter;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Digite uma um valor:" );
        StringTimeConverter stringTimeConverter = new StringTimeConverter();
        Scanner input = new Scanner(System.in);
        System.out.println( stringTimeConverter.convert(input.nextLine()));
    }
}

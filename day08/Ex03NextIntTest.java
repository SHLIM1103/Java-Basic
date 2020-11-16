package day08;

import java.util.Scanner;

import util.ScannerUtil;

public class Ex03NextIntTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int number = ScannerUtil.nextInt(scanner, "", 0, 100);
        
        System.out.println("★출력되는 number: " + number);
                
        scanner.close();
    }
}

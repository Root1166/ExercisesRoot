/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai5;

import java.util.Scanner;

/**
 *
 * @author Anonymous
 */
public class tinhtongSn9 {
    public static void main(String[] args) {    
        float sum = 0f;
        int n;
        float x;
        Scanner input;
        System.out.println("Tính tổng S(x, n) = x^2 + x^4 + x^6 +…+ x^2n: ");
        do {
            System.out.print("Input n = ");
            input = new Scanner(System.in);
            n = input.nextInt();
        }while(n <= 0);
         
        System.out.print("Input x = ");
        x = input.nextFloat();
         
        for(int i = 1; i <= n; i++) {
            sum += (float)Math.pow(x, 2*i);
        }
         
        System.out.println("Sum = " + sum);
        input.close();
    
    }
}
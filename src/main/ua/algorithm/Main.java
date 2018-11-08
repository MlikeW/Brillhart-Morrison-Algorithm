package main.ua.algorithm;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Please enter your number:");

        int n;
        Scanner sc = new Scanner(System.in);

        loop:
        while(true) {
            if (!sc.hasNextInt()) {
                System.err.println("WRONG INPUT. Please enter number, not symbol:");
                sc.nextLine();
                continue loop;
            } else {
                n = sc.nextInt();
                if (n <= 0) {
                    System.err.println("WRONG INPUT. Please enter positive number:");
                    sc.nextLine();
                    continue loop;
                } else break loop;
            }
        }
        int[] s = new int[20];
        int[] ps = new int[20];
        int[] p2s = new int[20];


        int[] a = new int[20];
        int[] u = new int[20];
        int[] v = new int[20];
        double[] alfa = new double[20];
        int u0 = 0, v0 = 1, i = 1;
        a[0] = (int) Math.sqrt(n);
        ps[0] = a[0];
        p2s[0] =  (ps[0]*ps[0]) % n;
        u[0] = u0 + v0*a[0];
        v[0] = v0;
        s[0] = 0;
        alfa[0] = 0;
        System.out.println("a0 = " + a[0] + ",  u0 = " + u[0] + ",  v0 = " + v[0]);

        loop1:
        while(true) {
            v[i] = (n - u[i-1]*u[i-1])/v[i-1];
            alfa[i] = (a[0] + u[i-1])/v[i];
            a[i] = (int)alfa[i];
            u[i] = a[i]*v[i] - u[i-1];
            System.out.println("v"+i+" = "+v[i]+",  a"+i+" = "+a[i]+",  u"+i+" = "+u[i]);
            s[i] = i;
            if (i!=1){
                ps[i] = (a[i]*ps[i-1] + ps[i-2]) % n;
            } else {
                ps[1] = a[1]*ps[0] + 1;
            }
            p2s[i] = (ps[i]*ps[i]) % n;
            if (p2s[i] > (n/2)) { p2s[i] = p2s[i] - n; }

            i++;
            if (i < 7){continue loop1;} else break loop1;
        }
        System.out.println("\n_________________\n");
        for (int j=0;j<i;j++){
            System.out.println("s"+j+" = "+s[j]+",   a"+j+" = "+a[j]+",   ps"+j+" = "+ps[j]+",   p2s"+j+" = "+p2s[j]);
        }

    }
}

/*
 * Implementation of ADTHunteamEcaluation
 * Author: Moreno Lopez Jose Rodrigo
 * Date:   05/02/2023
 */

import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.print.event.PrintEvent;

import java.lang.*;
import java.lang.reflect.Array;

public class HunteamSolutions implements ADTHunteamEvaluation {
    // Some data:
    private static String path = "C:\\Users\\rodri\\Documents\\java\\HunteamExam\\prueba.txt";
    /*
     * The following method implements the solution to the first problem. 
     */
    
    @Override
    public void problemOne(String path) {
        File data = new File(path);
        try{
            Scanner sc = new Scanner(data);
            String num = "";
            while (sc.hasNextLine()){
                num = num + sc.nextLine();
            }
            String[] numAux = num.split("");
            sc.close();
            double max = 0;
            int idx = 0;
            for (int i = 3; i <= num.length()-14 ; i++){
                double multi = 1;
                for (int j = 0; j <= 12; j++){
                    multi = multi * Integer.parseInt(numAux[i+j]);
                }
                if (multi > max) {
                    max = multi;
                    idx = i;
                }
            }
            String multiplication = "";
            for (int k = 0; k <= 12; k++){
                multiplication += "("+numAux[idx + k]+")";
            }
            System.out.println("++ The max product is: "+multiplication+" = "+max);
            System.out.println(idx);

        }catch(Exception e){
            System.out.println("No se encuentra el archivo");
        }
        
        
    }
    
    @Override
    public void problemTwo() {
        Scanner sc2 = new Scanner(System.in);
        String firstInput = sc2.nextLine();
        String secondInput = sc2.nextLine();
        sc2.close();
        String[] nk = firstInput.split(",");
        String[] arrArr = secondInput.split(",");
        int N = Integer.parseInt(nk[0]);
        int K = Integer.parseInt(nk[1]);
        List<int[]> list = new ArrayList<int[]>();
        int totNumOfEqtns = 0;
        for (int i = 0; i <= N-2; i++){
            for (int j = i+1; j <= arrArr.length-1; j++){
                int aux = Integer.parseInt(arrArr[i]) + Integer.parseInt(arrArr[j]);
                if (K == aux){
                    totNumOfEqtns++;
                    int[] aux2 = {Integer.parseInt(arrArr[i]), Integer.parseInt(arrArr[j])};
                    list.add(aux2);
                }
            }
        }
        System.out.println("++ The total number of pairs is: "+totNumOfEqtns);
        System.out.println("Because: \n");
        for (int[] var : list){
            System.out.println(Arrays.toString(var)+" sums " + K);
        }

    }

    public static void main(String[] args) {
        HunteamSolutions hs = new HunteamSolutions();
        // Solution to firts problem.
        hs.problemOne("C:\\Users\\rodri\\Documents\\java\\HunteamExam\\prueba.txt");
        // Solution to second problem.
        hs.problemTwo();
    }

}

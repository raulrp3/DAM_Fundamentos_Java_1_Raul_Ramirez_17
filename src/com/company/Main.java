package com.company;

import java.util.Scanner;

public class Main {
    public static double validador(int opcion) {
        double validado = 0;
        Scanner sc = new Scanner(System.in);
        switch (opcion) {
            case 0: {
                while (!sc.hasNextInt()) {
                    System.out.print("¡Por favor introduce un número entero! ");
                    sc.next();
                }
                validado = sc.nextDouble();
            }
            break;
            case 1: {
                while (!sc.hasNextDouble()) {
                    System.out.print("¡Por favor introduce un número decimal! ");
                    sc.next();
                }
                validado = sc.nextDouble();
            }
            break;
        }
        return validado;
    }

    public static boolean validarFecha(int dia, int mes, int año) {
        boolean validado = true;
        if ((dia > 30 || dia < 1) || (mes > 12 || mes < 1) || año < 0) {
            validado = false;
        }
        return validado;
    }

    public static String nuevaFecha(int dia, int mes, int año) {
        String fechaNueva;
        dia = dia + 1;
        if (dia > 30) {
            dia = 1;
            mes = mes + 1;
            if (mes > 12) {
                mes = 1;
                año = año + 1;
            }
        }
        fechaNueva = String.format("La fecha de mañana será: %d/%d/%d", dia, mes, año);
        return fechaNueva;
    }

    public static void main(String[] args) {
        int dia, mes, año;
        boolean esCorrecta;
        Scanner sc = new Scanner(System.in);
        System.out.println("¡Vamos a calcular la fecha de mañana!");
        System.out.print("Introduce un día: ");
        dia = (int) validador(0);
        System.out.print("Introduce un mes: ");
        mes = (int) validador(0);
        System.out.print("Introduce un año: ");
        año = (int) validador(0);
        sc.close();
        esCorrecta = validarFecha(dia, mes, año);
        if (esCorrecta) {
            System.out.println(nuevaFecha(dia, mes, año));
        } else {
            System.out.println("La fecha ES INCORRECTA");
        }
    }
}

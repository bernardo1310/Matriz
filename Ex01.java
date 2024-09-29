import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int n;
        
        while (true) {
            System.out.print("Informe um número ímpar entre 3 e 11: ");
            n = read.nextInt();
            if (n >= 3 && n <= 11 && n % 2 != 0) {
                break;
            }
        }

        int[][] matriz = new int[n][n];
        int soma = 0, maior = Integer.MIN_VALUE, menor = Integer.MAX_VALUE;
        int contadorPares = 0, contadorImpares = 0;
        int somaDiagonalPrincipal = 0, somaDiagonalSecundaria = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("Informe o valor para a posição [%d][%d]: ", i, j);
                matriz[i][j] = read.nextInt();
                soma += matriz[i][j];
                if (matriz[i][j] > maior) {
                    maior = matriz[i][j];
                }
                if (matriz[i][j] < menor) {
                    menor = matriz[i][j];
                }
                if (matriz[i][j] % 2 == 0) {
                    contadorPares++;
                } else {
                    contadorImpares++;
                }
                if (i == j) {
                    somaDiagonalPrincipal += matriz[i][j];
                }
                if (i + j == n - 1) {
                    somaDiagonalSecundaria += matriz[i][j];
                }
            }
        }

        double media = (double) soma / (n * n);
        
        System.out.println("Soma dos elementos: " + soma);
        System.out.printf("Média dos elementos: %.2f%n", media);
        System.out.println("Maior valor: " + maior);
        System.out.println("Menor valor: " + menor);
        System.out.println("Contador de pares: " + contadorPares);
        System.out.println("Contador de ímpares: " + contadorImpares);
        System.out.println("Soma da diagonal principal: " + somaDiagonalPrincipal);
        System.out.println("Soma da diagonal secundária: " + somaDiagonalSecundaria);
        
        System.out.println("Matriz:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
        
        read.close();
    }
}

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int cartelas, i, j, num, acertos;
        int[][] loteria;
        boolean[] numeros;

        System.out.print("Quantas cartelas deseja preencher? ");
        cartelas = read.nextInt();
        loteria = new int[cartelas][6];

        for (i = 0; i < cartelas; i++) {
            numeros = new boolean[61];
            for (j = 0; j < 6; ) {
                num = (int) (Math.random() * 60) + 1;
                if (!numeros[num]) {
                    numeros[num] = true;
                    loteria[i][j] = num;
                    j++;
                }
            }
        }

        for (i = 0; i < cartelas; i++) {
            acertos = 0;
            System.out.print("Cartela " + (i + 1) + ": ");
            for (j = 0; j < 6; j++) {
                System.out.print(loteria[i][j] + " ");
            }
            for (j = 0; j < 6; j++) {
                if (loteria[i][j] == (int) (Math.random() * 60) + 1) {
                    acertos++;
                }
            }
            System.out.println(" - Acertos: " + acertos);
        }

        read.close();
    }
}

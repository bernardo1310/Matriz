import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.print("Informe o número de atletas: ");
        int N = read.nextInt();
        double[][] saltos = new double[N][5];
        double[] medias = new double[N];

        for (int i = 0; i < N; i++) {
            System.out.println("Atleta " + (i + 1) + ":");
            for (int j = 0; j < 5; j++) {
                System.out.print("Digite o salto " + (j + 1) + ": ");
                saltos[i][j] = read.nextDouble();
            }
            double soma = 0;
            double menorSalto = Double.MAX_VALUE;

            for (int j = 0; j < 5; j++) {
                soma += saltos[i][j];
                if (saltos[i][j] < menorSalto) {
                    menorSalto = saltos[i][j];
                }
            }
            medias[i] = (soma - menorSalto) / 4;
            System.out.printf("Média do atleta %d: %.2f%n", (i + 1), medias[i]);
        }

        int campeaoIndex = 0;
        int ultimoLugarIndex = 0;

        for (int i = 1; i < N; i++) {
            if (medias[i] > medias[campeaoIndex]) {
                campeaoIndex = i;
            }
            if (medias[i] < medias[ultimoLugarIndex]) {
                ultimoLugarIndex = i;
            }
        }

        System.out.println("\nSaltos e médias de cada atleta:");
        for (int i = 0; i < N; i++) {
            System.out.print("Atleta " + (i + 1) + " saltos: ");
            for (int j = 0; j < 5; j++) {
                System.out.printf("%.2f ", saltos[i][j]);
            }
            System.out.printf(" | Média: %.2f%n", medias[i]);
        }

        System.out.printf("Média do campeão (Atleta %d): %.2f%n", (campeaoIndex + 1), medias[campeaoIndex]);
        System.out.printf("Média do último lugar (Atleta %d): %.2f%n", (ultimoLugarIndex + 1), medias[ultimoLugarIndex]);

        read.close();
    }
}

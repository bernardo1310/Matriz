import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        double[][] precos = new double[5][5];
        double[] somaSupermercados = new double[5];
        double[] mediaProdutos = new double[5];
        
        for (int i = 0; i < 5; i++) {
            System.out.println("Supermercado " + (i + 1) + ":");
            for (int j = 0; j < 5; j++) {
                System.out.printf("Informe o preço do produto %d: ", (j + 1));
                precos[i][j] = read.nextDouble();
                somaSupermercados[i] += precos[i][j];
            }
        }
        
        System.out.println("\nPreços em cada supermercado:");
        for (int i = 0; i < 5; i++) {
            System.out.printf("Supermercado %d: ", (i + 1));
            for (int j = 0; j < 5; j++) {
                System.out.printf("R$ %.2f ", precos[i][j]);
                mediaProdutos[j] += precos[i][j];
            }
            System.out.println();
        }

        System.out.println("\nMédia de preço por produto:");
        for (int j = 0; j < 5; j++) {
            mediaProdutos[j] /= 5;
            System.out.printf("Produto %d: R$ %.2f%n", (j + 1), mediaProdutos[j]);
        }

        double menorPreco = Double.MAX_VALUE;
        double maiorPreco = Double.MIN_VALUE;
        int indexMenor = -1;
        int indexMaior = -1;

        for (int i = 0; i < 5; i++) {
            if (somaSupermercados[i] < menorPreco) {
                menorPreco = somaSupermercados[i];
                indexMenor = i;
            }
            if (somaSupermercados[i] > maiorPreco) {
                maiorPreco = somaSupermercados[i];
                indexMaior = i;
            }
        }

        System.out.printf("Valor total no supermercado mais barato (Supermercado %d): R$ %.2f%n", (indexMenor + 1), menorPreco);
        System.out.printf("Valor total no supermercado mais caro (Supermercado %d): R$ %.2f%n", (indexMaior + 1), maiorPreco);

        read.close();
    }
}

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.print("Informe o número de alunos: ");
        int N = read.nextInt();
        read.nextLine();

        String[] nomes = new String[N];
        double[][] notas = new double[N][2];
        double[] medias = new double[N];
        double somaGeral = 0;
        
        for (int i = 0; i < N; i++) {
            System.out.print("Digite o nome do aluno " + (i + 1) + ": ");
            nomes[i] = read.nextLine();
            System.out.print("Digite a nota 1: ");
            notas[i][0] = read.nextDouble();
            System.out.print("Digite a nota 2: ");
            notas[i][1] = read.nextDouble();
            read.nextLine();
            
            medias[i] = (notas[i][0] + notas[i][1]) / 2;
            somaGeral += medias[i];
        }
        
        double mediaGeral = somaGeral / N;
        double maiorNota = Double.MIN_VALUE;
        double menorNota = Double.MAX_VALUE;
        double maiorMedia = Double.MIN_VALUE;
        double menorMedia = Double.MAX_VALUE;
        String alunoMaiorNota = "";
        String alunoMenorNota = "";
        String alunoMaiorMedia = "";
        String alunoMenorMedia = "";

        for (int i = 0; i < N; i++) {
            if (notas[i][0] > maiorNota) {
                maiorNota = notas[i][0];
                alunoMaiorNota = nomes[i];
            }
            if (notas[i][0] < menorNota) {
                menorNota = notas[i][0];
                alunoMenorNota = nomes[i];
            }
            if (notas[i][1] > maiorNota) {
                maiorNota = notas[i][1];
                alunoMaiorNota = nomes[i];
            }
            if (notas[i][1] < menorNota) {
                menorNota = notas[i][1];
                alunoMenorNota = nomes[i];
            }
            if (medias[i] > maiorMedia) {
                maiorMedia = medias[i];
                alunoMaiorMedia = nomes[i];
            }
            if (medias[i] < menorMedia) {
                menorMedia = medias[i];
                alunoMenorMedia = nomes[i];
            }
        }

        System.out.println("\nNome e Notas de cada aluno:");
        for (int i = 0; i < N; i++) {
            System.out.printf("%s: Nota 1 = %.2f, Nota 2 = %.2f, Média = %.2f%n", nomes[i], notas[i][0], notas[i][1], medias[i]);
        }

        System.out.printf("Maior Nota: %.2f (Aluno: %s)%n", maiorNota, alunoMaiorNota);
        System.out.printf("Menor Nota: %.2f (Aluno: %s)%n", menorNota, alunoMenorNota);
        System.out.printf("Maior Média: %.2f (Aluno: %s)%n", maiorMedia, alunoMaiorMedia);
        System.out.printf("Menor Média: %.2f (Aluno: %s)%n", menorMedia, alunoMenorMedia);
        System.out.printf("Média Geral da Turma: %.2f%n", mediaGeral);

        System.out.println("Alunos acima da média geral:");
        for (int i = 0; i < N; i++) {
            if (medias[i] > mediaGeral) {
                System.out.println(nomes[i]);
            }
        }

        System.out.println("Alunos abaixo da média geral:");
        for (int i = 0; i < N; i++) {
            if (medias[i] < mediaGeral) {
                System.out.println(nomes[i]);
            }
        }

        read.close();
    }
}

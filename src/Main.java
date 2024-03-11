import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);


        //1 Escrever um código que receba um número inteiro e informe se ele é um número primo
        System.out.println("Digite um número inteiro: ");
        int n = sc.nextInt();

        if (n % 2 == 0) {
            System.out.println("É primo!");
        } else {
            System.out.println("Não é primo!");
        }

        //2 Escrever um código que sorteie um número randômico de 0 a 1000, peça um número inteiro
        //neste intervalo, se o usuário errar, informar se o valor sorteado é maior ou menor que o
        //informado e solicitar outro número do usuário até que ele acerte o número. Quando acertar,
        //informar a quantidade de palpites que ele informou até acertar.

        Random random = new Random();
        int randomNum = random.nextInt(1000);
        int palpite;
        int numTentativas = 0;

        do {
            System.out.println("Digite um número inteiro: ");
            palpite = sc.nextInt();
            numTentativas++;

            if (palpite < randomNum) {
                System.out.println("Seu palpite é menor que o número sorteado.");
            } else if (palpite > randomNum) {
                System.out.println("Seu palpite é maior que o número sorteado.");
            } else {
                System.out.println("Parabéns você acertou com " + numTentativas + " tentativas.");
            }

        } while (palpite != randomNum);


        //3Escreva um código que receba um nome completo em forma de String e mostre as iniciais
        //do nome.
        //Ex.:
        //Entrada: Demetrius de Castro do Amaral
        //Saída: D.C.A
        System.out.println("Digite seu nome completo: ");
        String nome = sc.nextLine();
        String[] array = nome.split(" ");
        StringBuilder iniciais = new StringBuilder();

        for (String s : array) {
            char c = s.charAt(0);
            iniciais.append(c).append(". ");
        }

        String upper = String.valueOf(iniciais);
        System.out.println(upper.toUpperCase());

        //4Escreva um código que receba uma String qualquer e a imprima de forma invertida.
        //Ex.:
        //Entrada: estude java
        //Saída: avaj edutse

        System.out.println("Digite uma frase ou palavra: ");
        String string = sc.nextLine();
        StringBuilder inversao = new StringBuilder(string);
        inversao.reverse();
        System.out.println("Seu input invertido: " + inversao);

        //5 Escreva um código que receba uma String simples (apenas uma palavra) e monte um array
        //com os valores respectivos a cada letra da palavra, os organize em ordem crescente, imprima
        //esse array e a palavra na nova ordem.
        //Ex.:
        //Entrada: estudar
        //Array: {5, 19, 20, 21, 4, 1, 18}
        //Array ordenado: {1, 4, 5, 18, 19, 20, 21}
        //Saída: aderstu.

        System.out.print("Digite uma palavra: ");
        String palavra = sc.next();
        Integer[] valores = new Integer[palavra.length()];

        for (int i = 0; i < palavra.length(); i++) {
            valores[i] = palavra.charAt(i) - 'a' + 1;
        }

        System.out.println("Array: " + Arrays.toString(valores));

        Arrays.sort(valores, Comparator.comparingInt(valor -> valor));
        System.out.println("Array ordenado: " + Arrays.toString(valores));

        StringBuilder palavraOrdenada = new StringBuilder();
        for (int valor : valores) {
            palavraOrdenada.append((char) (valor + 'a' - 1));
        }
        System.out.println("Saída: " + palavraOrdenada.toString());

        //6Escreva um código que tenha uma classe chamada Aluno, que receba três notas do tipo inteiro
        //e o nome do aluno do tipo String.
        //Pergunte ao usuário o nome do aluno e as três notas, continue pedindo alunos e notas até que o
        //usuário digite “sair” como nome do aluno.
        //Quando o usuário digitar “sair”, imprima a nota e média das notas de todos os alunos.
        //Imprimir a média geral da turma. Imprimir a quantidade de alunos reprovados e aprovado (média >= 6 aprovado).
        //Imprimir os nomes dos alunos aprovados
        //Imprimir os nomes dos alunos reprovados

        List<Aluno> alunos = new ArrayList<>();
        char sair;
        do {

            System.out.println("Digite o nome do aluno: ");
            String name = sc.next();
            System.out.println("Digite sua nota 1: ");
            double nota1 = sc.nextDouble();
            System.out.println("Digite sua nota 2: ");
            double nota2 = sc.nextDouble();
            System.out.println("Digite sua nota 3: ");
            double nota3 = sc.nextDouble();
            Aluno aluno = new Aluno(name, nota1, nota2, nota3);
            alunos.add(aluno);

            System.out.println("Deseja continuar adicionando alunos?(s/n) ");
            sair = sc.next().charAt(0);

        }while (sair != 'n');

            int aprovados = 0;
            int reprovados = 0;
            double somaMedias = 0;
            System.out.println("Resultados dos alunos:");

            for (Aluno a : alunos) {
                System.out.printf(a.getNome() + " - Média: %.2f ", a.media());
                somaMedias += a.media();

                if (a.media() >= 6) {
                    aprovados++;
                    System.out.println("Aluno aprovado.");
                } else {
                    reprovados++;
                    System.out.println("Aluno reprovado.");
                }
            }

            System.out.println("Alunos aprovados: " + aprovados);
            System.out.println("Alunos reprovados: " + reprovados);
            System.out.printf("Média geral da turma %.2f: ", (somaMedias / alunos.size()));

        sc.close();
    }
}

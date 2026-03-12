/*Faça um programa que gere um array de 1 bilhão de números inteiros aleatórios e faça as seguintes tarefas:

Some todos os valores de forma sequencial e meça o tempo de execução;
Some todos os valores de forma concorrente com 10 threads e meça o tempo de execução;
Some todos os valores de forma concorrente com 100 threads e meça o tempo de execução.
Responda as seguintes perguntas:
Qual foi o speedup1 obtido?
Teve algum caso que o speedup foi negativo?
Repita os testes acima usando Threads virtuais.
Houve diferenças entre Threads de plataforma e Threads virtuais? Se houve, quais foram e explique o porquê das diferenças*/

import java.util.Random;

public class Exercicio03 {
    public static void main(String[] args) throws Exception {
        short[] numeros = new short[1_000_000_000];
        Random r = new Random();
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (short) r.nextInt(1, Short.MAX_VALUE);
        }
//Some todos os valores de forma sequencial e meça o tempo de execução;  
        long te = System.currentTimeMillis();
        long soma = 0;
        for (int i = 0; i < numeros.length; i++) {
            soma += numeros[i];
        }
        System.out.printf("Total Sequencial: %d\n", soma);
        System.out.printf("Tempo: %d milisegundos\n\n", System.currentTimeMillis() - te);
    }

}
//Some todos os valores de forma concorrente com 10 threads e meça o tempo de execução;
        


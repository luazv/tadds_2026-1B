/*Faça um programa que gere um array de 1 bilhão de números inteiros aleatórios e faça as seguintes tarefas:*/


import java.util.Random;

public class Exercicio03 {

    public static void main(String[] args) throws Exception {

        short[] numeros = new short[1_000_000_000];
        Random r = new Random();
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (short) r.nextInt(1, Short.MAX_VALUE);
        }

        // Some todos os valores de forma sequencial e meça o tempo de execução;
        long te = System.currentTimeMillis();
        long soma = 0;
        for (int i = 0; i < numeros.length; i++) {
            soma += numeros[i];
        }
        System.out.printf("Total Sequencial: %d\n", soma);
        System.out.printf("Tempo: %d ms\n\n", System.currentTimeMillis() - te);

        // Some todos os valores de forma concorrente com 10 threads e meça o tempo de execução;
        te = System.currentTimeMillis();
        int faixa = numeros.length / 10;
        Soma[] somas = new Soma[10];
        Thread[] threads = new Thread[10];
        int ini = 0;
        for (int i = 0; i < 10; i++) {
            somas[i] = new Soma(numeros, ini, faixa);
            threads[i] = Thread.ofPlatform().start(somas[i]);
            ini += faixa;
        }
        soma = 0;
        for (int i = 0; i < 10; i++) {
            threads[i].join();
            soma += somas[i].getSoma();
        }
        System.out.printf("Total 10 Threads Plat: %d\n", soma);
        System.out.printf("Tempo: %d ms\n\n", System.currentTimeMillis() - te);

        // Some todos os valores de forma concorrente com 100 threads e meça o tempo de execução.
        te = System.currentTimeMillis();
        faixa = numeros.length / 100;
        somas = new Soma[100];
        threads = new Thread[100];
        ini = 0;
        for (int i = 0; i < 100; i++) {
            somas[i] = new Soma(numeros, ini, faixa);
            threads[i] = Thread.ofPlatform().start(somas[i]);
            ini += faixa;
        }
        soma = 0;
        for (int i = 0; i < 100; i++) {
            threads[i].join();
            soma += somas[i].getSoma();
        }
        System.out.printf("Total 100 Threads Plat: %d\n", soma);
        System.out.printf("Tempo: %d ms\n\n", System.currentTimeMillis() - te);

        // Threads virtuais (repetição)
        te = System.currentTimeMillis();
        faixa = numeros.length / 10;
        somas = new Soma[10];
        threads = new Thread[10];
        ini = 0;
        for (int i = 0; i < 10; i++) {
            somas[i] = new Soma(numeros, ini, faixa);
            threads[i] = Thread.ofVirtual().start(somas[i]);
            ini += faixa;
        }
        soma = 0;
        for (int i = 0; i < 10; i++) {
            threads[i].join();
            soma += somas[i].getSoma();
        }
        System.out.printf("Total 10 Threads Virt: %d\n", soma);
        System.out.printf("Tempo: %d ms\n\n", System.currentTimeMillis() - te);

        // 100 Threads virtuais
        te = System.currentTimeMillis();
        faixa = numeros.length / 100;
        somas = new Soma[100];
        threads = new Thread[100];
        ini = 0;
        for (int i = 0; i < 100; i++) {
            somas[i] = new Soma(numeros, ini, faixa);
            threads[i] = Thread.ofVirtual().start(somas[i]);
            ini += faixa;
        }
        soma = 0;
        for (int i = 0; i < 100; i++) {
            threads[i].join();
            soma += somas[i].getSoma();
        }
        System.out.printf("Total 100 Threads Virt: %d\n", soma);
        System.out.printf("Tempo: %d ms\n\n", System.currentTimeMillis() - te);
    }
}
/*Responda as seguintes perguntas:
Qual foi o speedup1 obtido?
Teve algum caso que o speedup foi negativo?
Repita os testes acima usando Threads virtuais.
Houve diferenças entre Threads de plataforma e Threads virtuais? Se houve, quais foram e explique o porquê das diferenças*/
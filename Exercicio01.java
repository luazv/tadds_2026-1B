//Faça um programa concorrente que crie 10 threads que exibam o nome da thread e a hora atual.
public class Exercicio01 extends Thread {
    public void run(){
        System.out.printf("%s: %tT\n", getName(), new Date());
    }

    public static void main(String[] args) {
        Exercicio01[] exercs = new Exercicio01[10];
        for (int i = 0; i < 10; i++) {
            exercs[i] = new Exercicio01();
        }
        for (int i = 0; i < 10; i++) {
            exercs[i].start();
        }
    }
}
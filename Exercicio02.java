//Faça um programa concorrente que crie 10 threads que exibam o nome da thread e um contador que varia de 1 a 10.
// Execute várias vezes e observe as variações na saída. Os valores são sempre impressos na mesma ordem?
public class Exercicio02 implements Runnable{
    public void run(){
        for (int i= 1; i <= 10; i++){
            System.out.println(Thread.currentThread().threadId()+ "" + i);
        }
    }

    public static void main(String[] args){
        Thread[] ts = new Thread[10];
        Exercicio02 e1 = new Exercicio02();
        for (int i=0; i <10; i++){
            ts[i] = Thread.startVirtual(e1)
        }
    }
}

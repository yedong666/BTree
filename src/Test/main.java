package Test;

public class main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Mythread(), "Tom");
        Thread t2 = new Thread((new Mythread()), "Jack");
        t1.start();
        t2.start();
    }

}

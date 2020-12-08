package Syncronization;

public class Device extends Thread {
    private String Name, Type;

    public Device(String n, String t) {
        Name = n;
        Type = t;
    }

    public void run() {
        int random_int = (int) (Math.random() * (10 - 0 + 1) + 0);
        random_int *= 1000;
        try {
            Thread.sleep(random_int);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    String getname() {
        return Name;
    }

    String getType() {
        return Type;
    }

}

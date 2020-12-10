package Syncronization;

import java.util.ArrayList;

public class Router {

    private Device connections[];
    private Semaphore spaces, elements;
    private int inptr = 0, outptr = 0;
    private int numOfConnections;

    public Router(int num) {
        numOfConnections = num;
        connections = new Device[num];
        spaces = new Semaphore(num);
        elements = new Semaphore(0);
    }

    public void addConnection(Device value) {

        spaces.P();
        connections[inptr] = null;
        connections[inptr] = value;
        System.out.println("Connection " + (inptr + 1) + ": " + value.getname() + " occupied");
        inptr = (inptr + 1) % numOfConnections;
        elements.V();

    }

    public void terminateConnection() {
        for (int i = 0; i < numOfConnections; i++) {
            if (!connections[i].isAlive()) {
                Device value;
                elements.P();
                value = connections[outptr];
                System.out.println("Connection " + (outptr + 1) + ": " + value.getname() + " logged out");
                outptr = (outptr + 1) % numOfConnections;
                spaces.V();

            }
        }

    }

    public void performActivity() {
        for (int i = 0; i < numOfConnections; i++) {
            if (connections[i].isAlive()) {
                terminateConnection();
            }
            else if (!connections[i].isInterrupted()) {

                    connections[i].start();
                    System.out.println("Connection " + (i + 1) + ": " + connections[i].getname() + " performs online activity");


            }
        }

    }

    int getSpace() {
        return spaces.value;
    }


}

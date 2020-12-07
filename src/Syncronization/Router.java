package Syncronization;

import java.util.ArrayList;

public class Router {

    private Object connections[];
    private Semaphore spaces,elements;
    private int inptr=0,outptr=0;
    private int numOfConnections;
    public Router(int num){
        numOfConnections=num;
        connections=new Object[num];
        spaces=new Semaphore(num);
        elements=new Semaphore(0);
    }
    public void addConnection(Object value){

    }
    public void terminateConnection(){
        System.out.println();
    }
    public void performOnlineActivity(){

    }
}

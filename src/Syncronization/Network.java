package Syncronization;

import java.util.ArrayList;
import java.util.Scanner;

public class Network {
    public static void main (String args[]){
        int N,TC;
        Scanner input=new Scanner(System.in);
        Scanner tc=new Scanner(System.in);
        System.out.println("What is the number of WI-FI connections?");
        N=input.nextInt();
        Router router=new Router(N);
        System.out.println("What is the number of devices Clients want to connect?");
        TC=input.nextInt();
        String name,type;
        ArrayList<Device>devices=new ArrayList<Device>();
        for(int i=0;i<TC;i++){
            System.out.println("Enter Device "+ (i+1)+ " Name:");
            name= tc.nextLine();
            System.out.println("Enter Device "+ (i+1)+ " Type:");
            type=tc.nextLine();
            devices.add(new Device(name,type));
        }



    }
}

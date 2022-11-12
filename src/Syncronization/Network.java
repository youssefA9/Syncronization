package Syncronization;

import java.util.ArrayList;
import java.util.Scanner;

public class Network {
    public static void main(String args[]) {
        int N, Total_Devices;
        Scanner input = new Scanner(System.in);
        Scanner tc = new Scanner(System.in);
        System.out.println("What is the number of WI-FI connections?");
        N = input.nextInt();
        Router router = new Router(N);
        System.out.println("What is the number of devices Clients want to connect?");
        Total_Devices = input.nextInt();
        String name, type;
        ArrayList<Device> devices = new ArrayList<Device>();
        for (int i = 0; i < Total_Devices; i++) {
            System.out.println("Enter Device " + (i + 1) + " Name:");
            name = tc.nextLine();
            System.out.println("Enter Device " + (i + 1) + " Type:");
            type = tc.nextLine();
            devices.add(new Device(name, type));
        }
        for (int i = 0; i < devices.size(); i++) {
            if (router.getSpace() == 0) {
                router.performActivity();
                System.out.println("(" + devices.get(i).getname() + ")" + "(" + devices.get(i).getType() + ")" + " has arrived and Waiting");
                while (router.getSpace() < 1) {
                    router.terminateConnection();
                }
            } else {
                System.out.println("(" + devices.get(i).getname() + ")" + "(" + devices.get(i).getType() + ")" + " has arrived");
            }

            router.addConnection(devices.get(i));

            if (i + 1 == devices.size()) {
                router.performActivity();
                while (router.getSpace() < N) {
                    router.terminateConnection();
                }
            }

        }

    }
}

package Unit9;

import Midterm.TeamMember;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeMap;

public class Main {

    public static void main(String [] args) {


        System.out.println("Welcome to the Collections Sorting System! Loading file data now...");

        System.out.println("------------------------------------------------------------------------------------------------------------");


        LinkedList<Employee> employeeLinkedList = new LinkedList<>();
        ArrayList<Product> productArrayList = new ArrayList<>();
        TreeMap<String, Client> clientTreeMap = new TreeMap<>();

        ObjectInputStream employeeInputStream = null;
        ObjectInputStream productInputStream = null;
        ObjectInputStream clientInputStream = null;

            try{

                employeeInputStream = new ObjectInputStream(
                    new BufferedInputStream(new FileInputStream("employeeFile.txt")));

                while (true) {
                    try {
                        Employee tempEmployee = (Employee) employeeInputStream.readObject();
                        employeeLinkedList.add(tempEmployee);


                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    }
                }
            } catch (EOFException eofException) {
                for(int i =0; i< employeeLinkedList.size(); i++){
                    System.out.println(employeeLinkedList.get(i).toString());
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            System.out.println("------------------------------------------------------------------------------------------------------------");

            try{
                productInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream("productFile.txt")));

                while(true){
                    try{
                        Product tempProduct = (Product) productInputStream.readObject();
                        productArrayList.add(tempProduct);

                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }


            } catch (EOFException error){
                for(int i =0; i< productArrayList.size(); i++){
                    System.out.println(productArrayList.get(i).toString());
                }

            } catch (IOException error){
                error.printStackTrace();
            }

        System.out.println("------------------------------------------------------------------------------------------------------------");


        try{
            clientInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream("clientFile.txt")));

            while(true){
                try{
                    Client tempClient = (Client) clientInputStream.readObject();
                    clientTreeMap.put(tempClient.getName(), tempClient);

                    for(int i = 0; i < 1; i++){
                        System.out.println(clientTreeMap.get(tempClient.getName()).toString());
                    }

                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }


        } catch (EOFException error){
            System.out.println("------------------------------------------------------------------------------------------------------------");
            System.out.println("Load completed!");
        } catch (IOException error){
            error.printStackTrace();
        }


    }
    }




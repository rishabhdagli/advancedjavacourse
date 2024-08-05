package Unit9;/*
Assignment 9 Solution
Class for a property address
*/
import java.io.*;

public class Address implements Serializable
{
   //Data members
   private String street;
   private String city;
   private String state;
   private String zip;
   
   //Default Constructor
   public Address()
   {
      street = "";
      city = "";
      state = "";
      zip = "";
   }
   
   //Parametrized constructor
   public Address(String str, String c, String st, String z)
   {
      street = str;
      city = c;
      state = st;
      zip = z;
   }
   
   //Get address in US address format
   public String toString()
   {
      return street + " " + city + ", " + state + " " + zip;
   }
}
package Unit9;/*
Assignment 9 Solution - Date class

*/
import java.io.*;
public class Date implements Serializable
{
  //Data members
  private int month;
  private int day;
  private int year;
  private String stringDate;
  
  //Default constructor
  public Date() { month = 0; day = 0; year = 0; }
  
  //Parameterized constructor
  public Date( int m, int d, int y )
  {
    month = m; day = d; year = y;
  }
  
  //Returns date as string
  public String getDateString()
  {
    return ( (""+month).length() == 1 ? "0"+month : ""+month) + "/" + ( (""+day).length() == 1 ? "0"+day : ""+day) + "/" + year;
  }
  
  //Set a string date
  public void setDateString(String dt)
  {
    stringDate = dt;
  }
  
  //toString() method
  public String toString()
  {
    return ( (""+month).length() == 1 ? "0"+month : ""+month) + "/" + ( (""+day).length() == 1 ? "0"+day : ""+day) + "/" + year;
  }
}
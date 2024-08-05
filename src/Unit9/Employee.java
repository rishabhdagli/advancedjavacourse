package Unit9;/*
Assignment 9 Solution 
Employee class
*/

import java.io.*;

public class Employee implements Serializable
{
   //Instance variables
   protected String jobTitle;
   protected String fullName;
   protected Date hireDate;
   
   //Default constructor
   public Employee()
   {
       jobTitle = "";
       fullName = "";
       hireDate = null;
   }
   
   //3 Argument constructor
   public Employee(String fName, String jTitle, Date hDate)
   {
      jobTitle = jTitle;
      fullName = fName;
      hireDate = hDate;
   }
   
   // Getters and setters
   public String getJobTitle()
   {
      return jobTitle;
   }
   
   public void setJobTitle(String jTitle)
   {
      jobTitle = jTitle;
   }
   
   public String getFullName()
   {
      return fullName;
   }
   
   public void setFullName(String fn)
   {
      fullName = fn;
   }
   
   public String getHireDate()
   {
      return hireDate.getDateString();
   }
   
   //toString method
   public String toString()
   {
       return fullName + " - " +
       			jobTitle + " - " +
       			"Hire Date " + getHireDate();
   }
   
}
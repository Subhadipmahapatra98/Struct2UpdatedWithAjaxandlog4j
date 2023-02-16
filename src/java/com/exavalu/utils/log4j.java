package com.exavalu.utils;

import org.apache.log4j.Logger;  
  
import java.io.*;  
import java.sql.SQLException;  
  
public class log4j{  
  
   /* Get the class name to be printed on */  
   static Logger log = Logger.getLogger(log4j.class.getName());
   public static void main(String[] args)throws IOException,SQLException{  
      log.debug("Hello this is a error message");  
      log.info("Hello this is an info message");  
   }  
} 
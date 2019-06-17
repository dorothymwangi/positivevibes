package org.launchcode.positivevibes.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostService {
        public static void main(String[] args) {
            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();

                //serverhost = localhost, port=3308, username=positive-vibes-data, password=vibes
                Connection cn= DriverManager.getConnection("jdbc:mysql://localhost:3308/positive-vibes-data","password=vibes","vibes");
                Statement smt=cn.createStatement();

                //query to display all records from table employee
                String q="Select * from post";

                //to execute query
                ResultSet rs=smt.executeQuery(q);

                //to print the resultset on console
                if(rs.next()){
                    do{
                        System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4));
                    }while(rs.next());
                }
                else{
                    System.out.println("Record Not Found...");
                }
                cn.close();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DBconnection.DBconnection;
import Model.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sachithra
 */
public class CustomerController {
    
   public static ArrayList<Member> getallCustomer() throws ClassNotFoundException, SQLException{
       String sql="select *from member";
            Connection connection=DBconnection.getInstance().getConnection();
             PreparedStatement pstm = connection.prepareStatement(sql);
             ResultSet rst=pstm.executeQuery(sql);
             ArrayList<Member> allmembers=new ArrayList<>();
             while(rst.next()){
                 Member member=new Member();
                 member.setId(rst.getString(1));
                 member.setName(rst.getString(2));
                 member.setHome(rst.getString(3));
                 member.setPhone(rst.getInt(4));
                 
                 allmembers.add(member);
             }
             return allmembers;
   }
}

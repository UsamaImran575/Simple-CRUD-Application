/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static MyFrame.Insertion.Insert;
  
class Search extends JFrame implements ActionListener {
  
    // Components of the Form
    private Container c;
    private JLabel title;
    
    
    private JLabel name;
    private JTextField tname;
  
    private JLabel cnic;
    private JTextField tcnic;

    private JButton sub; 
    static  private JTextArea textout;
    
   
  
  
   
    public Search()
    {
        setTitle("Search Form");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
  
        c = getContentPane();
        c.setLayout(null);
  
        title = new JLabel("Registration Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);
  
        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(100, 100);
        c.add(name);
  
        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(200, 100);
        c.add(tname);
        
        
        cnic= new JLabel("CNIC");
       cnic.setFont(new Font("Arial", Font.PLAIN, 20));
        cnic.setSize(100, 20);
       cnic.setLocation(100, 150);
        c.add(cnic);
  
        tcnic = new JTextField();
        tcnic.setFont(new Font("Arial", Font.PLAIN, 15));
        tcnic.setSize(190, 20);
        tcnic.setLocation(200, 150);
        c.add(tcnic);
  
      
  
  
        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 450);
        sub.addActionListener(this);
        c.add(sub);
  

  
        textout = new JTextArea();
        textout.setFont(new Font("Arial", Font.PLAIN, 15));
        textout.setSize(300, 400);
        textout.setLocation(500, 100);
        textout.setLineWrap(true);
        textout.setEditable(false);
        c.add(textout);
  
      
  
        setVisible(true);
    }
  
     public static void getName(String CNIC,String name) throws SQLException, ClassNotFoundException {
       
         
           Connection con= ConnectionProvider.getConnection();

           CallableStatement cstmt = null;
try 
{  
           String sq2=    "select* FROM AddressBook WHERE CNIC=? or name=?";

                       // String sql = "update Records set Name = ? where PersonID = ?";
                      
                         PreparedStatement pstmt=con.prepareStatement(sq2);
                        pstmt.setString(1,CNIC );
                         pstmt.setString(2,name);
                       
                        
                        

   ResultSet rs;
  float i=0;
   rs= pstmt.executeQuery();
       String ss=null;
       
       while(rs.next()) 
       {
        textout.setText("CNIC"+" : "+rs.getString(1)+"\n"+
               "Name"+" : "+rs.getString(2)+"\n"+
               "Address"+" : "+ rs.getString(3)+ "\n"+ 
               "Gender"+" : "+rs.getString(4)+"\n"+
               "Phone"+" : "+rs.getString(5));
        } 
       
       if(rs.next()==true)
       {
            textout.setText(rs.getString(1)+" "+ rs.getString(2)+" "
        + rs.getString(3)+" "+ rs.getString(4)+" "+rs.getString(5)); 
       }
}          
    catch (SQLException e) {
    e.printStackTrace();
}
     }
  
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == sub) {
           
            
           try {
               
                getName(tcnic.getText(),tname.getText());
            } 
             catch (ClassNotFoundException ex) {
                Logger.getLogger(Insertion.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
  
       
    }
}
  
// Driver Code

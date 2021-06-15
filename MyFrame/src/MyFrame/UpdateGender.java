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
import java.util.Scanner;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
  
class UpdateGender  extends JFrame implements ActionListener {
  
    // Components of the Form
    private Container c;
    private JLabel title;
    
    
    private JLabel name;
    static private JTextField textname;
  
    private JLabel cnic;
    static private JTextField textcnic;

    private JButton sub; 

    
   
  
  
   
    public UpdateGender()
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
  
        name = new JLabel("Gender");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(100, 150);
        c.add(name);
  
        textname = new JTextField();
        textname.setFont(new Font("Arial", Font.PLAIN, 15));
        textname.setSize(190, 20);
        textname.setLocation(200, 150);
        c.add(textname);
        
        
        cnic= new JLabel("CNIC");
       cnic.setFont(new Font("Arial", Font.PLAIN, 20));
        cnic.setSize(100, 20);
       cnic.setLocation(100, 100);
        c.add(cnic);
  
        textcnic = new JTextField();
        textcnic.setFont(new Font("Arial", Font.PLAIN, 15));
        textcnic.setSize(190, 20);
        textcnic.setLocation(200, 100);
        c.add(textcnic);
  
      
  
  
        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 450);
        sub.addActionListener(this);
        c.add(sub);
  

  
    
      
  
        setVisible(true);
    }
  
      public static void UpdateName() throws ClassNotFoundException{
           
          
                 
                   
        
      Connection con= ConnectionProvider.getConnection();
            int r=0;
             try
                {   
                       
                        String sql = "update AddressBook set gender = ? where CNIC = ?";
                      
                         PreparedStatement pstmt=con.prepareStatement(sql);
                         pstmt.setString(2,textcnic.getText() );
                         pstmt.setString(1,textname.getText());
                         r=pstmt.executeUpdate();
                        
            
                }
                         catch(SQLException e)
                {
                          e.printStackTrace();
                }
}
  
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == sub) {
           
            
           try {
               
              UpdateName();
               JOptionPane.showMessageDialog( null, "Gender Updated" );
              
            } 
             catch (ClassNotFoundException ex) {
                Logger.getLogger(Insertion.class.getName()).log(Level.SEVERE, null, ex);
            } 
            }
            
        }
  
       
    }

  
// Driver Code


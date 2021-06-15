/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
  
class Deletion
    extends JFrame
    implements ActionListener {
  
  
    private Container c;
    
    private JLabel searchTitle;
    
    private JLabel name;
    private JTextField textName;
    
    private JLabel mobileNum;
    private JTextField textMobNo;
    
    
    private JLabel gender;
    private JTextField textGender;
  
 
    private JLabel CNIC;
    private JTextField textCNIC;
      
    private JLabel address ;
    private JTextArea textAddress;

    private JButton sub;
    private JButton reset;

    private JLabel res;
    private JTextArea resadd;
  
   
    // constructor, to initialize the components
    // with default values.
    public Deletion()
    {
        setTitle("Delete Form");
        setBounds(300, 90, 600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
  
        c = getContentPane();
        c.setLayout(null);
  
        searchTitle = new JLabel("Delete Form");
        searchTitle.setFont(new Font("Arial", Font.PLAIN, 30));
        searchTitle.setSize(300, 30);
        searchTitle.setLocation(300, 30);
        c.add(searchTitle);
  
       
  
        CNIC = new JLabel("CNIC");
        CNIC.setFont(new Font("Arial", Font.PLAIN, 20));
        CNIC.setSize(200, 20);
        CNIC.setLocation(100, 250);
        c.add(CNIC);
  
        
        textCNIC = new JTextField();
        textCNIC.setFont(new Font("Arial", Font.PLAIN, 15));
        textCNIC.setSize(200, 20);
        textCNIC.setLocation(200, 250);
        c.add(textCNIC);
  
      
  
     
   
        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 450);
        sub.addActionListener(this);
        c.add(sub);
  
       
  
       
  
        setVisible(true);
    }
    
    
 public static void Delete(String CNIC) throws ClassNotFoundException{
        
      Connection con= ConnectionProvider.getConnection();
            int r=0;
             try
                {   // String query="Insert into AddressBook(CNIC,name,addres,gender,phone) values (?,?,?,?,?)";                        
                      //  PreparedStatement pstmt=con.prepareStatement(query);
                        
                   String sq2=    "DELETE FROM AddressBook WHERE CNIC=?";
                       // String sql = "update Records set Name = ? where PersonID = ?";
                      
                         PreparedStatement pstmt=con.prepareStatement(sq2);
                        pstmt.setString(1,CNIC );
                        //pstmt.setString(1,name);
                       
                        
                        r=pstmt.executeUpdate();
                        
            
                }
                         catch(SQLException e)
                {
                          e.printStackTrace();
                }
    }
      
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == sub) {
            
           
         
            
            
             try {
                 
                Delete(textCNIC.getText());
                JOptionPane.showMessageDialog( null, "Record Deleted" );
                 
            } 
             catch (ClassNotFoundException ex) {
                Logger.getLogger(Insertion.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
  
      else if (e.getSource() == reset) {
            String def = "";
            textName.setText(def);
            textAddress.setText(def);
            textMobNo.setText(def);
            res.setText(def);
            resadd.setText(def);
        }
    }
}
    
  
              

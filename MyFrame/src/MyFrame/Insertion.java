/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyFrame;

/**
 *
 * @author Usama Sheikh
 */
// Java program to implement
// a Simple Registration Form
// using Java Swing
  
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
  
class Insertion
    extends JFrame
    implements ActionListener {
  
    // Components of the Form
    private Container c;
    
    private JLabel insertionTtitle;
    
      private JLabel CNIC;
      private JTextField textCNIC;
    
    private JLabel name;
    private JTextField textName;
    
    
    private JLabel mobNumber;
    private JTextField textmobno;
    
    
    private JLabel gender;
    private JTextField textGender;
  

      
    private JLabel address;
    private JTextArea textAddress;

    private JButton sub;
    private JButton reset;

    private JLabel res;
    private JTextArea resadd;
  
   
    // constructor, to initialize the components
    // with default values.
    public Insertion()
    {
        setTitle("Registration Form");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
  
        c = getContentPane();
        c.setLayout(null);
  
        insertionTtitle = new JLabel("Insertion Form");
        insertionTtitle.setFont(new Font("Arial", Font.PLAIN, 30));
        insertionTtitle.setSize(300, 30);
        insertionTtitle.setLocation(300, 30);
        c.add(insertionTtitle);
  
        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(200, 100);
        c.add(name);
  
        textName = new JTextField();
        textName.setFont(new Font("Arial", Font.PLAIN, 15));
        textName.setSize(150, 20);
        textName.setLocation(400, 100);
        c.add(textName);
  
        mobNumber = new JLabel("Mobile");
        mobNumber.setFont(new Font("Arial", Font.PLAIN, 20));
        mobNumber.setSize(100, 20);
        mobNumber.setLocation(200, 150);
        c.add(mobNumber);
  
        textmobno = new JTextField();
        textmobno.setFont(new Font("Arial", Font.PLAIN, 15));
        textmobno.setSize(150, 20);
        textmobno.setLocation(400, 150);
        c.add(textmobno);
  
        gender = new JLabel("Gender");
        gender.setFont(new Font("Arial", Font.PLAIN, 20));
        gender.setSize(100, 20);
        gender.setLocation(200, 200);
        c.add(gender);
  
        textGender = new JTextField();
         textGender.setFont(new Font("Arial", Font.PLAIN, 15));
         textGender.setSize(150, 20);
        textGender.setLocation(400, 200);
        c.add(textGender);
    
  
        CNIC = new JLabel("CNIC");
        CNIC.setFont(new Font("Arial", Font.PLAIN, 20));
        CNIC.setSize(100, 20);
        CNIC.setLocation(200, 250);
        c.add(CNIC);
  
        textCNIC = new JTextField();
        textCNIC.setFont(new Font("Arial", Font.PLAIN, 15));
        textCNIC.setSize(150, 20);
        textCNIC.setLocation(400, 250);
        c.add(textCNIC);
  
      
  
        address = new JLabel("Address");
        address.setFont(new Font("Arial", Font.PLAIN, 20));
        address.setSize(100, 20);
        address.setLocation(200, 300);
        c.add(address);
  
        textAddress = new JTextArea();
        textAddress.setFont(new Font("Arial", Font.PLAIN, 15));
        textAddress.setSize(200, 75);
        textAddress.setLocation(400, 300);
        textAddress.setLineWrap(true);
        c.add(textAddress);
  
   
        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(300, 450);
        sub.addActionListener(this);
        c.add(sub);
  
        
       
       
  
        setVisible(true);
    }
    
    
 public static void Insert(String cnic, String name,String add,String gen,float phn) throws ClassNotFoundException{    
      Connection con= ConnectionProvider.getConnection();
            int r=0;
             try
                {   
                       
                        String query="Insert into AddressBook(CNIC,name,addres,gender,phone) values (?,?,?,?,?)";                        
                        PreparedStatement pstmt=con.prepareStatement(query);
                        pstmt.setString(1,cnic );
                        pstmt.setString(2,name);
                        pstmt.setString(3,add);
                        pstmt.setString(4,gen);
                        pstmt.setFloat(5,phn);
                        
                        
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
                 
                 
                Insert(textCNIC.getText(),textName.getText(), textAddress.getText() ,textGender.getText(),Float.parseFloat(textmobno.getText()));
              
             JOptionPane.showMessageDialog( null, "Record Inserted" );
             }
             catch (ClassNotFoundException ex) {
                Logger.getLogger(Insertion.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }

    }
    
    
}
    
  
              
        
   
    


  
// Driver Code


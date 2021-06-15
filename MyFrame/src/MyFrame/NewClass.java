/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyFrame;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Usama Sheikh
 */

    

  
public class NewClass extends JFrame implements ActionListener {
  
    // Components of the Form
    private Container c;
    private JLabel title;
    
    
    private JLabel input;
    private JTextField textinput;
  
  

    private JButton sub; 
    static  private JTextArea textout;
    
   
  
  
   
    public NewClass()
    {
        setTitle("Menu");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
  
        c = getContentPane();
        c.setLayout(null);
  
        title = new JLabel("Menu");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);
  
       input = new JLabel("Input");
         input.setFont(new Font("Arial", Font.PLAIN, 20));
         input.setSize(100, 20);
        input.setLocation(100, 100);
        c.add( input);
  
        textinput = new JTextField();
        textinput.setFont(new Font("Arial", Font.PLAIN, 15));
       textinput.setSize(190, 20);
        textinput.setLocation(200, 100);
        c.add(textinput);
        
        
      
  
      
  
  
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
         textout.setText("Press 1 for Insert Record"+"\n"
         +"Press 2 for Delete Record"+"\n"
                    +"Press 3 for Search Record"+"\n"
                    +"Press 4 for Update Name Record"+"\n"
                    +"Press 5 for Update Gender Record"+"\n"
                    +"Press 6 for Update Address"+"\n"
                 
                 
                 
         );
        c.add(textout);
  
      
  
        setVisible(true);
    }
  
   
  
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == sub) {
           String s=null;
            
                   
              s= textinput.getText();
                 if(s.equals("1")){
                     
                     Insertion r=new Insertion();
                 }
                  if(s.equals("2")){
                     
                     Deletion r=new Deletion();
                 }
                   if(s.equals("3")){
                     
                     Search r=new Search();
                 }
                    if(s.equals("4")){
                     
                     UpdateName r=new UpdateName();
                 }
                     if(s.equals("5")){
                     
                     UpdateGender r=new UpdateGender();
                 }
                     if(s.equals("6")){
                     
                     UpdateAddress r=new UpdateAddress();
                 }
                     
                      if(s.equals("7")){
                     
                     UpdatePhone r=new UpdatePhone();
                 }
          
                 
           
        
}
    }
}
  
// Driver Code

    
    


import java.io.*; 
import java.util.*; 
import java.applet.*;
import java.awt.*;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;


@SuppressWarnings("serial")

public class Main extends JFrame{

    public Main(){
        JPanel landpage= new JPanel();
        landpage.setLayout(new BorderLayout());

        this.add(new AddDocument("Rahul"), BorderLayout.NORTH);
        this.add(new EditDocument("Edit"), BorderLayout.EAST);
        this.add(new DeleteDocument(), BorderLayout.WEST);
        this.add(new RetreiveDocument(), BorderLayout.SOUTH);
        
        
        this.add(landpage, BorderLayout.CENTER);
    }
       
    
        public static void main(String[] args)
        {
            Scanner in = new Scanner(System.in); 

            int pass;  
            Document d= new Document("Roys", 28);
            d.counter=0;
           
            
            
            
           
            System.out.println("Hi This is the login page : Please enter your credentials:");
            System.out.println(" ");
            System.out.println("Enter your username: ");
            String username = in.nextLine(); 
            System.out.println("username: " + username);
            System.out.println("Enter the password: ");
            pass = in.nextInt();
            System.out.println("password: " + pass);
            

            String cuser="OOM";
            System.out.println(" ");
            if(username.equals(cuser) && pass==123)
            {
                
                Main frame = new Main();
                frame.setTitle("Landing Page");
                frame.setSize(400,300);
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
            }

            else{
                    System.out.println(" ");
                    System.out.println("Wrong username or password");
            }

           
        
      
        }

       

}

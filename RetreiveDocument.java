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

public class RetreiveDocument extends JButton{

    public RetreiveDocument()
    {
        this.setText("Retreive Document");

        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Scanner in = new Scanner(System.in);
              
                System.out.println("<----------Welcome to the Retrieval section---------->");
                System.out.println(" ");
                System.out.println(" ");

                 // Creating object of each base class
                 Document d=new Document("Roys", 28);
                 Topic t= new Topic();
                 Category c=new Category();

                 if(d.counter==0)
                 {
                     System.out.println("There are no Documents currently for retrieval ");
                 }

                 else{
                    System.out.println("Enter the topic of the required Document: ");     // Specifying topic and category of required document
                    String S = in.nextLine();
   
                    System.out.println("Enter the category of the required Document: ");
                    String P = in.nextLine();

                    int j=-1 , k=-1;
                    

                    for(int i=0;i<d.counter;i++)
                    {
                        String s = t.topic[i];
                        if(S.equals(s))
                        {
                            j = i;
                        }
                    }

                    if(j<0)
                    {
                        System.out.println("Couldn't find the specified topic");
                        System.exit(0);
                    }
                    
                    for(int i=0;i<d.counter;i++)
                    {
                        String p = c.category[i];
                        if(P.equals(p))
                        {
                            k = i;
                        }
                    }

                    if(k<0)
                    {
                        System.out.println("Couldn't find the specified category");
                        System.exit(0);
                    }

                    if(j==k)
                    {
                        System.out.println("Retrieved the document successfully ");
                        System.out.println("Here is your document: ");
                        int g = j+1;
                        System.out.println("ID: " + g + "     Document Name: " + d.doc_name[j]);
                    }
                    else
                    {
                        System.out.println("Unable to retrieve the document ");
                    }

                 }

                
                
                
                
            
                }
            });
        
    }

   
    
}

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

public class AddDocument extends JButton {
    private String name;
    private String topic;
    private String category;
    private String documentname;
    private String[] tags = new String[100];
    private int n;
    public AddDocument(String S)
    {
        this.name=S;
        this.setText("Add Document");
        this.n=0;
        
        

        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                    Scanner in = new Scanner(System.in); 

                    System.out.println("<----------Welcome to the Adding Section---------->");
                    System.out.println(" ");
                    System.out.println(" ");

                    // adding document name
                    Document d= new Document("Roys", 28);
                    System.out.println("Enter the name of the document: ");
                    String s = in.nextLine();
                    d.doc_name[d.counter] = s;
                    System.out.println(" ");

                    // adding topic to the newly added document
                    Topic t= new Topic();
                    System.out.println("Enter the topic of the document: ");
                    String to = in.nextLine();
                    t.topic[d.counter] = to;
                    System.out.println(" ");

                    // adding category to the newly added document
                    Category c=new Category();
                    System.out.println("Enter the category of the document: ");
                    String cat = in.nextLine();
                    c.category[d.counter]=cat;
                    System.out.println(" ");

                    // adding tags to the newly created document
                    Tag g = new Tag();
                    System.out.println("Do you wish to attach any tags for your document: Enter 1 for YES & 0 for NO");
                    int y = in.nextInt();

                    
                    if(y==1)
                    {
                        System.out.println("Enter the number of tags you want to attach: ");
                        n = in.nextInt();

                        in.nextLine();                                     // Used to read up the next line character so that input is not skipped 

                        for(int i=0;i<n;i++)
                        {   
                            System.out.println("Enter the tag: ");
                            String ta = in.nextLine();
                            g.StringList[d.counter][i] = ta; 
                        }
                        g.no_tags[d.counter] = n;
                        System.out.println("Tags attached succesfully: ");
                    }

                    else{
                        System.out.println("Thankyou : You may proceed ");
                    }

                    d.DocumentID=d.counter+1;
                
                    d.counter++;

                    // Display details of the newly added document
                    documentname = d.doc_name[d.counter-1];
                    topic = t.topic[d.counter-1];
                    category = c.category[d.counter-1];
                    System.out.println(" ");
                    for(int i=0;i<n;i++)
                    {
                        tags[i] = g.StringList[d.counter-1][i];
                        System.out.println(tags[i]);
                    }
                    System.out.println(" ");
                    display();
                    
                
                }
            });
      



    }

        
    public void display()
    {
       
        System.out.println("The name of the Document added is: " + documentname);  
        System.out.println("The topic of the Document is:" + topic);
        System.out.println("The category of the document is:" + category);      
        if(n!=0)
        {
            System.out.println("The tags attached are: ");
            for(int i=0;i<n;i++)
            {
               System.out.println(tags[i]);
            }
        }
        System.out.println(" ");
        System.out.println(" ");

    }


}

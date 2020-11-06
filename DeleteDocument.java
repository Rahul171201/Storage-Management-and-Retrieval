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

public class DeleteDocument extends JButton{

    public DeleteDocument(){
        this.setText("Delete Document");

        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              
                Scanner in = new Scanner(System.in); 

                // Creating object of each base class
                Document d=new Document("Roys", 28);
                Topic t= new Topic();
                Category c=new Category();
                Tag g = new Tag();
                

                System.out.println("<----------Welcome to the deletion section---------->");
                System.out.println(" ");
                System.out.println(" ");

                if(d.counter==0)
                {
                    System.out.println("There are no Documents currently for deletion ");
                }

                else{
    
                     // Listing all the documents with their ID's
                    System.out.println("Here is the list of documents with their id's: ");
                    for(int i=0;i<d.counter;i++)
                    {   
                        int x=i+1;
                        System.out.println("id: " + x + "  Document Name:  " + d.doc_name[i]);
                    }
                    System.out.println(" ");
    
                    // User inputs the id of the document he/she wants to delete
                    System.out.println("Enter the document id of the document you want to delete: ");
                    int j = in.nextInt();
                    
                    String[] doc = new String[100];         // Creating new array for document name
                    String[] top = new String[100];         // Creating new array for topic
                    String[] cat = new String[100];         // Creating new array for category
                    int[] gat = new int[100];         // Creating new array for number of tags
                    String[][] gatlist = new String[100][100];     // creating new array for tags

                    int count=0;

                    for(int i=0;i<d.counter;i++)                   // Deleteing the document name at specified index
                    {
                        if(i==j-1)
                        continue;

                        else
                        {
                            doc[count] = d.doc_name[i];
                            count++;
                        }
                    }
                    for(int i=0;i<count;i++)
                    {
                        d.doc_name[i] = doc[i];
                    }
                    
                    
                    count=0;

                    for(int i=0;i<d.counter;i++)                              // Deleteing the topic at specified index
                    {
                        if(i==j-1)
                        continue;

                        else
                        {
                            top[count] = t.topic[i];
                            count++;
                        }
                    }
                    for(int i=0;i<count;i++)
                    {
                        t.topic[i] = top[i];
                    }
                

                    
                    count=0;

                    for(int i=0;i<d.counter;i++)                                             // Deleteing the category at specified index
                    {
                        if(i==j-1)
                        continue;

                        else
                        {
                            cat[count] = c.category[i];
                            count++;
                        }
                    }
                    for(int i=0;i<count;i++)
                    {
                        c.category[i] = cat[i];
                    }

                    count=0;

                    for(int i=0;i<d.counter;i++)                                             // Deleteing the tags at specified index
                    {
                        if(i==j-1)
                        continue;

                        else
                        {
                            for(int l=0;l<g.no_tags[i];l++)
                            {
                                gatlist[count][l]=g.StringList[i][l];
                            }
                            
                            count++;
                        }
                    }
                    for(int i=0;i<count;i++)
                    {
                        for(int l=0;l<g.no_tags[i];l++)
                        {
                            g.StringList[i][l] = gatlist[i][l];
                        }
                        
                    }

                    count=0;

                    for(int i=0;i<d.counter;i++)                                             // Deleteing the number of tags at specified index
                    {
                        if(i==j-1)
                        continue;

                        else
                        {
                            gat[count] = g.no_tags[i];
                            count++;
                        }
                    }
                    for(int i=0;i<count;i++)
                    {
                        g.no_tags[i] = gat[i];
                    }

                    
                   

                    d.counter--;
                    

                    System.out.println("The updated list of documents with their id's are : ");                    // Displaying updated list of documents
                    for(int i=0;i<d.counter;i++)
                    {   
                        int x=i+1;
                        System.out.println("id: " + x + "  Document Name:  " + d.doc_name[i]);
                    }



                }

               
                }
            });
        
    }

    
}

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

public class EditDocument extends JButton{
    private String name;
    
    public EditDocument(String S)
    {
        this.name=S;
        this.setText("Edit Document");

        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                Scanner in = new Scanner(System.in); 

                System.out.println("<---------Welcome to the Editting Section---------->");
                System.out.println(" ");
                System.out.println(" ");

                // Creating object of each base class
                Document d=new Document("Roys", 28);
                Topic t= new Topic();
                Category c=new Category();
                Tag g= new Tag();

                if(d.counter==0)
                {
                    System.out.println("There are no documents currently for editting");
                    System.out.println(" ");
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

                // User inputs the id of the document he/she wants to edit
                System.out.println("Enter the document id of the document you want to edit: ");
                int j = in.nextInt();
                System.out.println(" ");

                if(j>0 && j<=d.counter)                            // if the value of the ID provided by user is correct and acceptable then it goes inside the loop
                {
                    System.out.println("The details of the document are: ");               // Displaying datails of the selected document
                    System.out.println("Document Name: " + d.doc_name[j-1]);
                    System.out.println("Topic: " + t.topic[j-1]);
                    System.out.println("Category: " + c.category[j-1]);
                    System.out.println("List of Tags: ");
                    for(int i=0;i<g.no_tags[j-1];i++)
                    {
                        System.out.println(g.StringList[j-1][i]);
                    }
                    System.out.println(" ");

                    while(true){

                            System.out.println("Enter your choice: ");                             //Providing choice to user what he/she wants to change in the document
                            System.out.println("Enter 1 for updating topic ");
                            System.out.println("Enter 2 for updating category ");
                            System.out.println("Enter 3 for updating document name ");
                            System.out.println("Enter 4 for adding tag ");
                            System.out.println("Enter 5 for deleting tag ");
                            System.out.println("Enter 0 for exiting ");
                            int v = in.nextInt();

                            in.nextLine();                                     // Used to read up the next line character so that input is not skipped 

                            System.out.println(" ");
                            System.out.println(" ");

                            if(v==1)          // edit topic
                            {
                                System.out.println("Enter the new topic for your document: ");
                                String S = in.nextLine();
                                t.topic[j-1] = S;
                                System.out.println(" ");
                                System.out.println("Updated topic for the document successfully ");
                                System.out.println(" ");
                            }

                            else if(v==2)    //edit category
                            {
                                System.out.println("Enter the new category for your document: ");
                                String S = in.nextLine();
                                c.category[j-1] = S;
                                System.out.println(" ");
                                System.out.println("Updated category for the document successfully ");
                                System.out.println(" ");
                            }

                            else if(v==3)    // edit document name
                            {
                                System.out.println("Enter the new name for your document: ");
                                String S = in.nextLine();
                                d.doc_name[j-1] = S;
                                System.out.println(" ");
                                System.out.println("Updated the name of the document successfully ");
                                System.out.println(" ");
                            }

                            else if(v==4)     // add tag
                            {
                                if(g.no_tags[j-1]!=0)
                                {
                                    System.out.println("Here is the list of tags: ");
                                    for(int i=0;i<g.no_tags[j-1];i++)
                                    {
                                        System.out.println(g.StringList[j-1][i]);
                                    }
                                }
                                
                                System.out.println("Enter the tag you want to add: ");
                                String h = in.nextLine();
                                g.StringList[j-1][g.no_tags[j-1]]=h;
                                g.no_tags[j-1]++;
                                System.out.println("Here is the final list of tags: ");
                                for(int i=0;i<g.no_tags[j-1];i++)
                                {
                                    System.out.println(g.StringList[j-1][i]);
                                }
                                System.out.println(" ");
                            }

                            else if(v==5)  //delete tag
                            {
                                if(g.no_tags[j-1]!=0)
                                {
                                    System.out.println("Here is the list of tags: ");
                                    for(int i=0;i<g.no_tags[j-1];i++)
                                    {
                                        System.out.println(g.StringList[j-1][i]);
                                    }
                                    System.out.println(" ");

                                    System.out.println("Enter the tag you want to delete: ");
                                    String q = in.nextLine();
                                    String[] list = new String[100];
                                    int count = 0;
                                    for(int i=0;i<g.no_tags[j-1];i++)
                                    {
                                        if(q.equals(g.StringList[j-1][i]))
                                        continue;

                                        else
                                        {
                                            list[count] = g.StringList[j-1][i];
                                            count++;
                                        }
                                    }
                                    if(count==g.no_tags[j-1])
                                    {
                                        System.out.println("No such tag exists : Illegal Access");
                                        System.exit(0);
                                    }
                                    g.no_tags[j-1]--;

                                    
                                    for(int i=0;i<g.no_tags[j-1];i++)
                                    {
                                        g.StringList[j-1][i]=list[i];
                                    }

                                    System.out.println("Here is the final list of tags: ");
                                    for(int i=0;i<g.no_tags[j-1];i++)
                                    {
                                        System.out.println(g.StringList[j-1][i]);
                                    }
                                    System.out.println(" ");


                                }
                                else{
                                    System.out.println("There no tags currently attached to this document");
                                }
                            }

                            else if(v==0)     // exit from loop updation is completed
                            {
                                break;
                            }

                            else             // when user enters wrong choice
                            {
                                System.out.println("Invalid choice: Illegal access ");
                                System.out.println(" ");
                            }

                            
                    }
                    
                    System.out.println("The updated list of documents with their id's are : ");                    // Displaying updated list of documents
                            for(int i=0;i<d.counter;i++)
                            {   
                                int x=i+1;
                                System.out.println("id: " + x + "  Document Name:  " + d.doc_name[i]);
                            }
                            
    
                }

                 // when user enters wrong choice
                else{        
                    System.out.println("Wrong input: Illegal access");
                    System.out.println(" ");
                    System.out.println(" ");
                }
               
                }

                
                
            
                }
            });
        
    }
     
  
    
}

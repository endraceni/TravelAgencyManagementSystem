package travelagencymanagementsystem.DBManagement;


import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;


public class ListFunctions {
    
    public static boolean checkFields(String a,String b)
    {
        if(a.equals("")|| b.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please fill the fields.");
            return true;
        }
        return false;
    }
    
    public  static void addElementToList(JList list, Object obj){
    
             
       DefaultListModel dlm = new DefaultListModel();
       //adding element to the list
       int size = list.getModel().getSize();
       for (int i=0;i<size;i++){
         
          dlm.addElement(list.getModel().getElementAt(i));

      }
       dlm.addElement(obj);
       list.setModel(dlm);
    }
    public static void deleteElementFromList(JList list, Object obj){
    
       DefaultListModel dlm = new DefaultListModel();
      
       int size = list.getModel().getSize();
       for (int i=0;i<size;i++){
         
          dlm.addElement(list.getModel().getElementAt(i));

      } 
       dlm.removeElement(obj);
       list.setModel(dlm);
        
    
    }
}

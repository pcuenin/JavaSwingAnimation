/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplicationfinal;

/**
 *
 * @author paul.cuenin
 */
public class Dance {
    String name;
    String first;
    String second;
    String third;
    String fourth;
    String fifth;
    
    public Dance(String newName, String new1stMove, String new2ndMove,String new3rdMove, String new4thMove,String new5thMove)
    {
        name=newName;
        first=new1stMove;
        second=new2ndMove;
        third=new3rdMove;
        fourth=new4thMove;
        fifth=new5thMove;
        
    }

    Dance(int ptr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package android.App.calculator;


/**
 *
 * @author guido
 */
public class calculateExpression {
        
        private String result="";

       public String calculate(String input, int precision, int radDeg) {
           
           float res = calculateSimpleExpression(input);
           return  res+"";         
    }
    
    public float calculateSimpleExpression(String expresion) {
         int cantSignosMasMenos = 0;
         int indices[];
    
        for(int i=0;i<expresion.length();i++)
            if(expresion.charAt(i)== '+' || expresion.charAt(i)== '-' )
                cantSignosMasMenos++;
        
        indices = new int[cantSignosMasMenos+2];
        short index = 1;
        indices[0]=0;
        for(int j=0;j<expresion.length();j++)
            if(expresion.charAt(j)== '+' || expresion.charAt(j)== '-' ){
                indices[index]=j;
                index++;}
        
       indices[cantSignosMasMenos+1]=expresion.length(); 
       float expresiones[] = new float[cantSignosMasMenos+1];     
       expresiones[0]=calcularProducto(expresion.substring(indices[0], indices[1])); 
       
       float total = expresiones[0];
       for(int k=1 ;k<expresiones.length;k++){
           expresiones[k]=calcularProducto(expresion.substring(indices[k]+1, indices[k+1]));
           if(expresion.charAt(indices[k]) == '+')
              total +=expresiones[k];
           else
              total -=expresiones[k];
       }
           return total; 
        
    }
    
     public float calcularProducto(String expresion){
        int cantSignos = 0;
        int indices[];
        
        for(int i=0;i<expresion.length();i++)
            if((expresion.charAt(i)== '*') || (expresion.charAt(i)== '/'))
                cantSignos++;
        
        indices = new int[cantSignos+2];
        short index = 1;
        indices[0]=0;
        for(int j=0;j<expresion.length();j++)
            if((expresion.charAt(j)== '*')|| (expresion.charAt(j)== '/')){
                indices[index]=j;
                index++;}
        
       indices[cantSignos+1]=expresion.length(); 
       
       //primer valor    
       float total = Float.parseFloat(expresion.substring(indices[0], indices[1])); 
       
       for(int k=1 ;k<cantSignos+1;k++){
           if(expresion.charAt(indices[k])=='*')   
           total*=Float.parseFloat(expresion.substring(indices[k]+1, indices[k+1]));
           else
           total/=Float.parseFloat(expresion.substring(indices[k]+1, indices[k+1]));    
       }
       return total;
    }


}
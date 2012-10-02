/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package android.App.calculator;


import java.util.*;
import org.nfunk.jep.*;
import org.nfunk.jep.function.*;

/**
 *
 * @author guido
 */
public class fact extends PostfixMathCommand{
    
    public fact() {
		numberOfParameters = 1;
	}

    @Override
	public void run(Stack inStack) throws ParseException {

		// check the stack
		checkStack(inStack);
		// get the parameter from the stack
		Object param = inStack.pop();
		// check whether the argument is of the right type
		if (param instanceof Double) {
			// calculate the result                        
                        String val1 = Double.toString(((Double)param).doubleValue());
                        int valor2 = ((Double)param).intValue();
                        String val2 = Double.toString(new Double(valor2));
                        
                        if(val1.equals(val2)){        
                        int res = 1;        
                        int num=((Double)param).intValue();
                        while(num!=0){
                            res*=num;
                            num--;                            
                        }                
			inStack.push(new Double(res));
                        }
		} else {
			throw new ParseException("Invalid parameter type");
		}    
}
}

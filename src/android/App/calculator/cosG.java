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
public class cosG extends PostfixMathCommand{
    
    public cosG() {
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
		         
               Double res = Math.cos((((Double)param).doubleValue())* Math.PI/180);                     
                    inStack.push(res);
                
                }
		 else {
			throw new ParseException("Invalid parameter type");
		}    
}
}

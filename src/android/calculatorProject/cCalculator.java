package android.calculatorProject;

import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class cCalculator extends Activity
{
    private String input;
    private String ans;
    private Button button1,button2,button3,button4;
    private Button button7,button8,button9,button10;
    private Button button13,button14,button15,button16;
    private Button button19,button20,button21,button22;
    private EditText inputText;
    private EditText resultText;
    private calculateExpression result;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        
        result = new calculateExpression();     
        input = new String();
        ans = new String();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
       addListenerOnButton();
       
       inputText = (EditText) findViewById(R.id.inputText); 
       resultText = (EditText) findViewById(R.id.resultText);       
    }

    private void addListenerOnButton() {
       button1 = (Button) findViewById(R.id.button1);
       button1.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+="1";
                    showInput();
                    }
        });
    
       button2 = (Button) findViewById(R.id.button2);
       button2.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+="2";
                    showInput();
                    }
        });
       button3 = (Button) findViewById(R.id.button3);
       button3.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+="3";
                    showInput();
                    }
        });
       button4 = (Button) findViewById(R.id.button4);
       button4.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+="/";
                    showInput();
                    }
        });
       button7 = (Button) findViewById(R.id.button7);
       button7.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+="4";
                    showInput();
                    }
        });
       button8 = (Button) findViewById(R.id.button8);
       button8.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+="5";
                    showInput();
                    }
        });
       button9 = (Button) findViewById(R.id.button9);
       button9.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+="6";
                    showInput();
                    }
        });
       button10 = (Button) findViewById(R.id.button10);
       button10.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+="*";
                    showInput();
                    }
        });
       
       button13 = (Button) findViewById(R.id.button13);
       button13.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+="7";
                    showInput();
                    }
        });
       button14 = (Button) findViewById(R.id.button14);
       button14.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+="8";
                    showInput();
                    }
        });
       button15 = (Button) findViewById(R.id.button15);
       button15.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+="9";
                    showInput();
                    }
        });
       button16 = (Button) findViewById(R.id.button16);
       button16.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+="-";
                    showInput();
                    }
        });
       button19 = (Button) findViewById(R.id.button19);
       button19.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+="0";
                    showInput();
                    }
        });      
       button20 = (Button) findViewById(R.id.button20);
       button20.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if (!input.contains(".") && !input.isEmpty())
                    input+=".";
                    showInput();
                    }
        });
       
       button21 = (Button) findViewById(R.id.button21);
       button21.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if((!input.equals(""))&& contieneOperadores() == true) 
                    calculateOutput();
                    }
        });       
       button22 = (Button) findViewById(R.id.button22);
       button22.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+="+";
                    showInput();
                    }
        });  

    }
    
    private boolean contieneOperadores() {  
        try{
        Float num = Float.parseFloat(inputText.getText().toString());
        return false;
        }catch (Exception e){return true;}
                      
            }
    private void showInput() {
               inputText.setText(input);
            }
    private void calculateOutput() {
        float res = result.calculate(input);
       
        resultText.append(input);     
        resultText.append("\n");
        resultText.append("-----------------------");
        resultText.append("\n");
        resultText.append("="+res);
        resultText.append("\n");
        
        inputText.setText("");
        ans = ""+res;
        input="";
            }
}
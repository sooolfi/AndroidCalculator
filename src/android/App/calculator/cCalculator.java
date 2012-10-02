package android.App.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import java.text.DecimalFormat;
import org.nfunk.jep.JEP;
public class cCalculator extends Activity
{
    private String result,input,ans,xValue;
    private int precision,radDeg; //radDeg = 1 radianes, =2 grados
    private Button butErase;
    private Button butSiete,butOcho,butNueve,butDiv,butC,butRaiz,butN;
    private Button butCuatro,butCinco,butSeis,butPor,butPi,butElev,butAns;
    private Button butUno,butDos,butTres,butMenos,butParIzq,butParDer,butX;
    private Button butCero,butPunto,butIgual,butMas,butPorcent,butInterr,butXequal;
    private Button butSin,butAsin,butCos,butAcos,butTan,butAtan,butLn,butExp;
    private EditText inputText,resultText;
    private TableLayout trigonometricTable, standarTable;
    private JEP resultJep;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        precision =2;
        radDeg = 1;  
        result = "";
        xValue = "";
        input = "";
        ans = new String();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        addListenerOnButton();     
        inputText = (EditText) findViewById(R.id.inputText); 
        resultText = (EditText) findViewById(R.id.resultText);
        trigonometricTable = (TableLayout) findViewById(R.id.trigonometricTable);
        trigonometricTable.setVisibility(View.GONE);
        standarTable = (TableLayout) findViewById(R.id.standarTable);
        //libreria para calcular resultados
        resultJep = new JEP();
        resultJep.addStandardFunctions();
        resultJep.addStandardConstants();
        resultJep.setImplicitMul(true);
        resultJep.addFunction("fact", new fact());
        resultJep.addFunction("sinG", new sinG());
        resultJep.addFunction("asinG", new sinG()); 
        resultJep.addFunction("cosG", new cosG());
        resultJep.addFunction("acosG", new acosG());
        resultJep.addFunction("tanG", new tanG());
        resultJep.addFunction("atanG", new atanG());
    }
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {        
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);           
        return true;
    }
    
    @Override 
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
        case R.id.cientifica:
            item.setChecked(true);
            trigonometricTable.setVisibility(View.VISIBLE);
            return true;
       case R.id.estandar:
           item.setChecked(true);
           trigonometricTable.setVisibility(View.GONE);
           standarTable.bringToFront();
           
           return true;
       case R.id.precUno:
           item.setChecked(true);
           precision = 1;
           return true;
       case R.id.precDos:
           item.setChecked(true);
           precision = 2;
           return true;
       case R.id.precTres:
           item.setChecked(true);
           precision = 3;
           return true;
       case R.id.precCuatro:
           item.setChecked(true);
           precision = 4;
           return true;
       case R.id.precCinco:
           item.setChecked(true);
           precision = 5;
           return true;
       case R.id.grados:
           item.setChecked(true);
           radDeg = 2;
           return true;
       case R.id.radianes:
           item.setChecked(true);
           radDeg = 1;
           return true;
       default:
            return false;

        }

    }

    private void addListenerOnButton() {

       butErase = (Button) findViewById(R.id.butErase);
       butErase.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if(!input.isEmpty()){
                        input=input.substring(0, input.length()-1);
                    showInput();}}
        });
       butUno = (Button) findViewById(R.id.butUno);
       butUno.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+="1";
                    showInput();}                    
        });
       butDos = (Button) findViewById(R.id.butDos);
       butDos.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+="2";
                    showInput();}                    
        });
       butTres = (Button) findViewById(R.id.butTres);
       butTres.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+="3";
                    showInput();}                   
        });
       butCuatro = (Button) findViewById(R.id.butCuatro);
       butCuatro.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+="4";
                    showInput();}                    
        });
       butCinco = (Button) findViewById(R.id.butCinco);
       butCinco.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+="5";
                    showInput();}                    
        });
       butSeis = (Button) findViewById(R.id.butSeis);
       butSeis.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+="6";
                    showInput();}                    
        });
       butSiete = (Button) findViewById(R.id.butSiete);
       butSiete.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+="7";
                    showInput();}                    
        });
       butOcho = (Button) findViewById(R.id.butOcho);
       butOcho.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+="8";
                    showInput();}                    
        });
       butNueve = (Button) findViewById(R.id.butNueve);
       butNueve.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+="9";
                    showInput();}                    
        });
       butCero = (Button) findViewById(R.id.butCero);
       butCero.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {       
                    input+="0";    
                    showInput();
                }                                    
        });
       butMenos = (Button) findViewById(R.id.butMenos);
       butMenos.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+="-";
                    showInput();}                    
        });
       butMas = (Button) findViewById(R.id.butMas);
       butMas.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+="+";
                    showInput();}                    
        });
       butPor = (Button) findViewById(R.id.butPor);
       butPor.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+="*";
                    showInput();}                    
        });
       butDiv = (Button) findViewById(R.id.butDiv);
       butDiv.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+="/";
                    showInput();}                    
        });
       butPunto = (Button) findViewById(R.id.butPunto);
       butPunto.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+=".";
                    showInput();}                                    
        });                            
       butParIzq = (Button) findViewById(R.id.butParIz);
       butParIzq.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+="(";
                    showInput();
                }                                    
        });                     
       butParDer = (Button) findViewById(R.id.butParDer);
       butParDer.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+=")";
                    showInput();
                }                                    
        });              
       butAns = (Button) findViewById(R.id.butAns);
       butAns.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+=ans;
                    showInput();
                }                                    
        });
       butC = (Button) findViewById(R.id.butC);
       butC.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input="";
                    showInput();
                }                                    
        });
       butElev = (Button) findViewById(R.id.butElev);
       butElev.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+="^";
                    showInput();
                }                                    
        });
       butInterr = (Button) findViewById(R.id.butInterr);
       butInterr.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+="fact(";
                    showInput();
                }                                    
        });
       butX = (Button) findViewById(R.id.butX);
       butX.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+="x";
                    showInput();                    
                }                                    
        });
       butXequal = (Button) findViewById(R.id.butXequal);
       butXequal.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {                    
                    input="x=";
                    showInput();
                }                                    
        });
       butRaiz = (Button) findViewById(R.id.butRaiz);
       butRaiz.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+="sqrt(";
                    showInput();
                }                                    
        });
       butPi = (Button) findViewById(R.id.butpi);
       butPi.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+="pi";
                    showInput();
                }                                    
        });
       butPorcent = (Button) findViewById(R.id.butPorcent);
       butPorcent.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+="%";
                    showInput();
                }                                    
        });
       

     //Funciones trigonometricas
     
       butPi = (Button) findViewById(R.id.butpi);
       butPi.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+="pi";
                    showInput();
                }                                    
        });
       butSin = (Button) findViewById(R.id.butSin);    
       butSin.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if(radDeg ==1)
                    input+="sin(";
                    else
                    input+="sinG(";
                    showInput();
                }                                    
        });
       butAsin = (Button) findViewById(R.id.butAsin);
       butAsin.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if(radDeg ==1)
                    input+="asin(";
                    else
                    input+="asinG(";
                    showInput();           }                                    
        });
       butCos = (Button) findViewById(R.id.butCos);
       butCos.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if(radDeg ==1)
                    input+="cos(";
                    else
                    input+="cosG(";
                    showInput();
                }                                    
        });
       butAcos = (Button) findViewById(R.id.butAcos);
       butAcos.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if(radDeg ==1)
                    input+="acos(";
                    else
                    input+="acosG(";
                    showInput();}                                    
        });
       butTan = (Button) findViewById(R.id.butTan);
       butTan.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                   if(radDeg ==1)
                    input+="tan(";
                    else
                    input+="tanG(";
                    showInput();}                                    
        });
       butAtan = (Button) findViewById(R.id.butAtan);
       butAtan.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                   if(radDeg ==1)
                    input+="atan(";
                    else
                    input+="atanG(";
                    showInput();                    
                }                                    
        });
       butLn = (Button) findViewById(R.id.butLn);
       butLn.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+="ln(";
                    showInput();
                }                                    
        });
       butExp = (Button) findViewById(R.id.butExp);
       butExp.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    input+="e^(";
                    showInput();
                }                                    
        });
       
       //Boton igual
       butIgual = (Button) findViewById(R.id.butIgual);
       butIgual.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if(!input.isEmpty()){
  
                    if((input.charAt(0)=='x')&& (input.charAt(1)=='='))                   
                    try{
                    xValue = input.substring(2, input.length());
                    resultText.append("-----------------------");
                    resultText.append("\n");
                    resultText.append("x="+xValue);
                    resultText.append("\n");        
                    inputText.setText("");
                    input="";
                    } catch (Exception ea ) {
                        
                    resultText.append("-----------------------");
                    resultText.append("\n");
                    resultText.append("...Syntax Error...");
                    }
                    else   
                        if(!("".equals(input)))
                        calculateOutput();    
                }        }                        
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
        //usamos libreria jep
        
        if(!("".equals(xValue))){
        resultJep.parseExpression(xValue);
        
        resultJep.addVariable("x", resultJep.getValue());        
        }
        resultJep.parseExpression(input);
       
        //Si esta en radianes lo dejo asi, sino 
                
                    
        double res = resultJep.getValue();
        String screenResutl;
        if(!Double.isNaN(res))
        roundResult(res);
        else
            result="...Syntax Error...";

        resultText.append(input);     
        resultText.append("\n");
        resultText.append("-----------------------");
        resultText.append("\n");
        resultText.append(result);
        resultText.append("\n");        
        inputText.setText("");
        if(!("...Syntax Error...".equals(result)))
        ans = result;
        input="";
            }

    
    
    private void roundResult(Double resultado) {
       String res = resultado+"";
       DecimalFormat round = new DecimalFormat("####.#");
           switch (precision){
               case 1:                   
                   result = round.format(resultado);
                   break;
               case 2:                   
                   round = new DecimalFormat("####.##");
                   result = round.format(resultado);
                   break;
               case 3:                   
                   round = new DecimalFormat("####.###");
                   result = round.format(resultado);
                   break;
               case 4:                   
                   round = new DecimalFormat("####.####");
                   result = round.format(resultado);
                   break;
               case 5:                   
                   round = new DecimalFormat("####.#####");
                   result = round.format(resultado);
                   break;
           }
    }


}

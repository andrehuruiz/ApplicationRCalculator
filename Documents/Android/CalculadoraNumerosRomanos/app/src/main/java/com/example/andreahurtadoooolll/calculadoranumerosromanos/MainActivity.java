package com.example.andreahurtadoooolll.calculadoranumerosromanos;

import android.app.AlertDialog;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    String num1;
    String num2;
    String sign;
    private Button clear;
    private Button suma;
    private Button resta;
    private Button resultado;
    private Button uno;
    private Button cinco;
    private Button diez;
    private Button cincuenta;
    private Button cien;
    private Button quinientos;
    private Button mil;
    private TextView display;
    private Toast aviso;
    private TextView prueba1;
    private TextView prueba2;
    private TextView prueba3;
    private TextView pruebasign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        clear=(Button)findViewById(R.id.b_clear);
        clear.setOnClickListener(this);
        suma=(Button)findViewById(R.id.b_suma);
        suma.setOnClickListener(this);
        resta=(Button)findViewById(R.id.b_resta);
        resta.setOnClickListener(this);
        resultado=(Button)findViewById(R.id.igual);
        resultado.setOnClickListener(this);
        uno=(Button)findViewById(R.id.b_uno);
        uno.setOnClickListener(this);
        cinco=(Button)findViewById(R.id.b_cinco);
        cinco.setOnClickListener(this);
        diez=(Button)findViewById(R.id.b_diez);
        diez.setOnClickListener(this);
        cincuenta=(Button)findViewById(R.id.b_cincuenta);
        cincuenta.setOnClickListener(this);
        cien=(Button)findViewById(R.id.b_cien);
        cien.setOnClickListener(this);
        quinientos=(Button)findViewById(R.id.b_quinientos);
        quinientos.setOnClickListener(this);
        mil=(Button)findViewById(R.id.b_mil);
        mil.setOnClickListener(this);

        display=(TextView)findViewById(R.id.numero1);
        prueba1=(TextView)findViewById(R.id.textView);
        prueba2=(TextView)findViewById(R.id.textView2);
        prueba3=(TextView)findViewById(R.id.textView3);
        pruebasign=(TextView)findViewById(R.id.textView5);

    }

    @Override
    public void onClick(View vista) {
        switch (vista.getId()) {
            case R.id.b_uno:
                display.setText(display.getText() + "I");
                aviso = Toast.makeText(getApplicationContext(),
                        "Puede repetirse solo hasta 3 veces", Toast.LENGTH_SHORT);aviso.show();
                break;
            case R.id.b_cinco:
                display.setText(display.getText() + "V");
                aviso = Toast.makeText(getApplicationContext(),
                        "Siguiente numero:No puede repetirse", Toast.LENGTH_SHORT);aviso.show();
                break;
            case R.id.b_diez:
                display.setText(display.getText() + "X");
                aviso = Toast.makeText(getApplicationContext(),
                        "Puede repetirse solo hasta 3 veces", Toast.LENGTH_SHORT);aviso.show();
                break;
            case R.id.b_cincuenta:
                display.setText(display.getText() + "L");
                aviso = Toast.makeText(getApplicationContext(),
                        "Siguiente numero:No puede repetirse", Toast.LENGTH_SHORT);aviso.show();
                break;
            case R.id.b_cien:
                display.setText(display.getText() + "C");
                aviso = Toast.makeText(getApplicationContext(),
                        "Puede repetirse solo hasta 3 veces", Toast.LENGTH_SHORT);aviso.show();
                break;
            case R.id.b_quinientos:
                display.setText(display.getText() + "D");
                aviso = Toast.makeText(getApplicationContext(),
                        "Siguiente numero:No puede repetirse", Toast.LENGTH_SHORT);aviso.show();
                break;
            case R.id.b_mil:
                display.setText(display.getText() + "M");
                aviso = Toast.makeText(getApplicationContext(),
                        "Puede repetirse solo hasta 3 veces", Toast.LENGTH_SHORT);aviso.show();
                break;

            case R.id.b_suma:
                if(!display.getText().equals("")) {
                    num1= (String) display.getText();
                    sign="+";
                    display.setText("");
                    pruebasign.setText("+");
                }
                else
                {
                      aviso = Toast.makeText(getApplicationContext(),
                                "Inserte primer sumando", Toast.LENGTH_LONG);aviso.show();
                }
                break;
            case R.id.b_resta:
                if(!display.getText().equals("")) {
                    num1= (String) display.getText();
                    sign="-";
                    display.setText("");
                    pruebasign.setText("-");
                }
                else
                {
                    aviso = Toast.makeText(getApplicationContext(),
                            "Inserte minuendo", Toast.LENGTH_LONG);aviso.show();
                }
                break;
            case R.id.b_clear:
                display.setText("");
                prueba1.setText("");
                prueba2.setText("");
                prueba3.setText("");
                pruebasign.setText("");
                num1="";
                num2="";
                sign="";
                break;

            case R.id.igual:
                String answer;
                num2=(String) display.getText();
                if(!num2.equals("")){
                    answer=calcular(num1,num2,sign);
                    display.setText(answer);
                }
                else
                {
                    display.setText(num1);
                }
                break;

        }
    }

    private String calcular(String num1, String num2, String sign) {
        int arabigo1 = convertirromano_entero(num1);
        prueba1.setText(Integer.toString(arabigo1));
        int arabigo2= convertirromano_entero(num2);
        prueba2.setText(Integer.toString(arabigo2));
        int result_preliminar=0;
        String result;

        if(sign.equals("+")){
            result_preliminar=arabigo1+arabigo2;
            prueba3.setText(Integer.toString(result_preliminar));

        }
        if(sign.equals("-")){
            if((arabigo1-arabigo2)>0){
                result_preliminar=arabigo1-arabigo2;
                prueba3.setText(Integer.toString(result_preliminar));
            }
            else
            {
                aviso = Toast.makeText(getApplicationContext(),
                        "El minuendo es mayor o igual que el sustraendo. Por favor verifique", Toast.LENGTH_LONG);aviso.show();

            }
            }

        if(result_preliminar<4000){
        result=convertirentero_romano(result_preliminar);
        return result;}
        else{
            aviso = Toast.makeText(getApplicationContext(),
                    "Respuesta fuera de rango de visualización", Toast.LENGTH_LONG);aviso.show();
            return null;
        }
    }

    private int convertirromano_entero(String numero) {

        int longi = numero.length();
        char n[]=new char[longi];
        int enteros[]=new int[longi];
        int sumar=0;
        int c=0;
        int c2=0;

        StringBuffer cadena= new StringBuffer();

        int post=0;
        for (int indice = 0; indice < longi ; indice++) {
            char caracter = numero.charAt(indice);
            n[indice] = caracter;
            switch (n[indice]){
                case 'I':
                    enteros[indice]=1;
                    break;
                case 'V':
                    enteros[indice]=5;
                    break;
                case 'X':
                    enteros[indice]=10;
                    break;
                case 'L':
                    enteros[indice]=50;
                    break;
                case 'C':
                    enteros[indice]=100;
                    break;
                case 'D':
                    enteros[indice]=500;
                    break;
                case 'M':
                    enteros[indice]=1000;
                    break;
            }
        }

    int longi2=longi-1;

        while ( post < longi2){

        if(enteros[longi2-post]<=enteros[longi2-(post+1)]){
           sumar=sumar+enteros[post];
        }
        else {
            sumar=sumar-enteros[post];
        }
        /*    if(longi>3){
                if(enteros[longi2-post]== enteros[longi2-(post+1)]){
                    if (enteros[longi2-(post+1)]== enteros[longi2-(post+2)]){
                     if (enteros[longi2-(post+2)]== enteros[longi2-(post+3)]){
                        aviso = Toast.makeText(getApplicationContext(),
                                "Error de sintaxis.Verifique", Toast.LENGTH_LONG);aviso.show();
                        display.setText("");
                        num1="";
                        num2=""; }}}}*/
            post++;
        }
        sumar=sumar+enteros[longi2];
        return sumar;
    }

   private String convertirentero_romano(int respuesta) {

        int i,auxiliar;
        String res_romano="";
        int entero[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String romano[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        auxiliar=respuesta;
        while (true){
        if(auxiliar==0){break;}
        i=0;
        while (auxiliar>0){
            if(auxiliar>= entero[i]){
                res_romano=res_romano+romano[i];
                auxiliar=auxiliar-entero[i];
            }
            else i++;
        }}

        return res_romano;
    }

}

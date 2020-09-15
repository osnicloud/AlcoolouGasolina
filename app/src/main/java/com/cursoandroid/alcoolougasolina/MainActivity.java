package com.cursoandroid.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.awt.font.TextAttribute;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool     = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina   = findViewById(R.id.editPrecoGasolina);
        textResultado       = findViewById(R.id.textResultado);
    }

    public void calcularPreco(View view){
        //Recuperar valores digitados
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        //Validar os campos digitados
        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);
        if( camposValidados ){

            //Convertendo string para números.
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            //Calculo
            Double resultado = valorAlcool / valorGasolina;

            if( resultado >=0.7 ){
                textResultado.setText("Melhor utilizar Gasolina");
            }else {
                textResultado.setText("Melhor utilizar Álcool");
            }

        }else{
            textResultado.setText("Preencha os campos primeiro!");
        }

    }

    public Boolean validarCampos(String pAlcool, String pGasolina){

        Boolean camposValidados = true;

        if(pAlcool == null || pAlcool.equals("")){
            camposValidados = false;
        }

        if(pGasolina == null || pGasolina.equals("")){
            camposValidados = false;
        }

        return camposValidados;
    }

    /*
    Outra abordagem, retorna String que informa mensagem qual campo está invalido ou se está tudo validado.
    Em seguida, usar if ou switch no método que chama o método validar para verificar o que não foi preenchido
    */
    public String validarCampos2(String pAlcool, String pGasolina){

        Boolean camposValidados = true;
        String campo = "preenchido";

        if(pAlcool == null || pAlcool.equals("")){
            camposValidados = false;
            campo = "alcool";
        }

        if(pGasolina == null || pGasolina.equals("")){
            camposValidados = false;
            campo = "gasolina";
        }

        return campo;
    }



}

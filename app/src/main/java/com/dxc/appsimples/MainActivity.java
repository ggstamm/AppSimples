package com.dxc.appsimples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etNum1, etNum2;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        tvResultado = findViewById(R.id.tvResultado);
        configuraCampos();
    }

    private void configuraCampos(){
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                somarNumeros();
            }
        };
        etNum1.addTextChangedListener(textWatcher);
        etNum2.addTextChangedListener(textWatcher);
    }

    private boolean validaAlteracao(){
        return !(etNum1.getText().toString().isEmpty() || etNum2.getText().toString().isEmpty());
    }

    private void somarNumeros(){
        if(validaAlteracao()){
            int numero1, numero2, resultado;
            numero1 = Integer.parseInt(etNum1.getText().toString());
            numero2 = Integer.parseInt(etNum2.getText().toString());
            resultado = numero1 + numero2;
            tvResultado.setText(Integer.toString(resultado));
        } else{
            tvResultado.setText("");
        }
    }
}

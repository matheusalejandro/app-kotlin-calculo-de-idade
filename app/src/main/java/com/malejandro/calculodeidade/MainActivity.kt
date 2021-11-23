package com.malejandro.calculodeidade

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    //Definicao inicial dos atributos com atraso (lateinit)
    lateinit var inputQuestion1:EditText
    lateinit var inputQuestion2:EditText
    lateinit var btnCalcular:Button
    lateinit var btnNovoCalculo:Button
    lateinit var txtResult:TextView
    lateinit var btnSair:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponents()
        initButtonClick()
    }

    private fun initComponents() {
        inputQuestion1 = findViewById(R.id.inputQuestion1)
        inputQuestion2 = findViewById(R.id.inputQuestion2)
        btnCalcular = findViewById(R.id.btnCalcular)
        btnNovoCalculo = findViewById(R.id.btnNovoCalculo)
        txtResult = findViewById(R.id.txtResult)
        btnSair = findViewById(R.id.btnSair)

        txtResult.setText("Campo inicializado")
    }

    private fun initButtonClick() {
        btnSair.setOnClickListener {  }
        btnCalcular.setOnClickListener {  }
        btnNovoCalculo.setOnClickListener {  }
    }
}
package com.malejandro.calculodeidade.view

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.malejandro.calculodeidade.R
import com.malejandro.calculodeidade.controller.PersonController
import com.malejandro.calculodeidade.model.PersonDetails
import java.time.LocalDate

class MainActivity : AppCompatActivity() {

    //Definicao inicial dos atributos com atraso (lateinit)
    lateinit var inputQuestion1:EditText
    lateinit var inputQuestion2:EditText
    lateinit var btnCalcular:Button
    lateinit var btnNovoCalculo:Button
    lateinit var txtResult:TextView
    lateinit var btnSair:Button
    lateinit var person:PersonDetails
    lateinit var personController:PersonController


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

        person = PersonDetails()
        personController = PersonController(person)

        txtResult.setText("Campo inicializado")
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun initButtonClick() {
        btnSair.setOnClickListener {
            Toast.makeText(
                this,
                "Clicado no botão sair",
                Toast.LENGTH_SHORT
            ).show()

            finish()
        }
        btnCalcular.setOnClickListener {

            var dadosValidados:Boolean = validateFields(inputQuestion2.text.toString(), inputQuestion1.text.toString())

            if(dadosValidados) {
                person.firstName = inputQuestion1.text.toString()
                person.birthYear = inputQuestion2.text.toString().toInt()

                txtResult.setText("${personController.getResult()}")
            } else {
                Toast.makeText(
                    this,
                    "Dados inválidos",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
        btnNovoCalculo.setOnClickListener {
            inputQuestion1.setText("")
            inputQuestion2.setText("")
        }
    }

    private fun validateFields(anoNascimento: String, primeiroNome: String): Boolean {
        val anoAtual = LocalDate.now().year
        var validado:Boolean = true
        if(primeiroNome.isEmpty()) {
            inputQuestion1.setError("Nome é obrigatório")
            validado = false
        }
        if(anoNascimento.isEmpty()) {
            inputQuestion2.setError("Ano de nascimento é obrigatório")
            validado = false
        } else if(anoNascimento.toInt() > anoAtual) {
            inputQuestion2.setError("Ano de nascimento tem que ser menor ou igual ao atual")
            validado = false
        }
        return validado
    }
}
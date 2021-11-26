package com.malejandro.calculodeidade.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.malejandro.calculodeidade.R

class SpashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spash)

        //avisa que vai chamar uma função após um delay
        Handler(Looper.myLooper()!!).postDelayed({
            //defini daonde eu estou (this = Splash) e para onde eu vou (MainActivity)
            val mainScreen = Intent(
                this,
                MainActivity::class.java
            )

            //manda rodar
            startActivity(mainScreen)
            //para não retornar a pagina splash
            finish()

        }, 2000)
    }
}
package com.rafaelo.alcoolougasolina

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetalhesActivity : AppCompatActivity() {

    private lateinit var textAlcool: TextView
    private lateinit var textGasolina: TextView
    private lateinit var textResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

        textAlcool = findViewById(R.id.text_alcool)
        textGasolina = findViewById(R.id.text_gasolina)
        textResultado = findViewById(R.id.text_resultado)

        val bundle = intent.extras

        if(bundle != null){
            var alcool = bundle.getString("alcool")
            var gasolina = bundle.getString("gasolina")
            var resultado: Double = alcool.toString().toDouble() / gasolina.toString().toDouble()

            textAlcool.text = "Preço do Álcool: $alcool"
            textGasolina.text = "Preço da Gasolina: $gasolina"

            if (resultado > 0.7){
                //melhor gasolina
                textResultado.text = "Gasolina"
            }else{
                //melhor alcool
                textResultado.text = "Álcool"
                textResultado.setTextColor(Color.GREEN)
            }
        }

    }
}
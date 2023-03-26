package com.rafaelo.alcoolougasolina

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var btnCalcular: Button
    private lateinit var editAlcool: EditText
    private lateinit var editGasolina: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular = findViewById(R.id.btn_calcular)
        editAlcool = findViewById(R.id.edit_alcool)
        editGasolina = findViewById(R.id.edit_gasolina)

        btnCalcular.setOnClickListener {
            if(!editAlcool.text.isNotEmpty()){
                Toast.makeText(this, "insira o preço do álcool", Toast.LENGTH_SHORT).show()
            }else if(!editGasolina.text.isNotEmpty()){
                Toast.makeText(this, "insira o preço da gasolina", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, DetalhesActivity::class.java)

                intent.putExtra("alcool", editAlcool.text.toString())
                intent.putExtra("gasolina", editGasolina.text.toString())

                startActivity(intent)

            }
        }
    }
}
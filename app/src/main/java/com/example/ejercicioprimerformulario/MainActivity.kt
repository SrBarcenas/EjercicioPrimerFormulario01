package com.example.ejercicioprimerformulario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etpPassword: EditText
    private lateinit var cbTermsConditions: CheckBox
    private lateinit var bRegister: Button
    private lateinit var tvErrorName: TextView
    private lateinit var tvErrorEmail: TextView
    private lateinit var tvErrorPassword: TextView
    private lateinit var tvErrorTermsConditions: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUI()
        listener()

        etName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                tvErrorName.visibility = View.GONE
                Log.d("Prueba", "beforeTextChanged")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d("Prueba", "onTextChanged")

            }

            override fun afterTextChanged(p0: Editable?) {
                Log.d("Prueba", "afterTextChanged")
            }
        })

        etEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                tvErrorEmail.visibility = View.GONE
                Log.d("Prueba", "beforeTextChanged")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d("Prueba", "onTextChanged")
            }

            override fun afterTextChanged(p0: Editable?) {
                Log.d("Prueba", "onTextChanged")
            }

        })

        etpPassword.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                tvErrorPassword.visibility = View.GONE
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
            }


        })
    }

    private fun setUI(){
        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etpPassword = findViewById(R.id.etpPassword)
        cbTermsConditions = findViewById(R.id.cbTermsConditions)
        bRegister = findViewById(R.id.bRegister)
        tvErrorName = findViewById(R.id.tvErrorName)
        tvErrorEmail = findViewById(R.id.tvErrorEmail)
        tvErrorPassword = findViewById(R.id.tvErrorPassword)
        tvErrorTermsConditions = findViewById(R.id.tvErrorTermsConditions)
    }

    private fun listener(){
        bRegister.setOnClickListener {
            validate()
        }
    }

    private fun validate(){
        if(etName.text.isEmpty()){
            tvErrorName.visibility = View.VISIBLE
            tvErrorName.text = "Nombre vacío"
        }

        if(etEmail.text.isEmpty()){
            tvErrorEmail.visibility = View.VISIBLE
            tvErrorEmail.text = "Correo vacío"
        }

        if(etpPassword.text.isEmpty()){
            tvErrorPassword.visibility = View.VISIBLE
            tvErrorPassword.text = "Contraseña vacía"
        }

        if(!cbTermsConditions.isChecked){
            tvErrorTermsConditions.visibility = View.VISIBLE
            tvErrorTermsConditions.text = "Debes seleccionar terminos y condiciones"
        }
    }
}
package com.example.prog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Authorisation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorisation)

        val linkToReg: Button = findViewById(R.id.crete_acc_button)
        val userFio: EditText = findViewById(R.id.user_fio_auth)
        val userPassword: EditText = findViewById(R.id.user_password_auth)
        val regButton: Button = findViewById(R.id.reg_user_button)

        linkToReg.setOnClickListener {
            val intent = Intent(this, Registration::class.java)
            startActivity(intent)
        }

        regButton.setOnClickListener {
            val fio = userFio.text.toString().trim()
            val pass = userPassword.text.toString().trim()

            if (fio == "" || pass == "")
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_SHORT).show()
            else {
                val db = DBase(this, null)
                val isAuth = db.getUser(fio, pass)

                if (isAuth){
                    Toast.makeText(this, "Пользователь $fio авторизован", Toast.LENGTH_SHORT).show()
                    userFio.text.clear()
                    userPassword.text.clear()


                    val intent = Intent(this, MainPage::class.java)
                    startActivity(intent)

                }else
                    Toast.makeText(this, "Пользователь $fio не авторизован", Toast.LENGTH_SHORT).show()

            }
        }
    }


}
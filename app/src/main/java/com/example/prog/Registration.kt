package com.example.prog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Registration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val userFio: EditText = findViewById(R.id.user_fio)
        val userRole: EditText = findViewById(R.id.user_role)
        val userPassword: EditText = findViewById(R.id.user_password)
        val regButton: Button = findViewById(R.id.reg_user_button)
        val linkToAuth: Button = findViewById(R.id.auth_acc_button)

        linkToAuth.setOnClickListener {
            val intent = Intent(this, Authorisation::class.java)
            startActivity(intent)
        }

        userRole.setOnClickListener {
            Toast.makeText(this, "Введите роль Уеник или преподаватель", Toast.LENGTH_SHORT).show()
        }

        regButton.setOnClickListener{
            val fio = userFio.text.toString().trim()
            val role = userRole.text.toString().trim()
            val pass = userPassword.text.toString().trim()

            if (fio == "" || role == "" || pass == "")
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_SHORT).show()
            else if (role == "Преподаватель" || role == "Ученик"){
                val user = User(fio, role, pass)

                val db = DBase(this, null)
                db.addUser(user)
                Toast.makeText(this, "$role $fio добавлен", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainPage::class.java)
                startActivity(intent)

                userFio.text.clear()
                userRole.text.clear()
                userPassword.text.clear()
            }
            else{
                Toast.makeText(this, "Выберите роль: Преподаватель или Ученик",
                    Toast.LENGTH_SHORT).show()
            }
        }

    }
}
package com.millenialzdev.aplikasicarehealt

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.aplikasicarehealt.HalamanUtamaActivity
import com.example.aplikasicarehealt.MainActivity
import com.example.aplikasicarehealt.RegisterActivity
import com.google.firebase.database.*

class LoginActivity : AppCompatActivity() {
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnRegister: Button
    private lateinit var btnLogin: Button

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.aplikasicarehealt.R.layout.fragment_login_activity)

        etEmail = findViewById(com.example.aplikasicarehealt.R.id.etEmail)
        etPassword = findViewById(com.example.aplikasicarehealt.R.id.etPassword)
        btnRegister = findViewById(com.example.aplikasicarehealt.R.id.btnRegister)
        btnLogin = findViewById(com.example.aplikasicarehealt.R.id.btnSignIn)

        database = FirebaseDatabase.getInstance().getReference("users")

        btnRegister.setOnClickListener {
            val registerIntent = Intent(this, RegisterActivity::class.java)
            startActivity(registerIntent)
        }

        btnLogin.setOnClickListener {
            val username = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(
                    applicationContext,
                    "Username atau Password kosong!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                database.child(username).addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        if (snapshot.exists()) {
                            val storedPassword = snapshot.child("password").getValue(String::class.java)
                            if (storedPassword == password) {
                                Toast.makeText(
                                    applicationContext,
                                    "Login Berhasil",
                                    Toast.LENGTH_SHORT
                                ).show()
                                val mainIntent = Intent(this@LoginActivity, HalamanUtamaActivity::class.java)
                                startActivity(mainIntent)
                            } else {
                                Toast.makeText(
                                    applicationContext,
                                    "Password salah!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        } else {
                            Toast.makeText(
                                applicationContext,
                                "Data belum terdaftar!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        // Handle error
                        Toast.makeText(
                            applicationContext,
                            "Database error: ${error.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                })
            }
        }
    }
}

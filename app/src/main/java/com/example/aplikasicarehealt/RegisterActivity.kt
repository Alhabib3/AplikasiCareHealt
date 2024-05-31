package com.example.aplikasicarehealt

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.millenialzdev.aplikasicarehealt.LoginActivity

class RegisterActivity : AppCompatActivity() {
    private lateinit var etRegisterEmail: EditText
    private lateinit var etRegisterPassword: EditText
    private lateinit var btnRegister: Button

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_register_activity)

        etRegisterEmail = findViewById(R.id.etRegisterEmail)
        etRegisterPassword = findViewById(R.id.etRegisterPassword)
        btnRegister = findViewById(R.id.btnRegister)

        // Mendapatkan referensi ke Firebase Realtime Database
        database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://myapplication-93c88-default-rtdb.firebaseio.com/");

        btnRegister.setOnClickListener {
            // Mendapatkan nilai dari EditText
            val email = etRegisterEmail.text.toString().trim()
            val password = etRegisterPassword.text.toString().trim()

            // Memeriksa apakah ada data yang masih kosong
            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(
                    applicationContext,
                    "Ada Data Yang Masih Kosong!!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                // Menyimpan data pengguna ke dalam Firebase Realtime Database
                saveUserData(email, password)

                // Menampilkan pesan sukses
                Toast.makeText(applicationContext, "Register Berhasil", Toast.LENGTH_SHORT).show()

                // Mengarahkan ke halaman login setelah registrasi berhasil
                val loginIntent = Intent(this@RegisterActivity, LoginActivity::class.java)
                startActivity(loginIntent)
                finish() // Menutup aktivitas pendaftaran agar tidak bisa kembali menggunakan tombol back
            }
        }

    }

    private fun saveUserData(email: String, password: String) {
        // Membuat child baru di Firebase Realtime Database dengan kunci username
        val userRef = database.child(email.replace(".", "_"))
        // Menyimpan data pengguna ke dalam child yang sesuai
        userRef.child("email").setValue(email)
        userRef.child("password").setValue(password)
    }
}

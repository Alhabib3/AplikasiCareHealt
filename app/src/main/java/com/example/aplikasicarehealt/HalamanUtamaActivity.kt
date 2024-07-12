package com.example.aplikasicarehealt

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


class HalamanUtamaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_halaman_utama)

        // Inisialisasi fragment container
        val fragmentContainer = findViewById<FrameLayout>(R.id.fragment_container)

        // Contoh logika untuk menambah fragment
        // Anda dapat mengganti ini dengan logika sesuai kebutuhan aplikasi Anda
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragment = Fragment() // Ganti dengan fragment yang sesuai
        fragmentTransaction.replace(fragmentContainer.id, fragment)
        fragmentTransaction.commit()
        // Isi dengan logika atau tampilan halaman utama Anda
    }
}

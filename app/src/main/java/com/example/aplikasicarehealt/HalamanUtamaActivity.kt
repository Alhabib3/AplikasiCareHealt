package com.example.aplikasicarehealt

import android.content.Intent
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.LinearLayout
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

        // Menambahkan listener untuk fitur Pola Makan
        val polaMakanLayout = findViewById<LinearLayout>(R.id.ll_pola_makan)
        polaMakanLayout.setOnClickListener {
            openPolaMakan()
        }

        // Menambahkan listener untuk fitur Pola Tidur
        val polaTidurLayout = findViewById<LinearLayout>(R.id.ll_pola_tidur)
        polaTidurLayout.setOnClickListener {
            openPolaTidur()
        }

        // Menambahkan listener untuk fitur Jadwal Olahraga
        val jadwalOlahragaLayout = findViewById<LinearLayout>(R.id.ll_jadwal_olahraga)
        jadwalOlahragaLayout.setOnClickListener {
            openJadwalOlahraga()
        }

        // Menambahkan listener untuk fitur Cek Stress
        val cekStressLayout = findViewById<LinearLayout>(R.id.ll_cek_stress)
        cekStressLayout.setOnClickListener {
            openCekStress()
        }
    }

    private fun openPolaMakan() {
        val intent = Intent(this, PolamakanActivity::class.java)
        startActivity(intent)
    }

    private fun openPolaTidur() {
        val intent = Intent(this, PolatidurActivity::class.java)
        startActivity(intent)
    }

    private fun openJadwalOlahraga() {
        val intent = Intent(this, JadwalOlahragaActivity::class.java)
        startActivity(intent)
    }

    private fun openCekStress() {
        val intent = Intent(this, CekstressActivity::class.java)
        startActivity(intent)
    }
}

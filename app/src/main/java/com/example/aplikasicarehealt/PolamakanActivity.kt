package com.example.aplikasicarehealt

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class PolamakanActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private lateinit var btnJadwalMakan: Button
    private lateinit var btnPanduanSehat: Button
    private lateinit var btnRiwayatMakan: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_pola_makan)

        progressBar = findViewById(R.id.nutrition_progress)
        btnJadwalMakan = findViewById(R.id.tombol_jadwal)
        btnPanduanSehat = findViewById(R.id.btn_panduan_sehat)
        btnRiwayatMakan = findViewById(R.id.btn_riwayat_makan)

        btnJadwalMakan.setOnClickListener {
            // Handle button click
        }

        btnPanduanSehat.setOnClickListener {
            // Handle button click
        }

        btnRiwayatMakan.setOnClickListener {
            // Handle button click
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // Handle home navigation
                    true
                }
                R.id.nav_menu -> {
                    // Handle menu navigation
                    true
                }
                R.id.nav_pesan -> {
                    // Handle pesan navigation
                    true
                }
                R.id.nav_favorite -> {
                    // Handle favorite navigation
                    true
                }
                R.id.nav_profil -> {
                    // Handle profil navigation
                    true
                }
                else -> false
            }
        }
    }
}

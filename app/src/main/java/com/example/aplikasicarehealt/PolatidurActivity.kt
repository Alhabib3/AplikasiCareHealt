package com.example.aplikasicarehealt

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class PolatidurActivity : AppCompatActivity() {

    private lateinit var btnJadwalTidur: Button
    private lateinit var btnPolaTidur: Button
    private lateinit var btnRiwayatTidur: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_pola_tidur)

        btnJadwalTidur = findViewById(R.id.btn_jadwal_tidur)
        btnPolaTidur = findViewById(R.id.btn_pola_tidur)
        btnRiwayatTidur = findViewById(R.id.btn_riwayat_tidur)

        btnJadwalTidur.setOnClickListener {
            // Handle button click
        }

        btnPolaTidur.setOnClickListener {
            // Handle button click
        }

        btnRiwayatTidur.setOnClickListener {
            // Handle button click
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
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

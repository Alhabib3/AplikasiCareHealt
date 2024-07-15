package com.example.aplikasicarehealt

import android.content.Intent
import android.os.Bundle
import android.widget.Button
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
                    val intent = Intent(this, HalamanUtamaActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_menu -> {
                    val intent = Intent(this, MenuActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_pesan -> {
                    val intent = Intent(this, PesanActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_favorite -> {
                    val intent = Intent(this, FavoriteActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_profil -> {
                    val intent = Intent(this, ProfilActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}

package com.example.examenextraordinariapmdm

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.net.Uri
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examenextraordinariapmdm.data.repository.PersonajeRepository
import com.example.examenextraordinariapmdm.databinding.ActivityMainBinding
import com.example.examenextraordinariapmdm.ui.main.MainViewModel
import com.example.examenextraordinariapmdm.ui.main.MainViewModelFactory
import com.example.examenextraordinariapmdm.ui.main.PersonajeAdapter
import kotlin.getValue

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory(PersonajeRepository())
    }

    private val personajeAdapter: PersonajeAdapter by lazy {
        PersonajeAdapter(
            onClickPersonaje = ::onClickPersonaje

        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setSupportActionBar(binding.toolbar)
        //configurarRecycler()


        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
    }
}
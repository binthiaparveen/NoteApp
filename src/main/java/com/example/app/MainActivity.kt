package com.example.app

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences =getSharedPreferences("NoteData",Context.MODE_PRIVATE)
        binding.save.setOnClickListener{
            val note = binding.notes.text.toString()

            val sharedEdit = sharedPreferences.edit()
            sharedEdit.putString("note",note)
            sharedEdit.apply()
            Toast.makeText(this,"Note Stored Successfully",Toast.LENGTH_SHORT).show()
            binding.notes.text.clear()
        }
        binding.display.setOnClickListener {
            val storedNote = sharedPreferences.getString("note","")
            binding.notetext.text = "$storedNote"
        }
    }
}
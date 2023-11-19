package com.magd.wuzzuf_db

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.magd.wuzzuf_db.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //links view to class
        setContentView(binding.root)

        binding.register.setOnClickListener{
            val intent = Intent(this, SkillsActivity::class.java)
            startActivity(intent)
        }

        binding.jobPostSectors.setOnClickListener{
            val intent = Intent(this, TopSectorsActivity::class.java)
            startActivity(intent)
        }

        binding.demandedSkills.setOnClickListener{
            val intent = Intent(this, TopSkillsActivity::class.java)
            startActivity(intent)
        }
    }
}
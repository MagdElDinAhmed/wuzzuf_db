package com.magd.wuzzuf_db

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.magd.wuzzuf_db.databinding.ActivitySkillsBinding


class SkillsActivity: AppCompatActivity() {
    private lateinit var binding: ActivitySkillsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySkillsBinding.inflate(layoutInflater)
        //links view to class
        setContentView(binding.root)



        binding.submitSkills.setOnClickListener{
            //Send the filled fields to the RegisterActivity
            var skills = arrayOf(binding.editTextText19.text.toString(),binding.editTextText20.text.toString(),binding.editTextText21.text.toString(),binding.editTextText22.text.toString(),binding.editTextText24.text.toString())
            val intent = Intent(this, RegisterActivity::class.java)
            intent.putExtra("skills", skills)

        }
    }
}
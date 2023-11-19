package com.magd.wuzzuf_db

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.magd.wuzzuf_db.databinding.ActivityTopSkillsBinding
import java.sql.DriverManager

class TopSkillsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTopSkillsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTopSkillsBinding.inflate(layoutInflater)
        //links view to class
        setContentView(binding.root)
        val jdbcUrl = "jdbc:mysql://db4free.net:3306/wuzzuf"
        val connection = DriverManager.getConnection(jdbcUrl, "postgres", "postgres")
        val statement = connection.prepareStatement("SELECT Skill, count(Skill) FROM requiredskills GROUP BY Skill ORDER BY count(Skill) DESC LIMIT 5;")
        val resultSet = statement.executeQuery()
        val skills = ArrayList<String>()
        while (resultSet.next()) {
            skills.add(resultSet.getString(1))
        }
        binding.skill1.text = skills[0]
        binding.skill2.text = skills[1]
        binding.skill3.text = skills[2]
        binding.skill4.text = skills[3]
        binding.skill5.text = skills[4]

        binding.button.setOnClickListener{
            this.finish()
        }


    }
}
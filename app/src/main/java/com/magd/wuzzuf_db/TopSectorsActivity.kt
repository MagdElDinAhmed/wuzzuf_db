package com.magd.wuzzuf_db

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.magd.wuzzuf_db.databinding.ActivityTopSectorsBinding
import java.sql.DriverManager

class TopSectorsActivity: AppCompatActivity() {
    private lateinit var binding: ActivityTopSectorsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTopSectorsBinding.inflate(layoutInflater)
        //links view to class
        setContentView(binding.root)
        val jdbcUrl = "jdbc:postgresql://db4free.net:3306/wuzzuf"
        val connection = DriverManager.getConnection(jdbcUrl, "postgres", "postgres")
        val statement = connection.prepareStatement("SELECT Category, COUNT(Category) FROM jobcategories GROUP BY Category ORDER BY COUNT(Category) DESC LIMIT 5;")

    }
}
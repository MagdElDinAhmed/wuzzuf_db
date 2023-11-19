package com.magd.wuzzuf_db

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.MaterialDatePicker
import com.magd.wuzzuf_db.databinding.ActivityRegisterBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.TimeZone

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    //set gender to be an empty character by default
    private var gender: Char = ' '
    val skills = intent.getStringExtra("skills")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        //links view to class
        setContentView(binding.root)

        binding.editTextDate.setOnClickListener{
            datePickerDialog()

        }

        binding.gender.setOnCheckedChangeListener { group, checkedId ->
            // Get the selected Radio Button
            val radioButton = group
                .findViewById(checkedId) as RadioButton

            // on below line we are setting
            // text for our status text view.
            if(radioButton.text == "Male"){
                gender = 'M'
            }
            else if(radioButton.text == "Female")
                gender = 'F'
        }
        binding.button2.setOnClickListener{
            val intent = Intent(this, SkillsActivity::class.java)
            startActivity(intent)

        }
    }
    private fun datePickerDialog() {
        // Creating a MaterialDatePicker builder for selecting a date

        // Building the date picker dialog
        val datePicker: MaterialDatePicker<Long> = MaterialDatePicker
            .Builder
            .datePicker()
            .setInputMode(MaterialDatePicker.INPUT_MODE_TEXT)
            .setTitleText("Select date of birth")
            .build()
        datePicker.show(supportFragmentManager, "DATE_PICKER")

        datePicker.addOnPositiveButtonClickListener {
            val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val date = sdf.format(it)
            binding.editTextDate.setText(date)
        }

    }
}
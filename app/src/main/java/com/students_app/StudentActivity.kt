package com.students_app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.students_app.databinding.ActivityStudentBinding

class StudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding = ActivityStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.backButton.setOnClickListener { finish() }

        binding.nameTextView.text = intent.getStringExtra("name")
        binding.idTextView.text = intent.getStringExtra("id")
        binding.phoneTextView.text = intent.getStringExtra("phone")
        binding.addressTextView.text = intent.getStringExtra("address")
        binding.isCheckedCheckbox.isChecked = intent.getBooleanExtra("isChecked", false)

        binding.studentImage.setImageResource(R.drawable.profile_picture)
    }
}

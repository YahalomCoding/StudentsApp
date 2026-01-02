package com.students_app

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.students_app.databinding.ActivityEditStudentBinding
import com.students_app.models.Model

class EditStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding = ActivityEditStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.backButton.setOnClickListener { finish() }

        binding.studentImage.setImageResource(R.drawable.profile_picture)

        val id = intent.getStringExtra("id")
        val student = Model.shared.students.find { student -> student.id == id }

        if (student == null) { finish() }

        binding.nameInput.setText(student?.name, TextView.BufferType.EDITABLE)
        binding.idTextView.text = student?.id
        binding.phoneInput.setText(student?.phone, TextView.BufferType.EDITABLE)
        binding.addressInput.setText(student?.address, TextView.BufferType.EDITABLE)
        binding.isCheckedCheckbox.isChecked = student?.isChecked == true

        binding.saveButton.setOnClickListener {
            val name = binding.nameInput.text.toString()
            val phone = binding.phoneInput.text.toString()
            val address = binding.addressInput.text.toString()
            val isChecked = binding.isCheckedCheckbox.isChecked

            student?.name = name
            student?.phone = phone
            student?.address = address
            student?.isChecked = isChecked

            finish()
        }

        binding.deleteButton.setOnClickListener {
            Model.shared.students.removeIf { student ->  student.id == id }
            finish()
        }

        binding.cancelButton.setOnClickListener { finish() }
    }
}

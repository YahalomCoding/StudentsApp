package com.students_app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.students_app.databinding.ActivityAddStudentBinding
import com.students_app.models.Model
import com.students_app.models.Student

class AddStudentActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()

    val binding = ActivityAddStudentBinding.inflate(layoutInflater)
    setContentView(binding.root)

    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
      val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
      insets
    }

    binding.backButton.setOnClickListener { finish() }

    binding.studentImage.setImageResource(R.drawable.profile_picture)

    binding.saveButton.setOnClickListener {
      val name = binding.nameInput.text.toString()
      val id = binding.idInput.text.toString()
      val phone = binding.phoneInput.text.toString()
      val address = binding.addressInput.text.toString()
      val isChecked = binding.isCheckedCheckbox.isChecked

      Model.shared.students.add(Student(name, id, phone, address, isChecked))

      binding.nameInput.text.clear()
      binding.idInput.text.clear()
      binding.phoneInput.text.clear()
      binding.addressInput.text.clear()
      binding.isCheckedCheckbox.isChecked = false

      finish()
    }

    binding.cancelButton.setOnClickListener { finish() }
  }
}

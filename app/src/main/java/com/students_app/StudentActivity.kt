package com.students_app

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.students_app.databinding.ActivityStudentBinding
import com.students_app.models.Model
import com.students_app.models.Student

class StudentActivity : AppCompatActivity() {
    private var student: Student? = null
    private lateinit var binding: ActivityStudentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.backButton.setOnClickListener { finish() }

        binding.editButton.setOnClickListener {
            val intent = Intent(this, EditStudentActivity::class.java)
            intent.putExtra("id", this.student?.id)
            startActivity(intent)
        }

        val id = intent.getStringExtra("id")
        this.student = Model.shared.students.find { student -> student.id == id }

        if (this.student == null) { finish() }
    }

    override fun onResume() {
        super.onResume()
        if (!Model.shared.students.any { student -> student.id == this.student?.id }) { finish() }
        binding.nameTextView.text = this.student?.name
        binding.idTextView.text = this.student?.id
        binding.phoneTextView.text = this.student?.phone
        binding.addressTextView.text = this.student?.address
        binding.isCheckedCheckbox.isChecked = this.student?.isChecked == true

        binding.studentImage.setImageResource(R.drawable.profile_picture)
    }
}

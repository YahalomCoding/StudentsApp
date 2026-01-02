package com.students_app

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import com.students_app.databinding.StudentsListRowBinding
import com.students_app.models.Student

class StudentRowViewHolder(private val binding: StudentsListRowBinding) :
    RecyclerView.ViewHolder(binding.root) {

  private lateinit var student: Student

  init {
    this.binding.checkbox.setOnClickListener { this.student.isChecked = binding.checkbox.isChecked }

    this.binding.root.setOnClickListener {
        val intent = Intent(binding.root.context, StudentActivity::class.java)
        intent.putExtra("id", student.id)
        binding.root.context.startActivity(intent)
    }
  }

  fun bind(student: Student) {
    this.student = student

    this.binding.imageView.setImageResource(R.drawable.profile_picture)
    this.binding.studentName.text = student.name
    this.binding.studentId.text = student.id
    this.binding.checkbox.isChecked = student.isChecked
  }
}

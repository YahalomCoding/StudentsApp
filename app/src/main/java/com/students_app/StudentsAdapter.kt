package com.students_app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.students_app.databinding.StudentsListRowBinding
import com.students_app.models.Student

class StudentsAdapter(private var students: List<Student>) :
    RecyclerView.Adapter<StudentRowViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentRowViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    val binding = StudentsListRowBinding.inflate(inflater, parent, false)

    return StudentRowViewHolder(binding = binding)
  }

  override fun onBindViewHolder(holder: StudentRowViewHolder, position: Int) {
    holder.bind(this.students[position])
  }

  override fun getItemCount(): Int = this.students.size
}

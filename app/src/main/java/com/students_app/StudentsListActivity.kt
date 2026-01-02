package com.students_app

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.students_app.databinding.ActivityStudentsListBinding
import com.students_app.models.Model

class StudentsListActivity : AppCompatActivity() {

  private lateinit var adapter: StudentsAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()

    val binding = ActivityStudentsListBinding.inflate(layoutInflater)
    setContentView(binding.root)

    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
      val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
      insets
    }

    binding.recyclerView.setHasFixedSize(true)

    binding.recyclerView.layoutManager = LinearLayoutManager(this)

    this.adapter = StudentsAdapter(Model.shared.students)
    binding.recyclerView.adapter = this.adapter

    binding.addButton.setOnClickListener {
      val intent = Intent(this, AddStudentActivity::class.java)
      startActivity(intent)
    }
  }

  override fun onResume() {
    super.onResume()
    this.adapter.notifyDataSetChanged()
  }
}

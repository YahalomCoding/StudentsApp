package com.students_app.models

class Model private constructor() {

  val students = mutableListOf<Student>()

  companion object {
    val shared = Model()
  }
}

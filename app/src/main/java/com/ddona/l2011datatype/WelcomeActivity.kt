package com.ddona.l2011datatype

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ddona.l2011datatype.databinding.ActivityWelcomeBinding
import com.ddona.l2011datatype.db.StudentManager
import com.ddona.l2011datatype.model.Student

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val studentManager = StudentManager(this)

        binding.btnAdd.setOnClickListener {
            val name = binding.edtName.text.toString()
            val age = binding.edtAge.text.toString()
            val className = binding.edtClassName.text.toString()
            studentManager.addStudent2(
                Student(
                    name = name,
                    age = age.toInt(),
                    className = className
                )
            )
        }
        binding.btnDelete.setOnClickListener {
            val id = binding.edtId.text.toString()
            studentManager.deleteStudentById2(id.toInt())
        }
        binding.btnEdit.setOnClickListener {
            val id = binding.edtId.text.toString()
            val name = binding.edtName.text.toString()
            val age = binding.edtAge.text.toString()
            val className = binding.edtClassName.text.toString()
            studentManager.updateStudent2(Student(id.toInt(), name, age.toInt(), className))
        }
        val students = studentManager.getAllStudent2()
        Log.d("doanpt", "All student:${students.size}")
    }
}
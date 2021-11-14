package com.ddona.l2011datatype

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ddona.l2011datatype.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val prefers = getSharedPreferences("setting_app", MODE_PRIVATE)
        val account = prefers.getString("account", "")
        val password = prefers.getString("password", "")
        if (account!!.isNotEmpty() && password!!.isNotEmpty()) {
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLogin.setOnClickListener {
            val username = binding.edtUsername.text.toString()
            val password = binding.edtPassword.text.toString()
            if (username == "doanpt" && password == "123") {
                val editor = prefers.edit()
                editor.putString("account", username)
                editor.putString("password", password)
                editor.apply()
                val intent = Intent(this, WelcomeActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
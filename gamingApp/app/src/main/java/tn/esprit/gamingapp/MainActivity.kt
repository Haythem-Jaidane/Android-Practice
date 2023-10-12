package tn.esprit.gamingapp

import android.R.attr
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.content.Intent


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val register:TextView = findViewById(R.id.textView4)
        val forgetPassword:TextView = findViewById(R.id.textView)

        register.setOnClickListener {
            var intent = Intent(this,LogIn::class.java)
            startActivity(intent)
            finish()
        }

        forgetPassword.setOnClickListener {
            var intent = Intent(this,ForgetPassword::class.java)
            startActivity(intent)
            finish()
        }
    }
}
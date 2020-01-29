package io.seroo.androidproblem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.seroo.androidproblem.databinding.ActivityMainBinding

class B_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tv.text = "B"
        binding.tv.setOnClickListener {
            Intent(this@B_Activity, C_Activity::class.java)
                .also(::startActivity)
        }
    }
}

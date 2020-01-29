package io.seroo.androidproblem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.seroo.androidproblem.databinding.ActivityMainBinding

class C_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tv.text = "C"
        binding.tv.setOnClickListener {
            Intent(this@C_Activity, D_Activity::class.java)
                .also(::startActivity)
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        Log.d("GYH", "onNewIntent : C")
    }
}

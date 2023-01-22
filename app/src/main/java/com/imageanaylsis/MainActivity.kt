package com.imageanaylsis

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.imageanaylsis.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(LayoutInflater)
        setContentView(binding.root)

        if (allPermisionGranted()){
            Toast.makeText(this,
            "We Have Permission",
            Toast.LENGTH_SHORT).show()
        } else {
            ActivityCompat.requestPermissions(
                this, Constants.REQUIRED_PERMISSIONS,
                Constants.REQUEST_CODE_PERMISSIONS
            )
        }
    }

    private fun allPermisionGranted() =
        Constants.REQUIRED_PERMISSIONS.all {
            ContextCompat.checkSelfPermission(
                baseContext, it
            ) == PackageManager.PERMISSION_GRANTED
        }



    @RequiresApi (value = 26 )
    class PreviewView : FrameLayout
}
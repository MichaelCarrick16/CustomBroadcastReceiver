package com.example.custombroadcastreceiver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var firstFragment : FirstFragment = FirstFragment()
        var secondFragment : SecondFragment = SecondFragment()
        var fragmentTransaction  = supportFragmentManager.beginTransaction()
        var fragmentTransaction1 = supportFragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.frame_layout_1,firstFragment)
        fragmentTransaction.commit()

        fragmentTransaction1.replace(R.id.frame_layout_2,secondFragment)
        fragmentTransaction1.commit()
    }
}
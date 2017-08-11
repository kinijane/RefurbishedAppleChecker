package com.janeproject.refurbishedapplechecker.Activity

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import com.janeproject.refurbishedapplechecker.Fragment.TopFragment
import com.janeproject.refurbishedapplechecker.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(FrameLayout(this))
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            window.navigationBarColor = R.color.colorPrimaryDark
        }
        supportFragmentManager.beginTransaction().replace(android.R.id.content, TopFragment()).commit()
    }
}

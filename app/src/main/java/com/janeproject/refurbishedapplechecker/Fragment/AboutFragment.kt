package com.janeproject.refurbishedapplechecker.Fragment


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.janeproject.refurbishedapplechecker.BuildConfig

import com.janeproject.refurbishedapplechecker.R
import kotlinx.android.synthetic.main.fragment_about.*


/**
 * このアプリについて
 */
class AboutFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater!!.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        view?.setOnKeyListener { _, keyCode, _ ->
            when(keyCode){
                KeyEvent.KEYCODE_BACK -> finishThisFragment()
            }
            false
        }
    }

    /**
     * ビュー生成
     */
    fun initView(){
        val versionText:String = "Version " + BuildConfig.VERSION_NAME
        version.text = versionText
        icon.setOnClickListener { Toast.makeText(context,"('ω`)Nyowaaaa", Toast.LENGTH_SHORT).show() }
        github_button.setOnClickListener { openBrowser(getString(R.string.github_url)) }
        googleplay_button.setOnClickListener { openBrowser(getString(R.string.my_google_play_url)) }

    }

    /**
     * 外部ブラウザを開く
     * @param url URL
     */
    fun openBrowser(url:String) {
        val uri:Uri = Uri.parse(url)
        val intent:Intent = Intent(Intent.ACTION_VIEW,uri)
        activity.startActivity(intent)
    }

    /**
     * このフラグメントを終了させる
     */
    protected fun finishThisFragment() {
        if (fragmentManager.backStackEntryCount != 0) {
            fragmentManager.popBackStack()
            val ft = fragmentManager.beginTransaction()
            ft.remove(this).commit()
        }
    }


}
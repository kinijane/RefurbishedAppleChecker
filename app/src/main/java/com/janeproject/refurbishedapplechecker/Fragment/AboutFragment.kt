package com.janeproject.refurbishedapplechecker.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

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

    }

    /**
     * ビュー生成
     */
    fun initView(){
        toolbar.setTitle(R.string.app_name)
        toolbar.setTitleTextColor(R.color.black)


    }



}
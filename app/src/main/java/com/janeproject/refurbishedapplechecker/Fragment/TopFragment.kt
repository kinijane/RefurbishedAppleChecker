package com.janeproject.refurbishedapplechecker.Fragment

import android.net.Uri
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.janeproject.refurbishedapplechecker.Logic.TopLogic

import com.janeproject.refurbishedapplechecker.R
import kotlinx.android.synthetic.main.fragment_top.*
import kotlinx.android.synthetic.main.parts_button.view.*


/**
 * トップ画面のFragment
 */
class TopFragment : Fragment() {

    private var mTopLogic:TopLogic? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_top, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initLogic()
    }

    fun initView(){
        ipod_touch_button.buttonImage.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ipod_touch))
        ipod_touch_button.buttonText.setText(R.string.ipod_touch)
        ipad_button.buttonImage.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ipad))
        ipad_button.buttonText.setText(R.string.ipad)
        mac_button.buttonImage.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.mac))
        mac_button.buttonText.setText(R.string.mac)
        clearance_button.buttonImage.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.clearance))
        clearance_button.buttonText.setText(R.string.clearance)
        iphone_button.buttonImage.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.iphone))
        iphone_button.buttonText.setText(R.string.iphone)

    }

    fun initLogic(){
        mTopLogic = TopLogic(context)
        ipod_touch_button.setOnClickListener { _ -> }

    }

    fun generateCustomTab(url:String){
        val customTabIntentBuilder:CustomTabsIntent.Builder = CustomTabsIntent.Builder()
        val customTabIntent:CustomTabsIntent = customTabIntentBuilder.build()
        customTabIntent.launchUrl(context, Uri.parse(url))

    }


}
package com.janeproject.refurbishedapplechecker.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.janeproject.refurbishedapplechecker.Logic.TopLogic

import com.janeproject.refurbishedapplechecker.R


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
        initLogic()
    }

    fun initLogic(){
        mTopLogic = TopLogic(activity.baseContext)

    }




}
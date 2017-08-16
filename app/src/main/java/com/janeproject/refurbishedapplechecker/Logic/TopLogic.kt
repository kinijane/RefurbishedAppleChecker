package com.janeproject.refurbishedapplechecker.Logic

import android.content.Context
import com.janeproject.refurbishedapplechecker.R

/**
 * メニュー画面の処理
 */
class TopLogic (context : Context){

    val mContext = context

    /**
     * 商品紹介のURL生成
     * @param product 商品名
     */
    fun urlGenerate(product : ProductName) : String  = when(product) {
        ProductName.IPOD_TOUCH -> mContext.getString(R.string.ipod_touch_url, getCountryUrlParts())
        ProductName.IPAD -> mContext.getString(R.string.ipad_url, getCountryUrlParts())
        ProductName.MAC -> mContext.getString(R.string.mac_url, getCountryUrlParts())
        ProductName.CLEARANCE -> mContext.getString(R.string.clearance_url, getCountryUrlParts())
        ProductName.IPHONE -> mContext.getString(R.string.iphone_url, getCountryUrlParts())
    }

    /**
     * 今のところJPのみ返却
     * todo:国際化対応
     * @return 国ごとのURL
     */
    private fun getCountryUrlParts() : String{
        return "jp/"
    }


}

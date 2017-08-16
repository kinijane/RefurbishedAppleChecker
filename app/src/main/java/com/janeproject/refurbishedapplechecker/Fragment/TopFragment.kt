package com.janeproject.refurbishedapplechecker.Fragment

import android.net.Uri
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.*
import com.janeproject.refurbishedapplechecker.Logic.ProductName
import com.janeproject.refurbishedapplechecker.Logic.TopLogic

import com.janeproject.refurbishedapplechecker.R
import kotlinx.android.synthetic.main.fragment_top.*
import kotlinx.android.synthetic.main.parts_button.view.*


/**
 * トップ画面のFragment
 */
class TopFragment : Fragment() {

    //メニュー処理
    private var mTopLogic:TopLogic? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_top, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initLogic()
        initToolbar()
    }

    /**
     * ビュー生成
     */
    fun initView(){
        toolbar.setTitle(R.string.app_name)
        toolbar.setTitleTextColor(R.color.black)
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

    /**
     * メイン処理
     */
    fun initLogic(){
        mTopLogic = TopLogic(context)
        ipod_touch_button.setOnClickListener { _ -> generateCustomTab(ProductName.IPOD_TOUCH)}
        ipad_button.setOnClickListener { _ -> generateCustomTab(ProductName.IPAD)}
        mac_button.setOnClickListener { _ -> generateCustomTab(ProductName.MAC)}
        clearance_button.setOnClickListener { _ -> generateCustomTab(ProductName.CLEARANCE)}
        iphone_button.setOnClickListener { _ -> generateCustomTab(ProductName.IPHONE)}

    }

    /**
     * ツールバーの初期処理
     */
    fun initToolbar(){
        var submenu:SubMenu = toolbar.menu.addSubMenu(Menu.NONE, 0,0,getString(R.string.about))
        submenu.setIcon(R.mipmap.ic_help_black_24dp)
        toolbar.menu.getItem(0).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
        toolbar.setOnMenuItemClickListener { menuItem ->
            when(menuItem.itemId) {
                0 -> transitionPage(AboutFragment())
            }
            false
        }
    }

    /**
     * Chromeカスタムビュー生成
     * @param product 商品名
     */
    fun generateCustomTab(product:ProductName){
        val url:String = mTopLogic!!.urlGenerate(product)
        val customTabIntentBuilder:CustomTabsIntent.Builder = CustomTabsIntent.Builder()
        val customTabIntent:CustomTabsIntent = customTabIntentBuilder.build()
        customTabIntent.launchUrl(context, Uri.parse(url))
    }

    /**
     * ページヘ遷移する
     * @param fragment 遷移先のページ
     */
    fun transitionPage(fragment : Fragment){
        val ft = fragmentManager.beginTransaction()
        //置き換える画面
        ft.replace(android.R.id.content, fragment)
        //終わる前に今の画面を追加
        ft.addToBackStack(javaClass.simpleName).commit()
    }


}
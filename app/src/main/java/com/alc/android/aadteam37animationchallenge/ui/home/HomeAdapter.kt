package com.alc.android.aadteam37animationchallenge.ui.home

import android.graphics.Outline
import android.os.Build
import android.view.View
import android.view.ViewOutlineProvider
import androidx.core.content.ContextCompat
import com.alc.android.aadteam37animationchallenge.R
import com.alc.android.aadteam37animationchallenge.base.adapter.BaseAdapter
import com.alc.android.aadteam37animationchallenge.base.adapter.BaseViewHolder
import com.alc.android.aadteam37animationchallenge.model.MainItem
import kotlinx.android.synthetic.main.item_main.*

class HomeAdapter(
    override var dataSet: ArrayList<MainItem>
) : BaseAdapter<MainItem, HomeAdapter.MenuViewHolder>() {

    override fun createViewHolder(view: View): MenuViewHolder = MenuViewHolder(view)

    override fun getLayoutIdForPosition(position: Int): Int = R.layout.item_main

    inner class MenuViewHolder(view: View) : BaseViewHolder<MainItem>(view) {

        override fun bind(item: MainItem) {
            container.setBackgroundResource(item.background)
            icon.setImageDrawable(ContextCompat.getDrawable(icon.context, item.icon))
            title.setText(item.title)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                container.outlineProvider = object : ViewOutlineProvider() {
                    override fun getOutline(view: View, outline: Outline?) {
                        outline?.setRoundRect(
                            0,
                            0,
                            view.width,
                            view.height,
                            container.context.resources.getDimension(R.dimen.space_normal)
                        )
                    }
                }
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                container.clipToOutline = true
            }
        }
    }
}
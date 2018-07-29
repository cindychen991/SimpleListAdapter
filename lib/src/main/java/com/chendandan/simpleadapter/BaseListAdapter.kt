package com.chendandan.simpleadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.chendandan.simpleadapter.util.BaseViewHolder
import com.chendandan.simpleadapter.util.ItemHolderCreator
import java.util.ArrayList

/**
 * Created by CDD on 2018/7/29.
 */
abstract class BaseListAdapter<T, H : BaseViewHolder> : BaseAdapter, ItemHolderCreator<T, H> {

    open var mList: MutableList<T>
    open var mContext: Context
    open var mInflater: LayoutInflater

    constructor(context: Context) : this(context, null)

    constructor(context: Context, list: MutableList<T>?) {
        mContext = context
        mList = list ?: ArrayList()
        mInflater = LayoutInflater.from(context)
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val holderHelper: H = if (convertView == null) {
            createHolderHelper(getItemViewType(position), parent).apply {
                convertView = mItemView
                convertView?.tag = this
            }
        } else {
            convertView?.tag as H
        }
        bindData(position, holderHelper, mList[position])
        return convertView!!
    }
}
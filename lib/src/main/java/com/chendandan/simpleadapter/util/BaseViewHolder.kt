package com.chendandan.simpleadapter.util

import android.support.annotation.DrawableRes
import android.support.annotation.IdRes
import android.util.SparseArray
import android.view.View
import android.widget.Checkable
import android.widget.CompoundButton
import android.widget.TextView

/**
 * Created by CDD on 2018/7/29.
 */
open class BaseViewHolder {

    open lateinit var mItemView: View
    open val holderViews: SparseArray<View> by lazy {
        SparseArray<View>()
    }

    fun BaseViewHolder(convertView: View?) {
        if (convertView == null) {
            throw NullPointerException("convertView can not be null !")
        }
        mItemView = convertView
    }

    /**
     * 查找并缓存View
     * @param viewId 需要查找的 view id
     * @return View
     */
    fun <V : View> findViewById(@IdRes viewId: Int): V {
        return (if (holderViews.get(viewId) == null) {
            val result: View = mItemView.findViewById(viewId)
            holderViews.put(viewId, result)
            result
        } else {
            holderViews.get(viewId)
        }) as V
    }

    fun setText(@IdRes viewId: Int, content: String? = ""): BaseViewHolder {
        findViewById<TextView>(viewId)?.apply {
            text = content
        }
        return this
    }

    fun setBackground(@IdRes viewId: Int, @DrawableRes background: Int): BaseViewHolder {
        findViewById<View>(viewId)?.apply {
            setBackgroundResource(background)
        }
        return this
    }

    fun setChecked(@IdRes viewId: Int, checked: Boolean): BaseViewHolder {
        findViewById<View>(viewId)?.apply {
            if (this is Checkable) {
                isChecked = checked
            }
        }
        return this
    }

    fun setOnCheckedChangeListener(@IdRes viewId: Int, onCheckChangeListener: CompoundButton.OnCheckedChangeListener): BaseViewHolder {
        findViewById<CompoundButton>(viewId)?.apply {
            setOnCheckedChangeListener(onCheckChangeListener)
        }
        return this
    }

    fun setOnItemClickListener(onItemClickListener: View.OnClickListener): BaseViewHolder {
        mItemView.setOnClickListener(onItemClickListener)
        return this
    }

}
package com.chendandan.listadapter.adapter

import android.content.Context
import android.view.ViewGroup
import android.widget.TextView
import com.chendandan.listadapter.R
import com.chendandan.simpleadapter.BaseListAdapter
import com.chendandan.simpleadapter.util.BaseViewHolder

/**
 * Created by CDD on 2018/7/30.
 */
class ListAdapter(context: Context, list: MutableList<String>?) : BaseListAdapter<String, BaseViewHolder>(context, list) {

    constructor(context: Context) : this(context, null)

    override fun createHolderHelper(viewType: Int, parent: ViewGroup): BaseViewHolder {
        return BaseViewHolder(mInflater.inflate(R.layout.item_list, parent, false))
    }

    override fun bindData(position: Int, holder: BaseViewHolder, data: String?) {
        if (data == null) {
            return
        }
        holder.findViewById<TextView>(R.id.tv_title).text = data
    }
}
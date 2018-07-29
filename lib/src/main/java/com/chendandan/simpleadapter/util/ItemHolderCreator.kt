package com.chendandan.simpleadapter.util

import android.view.ViewGroup

/**
 * Created by CDD on 2018/7/29.
 */
interface ItemHolderCreator<T, H : BaseViewHolder> {

    /**
     * 根据 type 构建指定的 BaseViewHolder
     *
     * @param viewType position 对应的 viewType，
     * 对应[android.widget.BaseAdapter] getItemViewType(int position) 的值。
     * @param parent  The parent that this view will eventually be attached to
     * @return 创建的 holder
     */
    fun createHolderHelper(viewType: Int, parent: ViewGroup): H

    /**
     * 绑定数据，设置内容视图
     *
     * @param position 在 list 中的位置
     * @param holder   该 item 对应的 holder
     */
    fun bindData(position: Int, holder: H, data: T?)
}

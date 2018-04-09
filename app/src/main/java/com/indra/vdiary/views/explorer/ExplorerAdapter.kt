package com.indra.vdiary.views.explorer

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.indra.vdiary.R
import com.indra.vdiary.data.Message
import com.indra.vdiary.views.inflate
import kotlinx.android.synthetic.main.item_explorer.view.*

/**
 * Created by indra.dutt on 3/22/18.
 */
class ExplorerAdapter(val list : List<Message>, val listener : (Message) -> Unit)
    : RecyclerView.Adapter<ExplorerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(parent.inflate(R.layout.item_explorer))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(list[position], listener)

    override fun getItemCount(): Int = list.size

    class ViewHolder(val view : View) : RecyclerView.ViewHolder(view) {
        fun bind(msg: Message, listener: (Message) -> Unit) = with(view) {
            title_textView.text = msg.title
            setOnClickListener { listener(msg) }
        }
    }
}
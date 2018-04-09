package com.indra.vdiary.views.explorer

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.indra.vdiary.R
import com.indra.vdiary.data.Content
import com.indra.vdiary.data.Message
import com.indra.vdiary.data.TextMessage
import com.indra.vdiary.viewmodels.explorer.ExplorerViewModel
import com.indra.vdiary.views.inflate
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*

/**
 * Created by indra.dutt on 3/20/18.
 */
class ExplorerFragment : Fragment() {
    companion object {
        private val TAG = "ExplorerFragment"
        private val COLUMN_COUNT = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // We can inject here: DI
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.fragment_home)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //val explorerVM = ViewModelProviders.of(this)[ExplorerViewModel::class.java]
        // ==>> becomes when using reified
        val explorerVM = getViewModel<ExplorerViewModel>()
        explorerVM.contentList.observe(this, Observer(this::updateList))
        initViews()
    }

    override fun onResume() {
        super.onResume()
    }

    private val blogList by lazy {
        blog_list
    }

    private fun initViews() {
        blogList.setHasFixedSize(true)
        blogList.layoutManager = GridLayoutManager(context, COLUMN_COUNT)

        blogList.adapter = ExplorerAdapter(createFakeData()) {
            Toast.makeText(context, "${it.title} clicked!", Toast.LENGTH_SHORT).show()
        }

    }

    private fun updateList(list : List<Content>?) {
        list?.let {
            // create adapter and set it here
        }
    }

    private inline fun <reified T : ViewModel> getViewModel() : T {
        return ViewModelProviders.of(this)[T::class.java]
    }

    private fun createFakeData() : List<Message> {
        val list = ArrayList<Message>()
        list.add(TextMessage("", "Hello world!", Date(), Date(), "", ""))
        list.add(TextMessage("", "Here I am", Date(), Date(), "", ""))
        list.add(TextMessage("", "Hello world!", Date(), Date(), "", ""))
        list.add(TextMessage("", "Here I am", Date(), Date(), "", ""))
        list.add(TextMessage("", "Hello world!", Date(), Date(), "", ""))
        list.add(TextMessage("", "Here I am", Date(), Date(), "", ""))
        list.add(TextMessage("", "Hello world!", Date(), Date(), "", ""))
        list.add(TextMessage("", "Here I am", Date(), Date(), "", ""))
        list.add(TextMessage("", "Hello world!", Date(), Date(), "", ""))
        list.add(TextMessage("", "Here I am", Date(), Date(), "", ""))
        list.add(TextMessage("", "Hello world!", Date(), Date(), "", ""))
        list.add(TextMessage("", "Here I am", Date(), Date(), "", ""))
        list.add(TextMessage("", "Hello world!", Date(), Date(), "", ""))
        list.add(TextMessage("", "Here I am", Date(), Date(), "", ""))
        list.add(TextMessage("", "Hello world!", Date(), Date(), "", ""))
        list.add(TextMessage("", "Here I am", Date(), Date(), "", ""))
        return list
    }
}
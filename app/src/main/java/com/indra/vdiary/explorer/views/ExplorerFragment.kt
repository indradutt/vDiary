package com.indra.vdiary.explorer.views

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
import com.indra.vdiary.common.data.Content
import com.indra.vdiary.explorer.viewmodel.ExplorerViewModel
import com.indra.vdiary.utils.inflate
import kotlinx.android.synthetic.main.fragment_home.*

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
        explorerVM.getExplorerList()?.observe(this, Observer(this::updateList))
    }

    override fun onResume() {
        super.onResume()
    }

    private val blogList by lazy {
        blog_list
    }

    private fun updateList(list : List<Content>?) {
        list?.let {
            blogList.setHasFixedSize(true)
            blogList.layoutManager = GridLayoutManager(context, COLUMN_COUNT)

            blogList.adapter = ExplorerAdapter(list) {
                Toast.makeText(context, "${it.title} clicked!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private inline fun <reified T : ViewModel> getViewModel() : T {
        return ViewModelProviders.of(this)[T::class.java]
    }
}
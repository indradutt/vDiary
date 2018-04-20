package com.indra.vdiary.explorer.views

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.indra.vdiary.DiaryApp
import com.indra.vdiary.R
import com.indra.vdiary.common.data.Content
import com.indra.vdiary.di.subcomponents.ExplorerModule
import com.indra.vdiary.explorer.viewmodel.ExplorerViewModel
import com.indra.vdiary.utils.inflate
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

/**
 * Created by indra.dutt on 3/20/18.
 */
class ExplorerFragment : Fragment() {
    @Inject lateinit var factory: ViewModelProvider.Factory

    companion object {
        private val TAG = "ExplorerFragment"
        private val COLUMN_COUNT = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // We can inject here: DI
        component.injectTo(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.fragment_home)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //val explorerVM = ViewModelProviders.of(this)[ExplorerViewModel::class.java]
        // ==>> becomes when using reified
        val explorerVM = getViewModel<ExplorerViewModel>()

        explorerVM.getExplorerList()?.observe(this, Observer(this::updateList))

        explorerVM.getRecentContentList()?.observe(this, Observer(this::updateRecentList))

        //explorerVM.getDraftList()?.observe(this, Observer(this::updateDraftList))
    }

    override fun onResume() {
        super.onResume()
    }

    private val component by lazy {
        val app = activity?.application as DiaryApp
        app.component.plus(ExplorerModule())
    }

    private val blogListAll by lazy {
        blog_listAll
    }

    private val blogListRecent by lazy {
        blog_listRecent
    }

    private val blogListDraft by lazy {
        blog_listDrafts
    }

    private fun updateList(list : List<Content>?) {
        list?.let {
            blogListAll.setHasFixedSize(true)
            blogListAll.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

            blogListAll.adapter = ExplorerAdapter(list) {
                Toast.makeText(context, "${it.title} clicked!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun updateRecentList(list : List<Content>?) {
        list?.let {
            blogListRecent.setHasFixedSize(true)
            blogListRecent.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

            blogListRecent.adapter = ExplorerAdapter(list) {
                Toast.makeText(context, "${it.title} clicked!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun updateDraftList(list : List<Content>?) {
        list?.let {
            blogListDraft.setHasFixedSize(true)
            blogListDraft.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

            blogListDraft.adapter = ExplorerAdapter(list) {
                Toast.makeText(context, "${it.title} clicked!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private inline fun <reified T : ViewModel> getViewModel() : T {
        return ViewModelProviders.of(this, factory)[T::class.java]
    }
}
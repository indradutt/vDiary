package com.indra.vdiary.explorer.views

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.FloatingActionButton
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
import android.support.annotation.NonNull
import com.indra.vdiary.R.id.fab
import android.support.v4.view.ViewCompat.animate
import android.R.attr.scaleX
import android.R.attr.scaleY
import android.util.Log


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

        initializeFloatingBtn()
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

    private fun initializeFloatingBtn() {
        val fab: FloatingActionButton? = this.view?.findViewById(R.id.fab)
        val bottomLayout : View? = this.view?.findViewById(R.id.anchored_options)
        val bottomSheetBehavior = BottomSheetBehavior.from(bottomLayout)

        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED

        // set the peek height
        bottomSheetBehavior.peekHeight = 20

        // set hideable or not
        bottomSheetBehavior.isHideable = true

        bottomSheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {

                // this part hides the button immediately and waits bottom sheet
                // to collapse to show
                Log.d("Indra", "state = "+newState)
                if (BottomSheetBehavior.STATE_HIDDEN == newState ||
                        BottomSheetBehavior.STATE_COLLAPSED == newState) {
                    Log.d("Indra", "collapsed")
                    fab?.visibility = View.VISIBLE
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
        });
        fab?.setOnClickListener( { _ ->
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            fab?.visibility = View.GONE
        })
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
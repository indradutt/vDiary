package com.indra.vdiary.explorer.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.indra.vdiary.common.data.Content
import com.indra.vdiary.explorer.model.ExplorerRepo

/**
 * Created by indra.dutt on 4/9/18.
 */
class ExplorerViewModel : ViewModel() {
    private val contentList : LiveData<List<Content>>?
    private val explorerRepo : ExplorerRepo?

    init {
        explorerRepo = ExplorerRepo()  //FIXME: use di
        contentList = MutableLiveData<List<Content>>()
        contentList.postValue(null)

        val explorerList = explorerRepo?.getExplorerList()
        contentList.postValue(explorerList?.value)
    }

    fun getExplorerList() : LiveData<List<Content>>? {
        return contentList
    }
}
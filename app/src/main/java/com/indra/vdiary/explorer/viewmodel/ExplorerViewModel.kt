package com.indra.vdiary.explorer.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.indra.vdiary.common.data.Content
import com.indra.vdiary.explorer.model.ExplorerRepo
import javax.inject.Inject

/**
 * Created by indra.dutt on 4/9/18.
 */
class ExplorerViewModel @Inject constructor(private var explorerRepo: ExplorerRepo)
    : ViewModel() {
    private val contentListAll: LiveData<List<Content>>?
    private val contentListRecent : LiveData<List<Content>>?
    private val contentListDraft : LiveData<List<Content>>?

    init {
        contentListAll = MutableLiveData<List<Content>>()
        contentListRecent = MutableLiveData<List<Content>>()
        contentListDraft = MutableLiveData<List<Content>>()

        val explorerList = explorerRepo?.getExplorerList()
        contentListAll.postValue(explorerList?.value)

        val recentList = explorerRepo?.getRecentList()
        contentListRecent.postValue(recentList?.value)

        val draftList = explorerRepo?.getDraftList()
        contentListDraft.postValue(draftList?.value)
    }

    fun getExplorerList() : LiveData<List<Content>>? {
        return contentListAll
    }

    fun getRecentContentList() : LiveData<List<Content>>? {
        return contentListRecent
    }

    fun getDraftList() : LiveData<List<Content>>? {
        return contentListDraft
    }
}
package com.indra.vdiary.ui.explorer

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.indra.vdiary.explorer.model.ExplorerRepo
import com.indra.vdiary.explorer.viewmodel.ExplorerViewModel
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner


/**
 * Created by indra.dutt on 4/17/18.
 */
@RunWith(MockitoJUnitRunner::class)
class ExplorerViewModelTest {
    private lateinit var explorerViewModel : ExplorerViewModel

    @Mock
    lateinit var repo: ExplorerRepo

    // LiveData set/post value will force code to run on UI thread and that is not mocked, you will have to deal with RunTimeException (https://medium.com/pxhouse/unit-testing-with-mutablelivedata-22b3283a7819)
    // @Rule does not work for kotlin rather we need to annotate @get:Rule (well my world my rules)
    @get:Rule
    var testRule : TestRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        explorerViewModel = ExplorerViewModel(repo)
    }

    @Test
    fun testNotNull() {
        assertNotNull(explorerViewModel.getDraftList())
        assertNotNull(explorerViewModel.getRecentContentList())
        assertNotNull(explorerViewModel.getExplorerList())
    }
}
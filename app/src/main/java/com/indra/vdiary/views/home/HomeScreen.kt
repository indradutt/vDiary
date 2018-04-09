package com.indra.vdiary.views.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.indra.vdiary.R
import com.indra.vdiary.views.explorer.ExplorerFragment

/**
 * Created by indra.dutt on 3/19/18.
 */
class HomeScreen : AppCompatActivity() {
    private val TAG = "HomeScreen"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        if (savedInstanceState == null) {
            displayExplorer()
        }
    }

    private fun displayExplorer() {
        val transaction = supportFragmentManager.beginTransaction()
        var fragment = supportFragmentManager.findFragmentByTag(TAG) as ExplorerFragment?

        if (fragment == null) {
            fragment = ExplorerFragment()
        }
        transaction.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out,
                R.anim.abc_popup_enter, R.anim.abc_popup_exit)
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onBackPressed() {
        val fragmentManager = supportFragmentManager
        if (fragmentManager.backStackEntryCount > 1) {
            fragmentManager.popBackStack()
        } else {
            finish()
        }
    }
}
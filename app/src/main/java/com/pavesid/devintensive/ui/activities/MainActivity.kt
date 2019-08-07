package com.pavesid.devintensive.ui.activities

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.snackbar.Snackbar
import com.pavesid.devintensive.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(){

//    lateinit var iV: ImageView
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var toolbar: Toolbar
    lateinit var navigationDrawer: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("M_MainActivity", "onCreate")

//        iV = call_img
//        iV.setOnClickListener {
//            showProgress()
//            runWithDelay()
//        }

        coordinatorLayout = main_coordinator_container
        toolbar = wToolbar

        navigationDrawer = navigation_drawer

        setupToolbar()
        setupDrawer()

        if(savedInstanceState == null){
//            showSnackBar("Activity starts for the first time")
        } else{
//            showSnackBar("Not the first time launch activity")
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("M_MainActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("M_MainActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("M_MainActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("M_MainActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("M_MainActivity", "onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        Log.d("M_MainActivity", "onSaveInstanceState")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            navigationDrawer.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }

    fun showSnackBar(message: String){
        //Возможно повесить обработчик
        Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_LONG).show()
    }

    private fun setupToolbar(){
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        if(actionBar != null){
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp)
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun setupDrawer(){
        var navigationView = navigation_view
        navigationView.setNavigationItemSelectedListener {
            showSnackBar(it.title.toString())
            it.isChecked = true
            navigationDrawer.closeDrawer(GravityCompat.START)
            false
        }
    }

//    fun runWithDelay(){
//        var handler = Handler()
//        handler.postDelayed({
//            hideProgress()
//        }, 5000)
//    }
}

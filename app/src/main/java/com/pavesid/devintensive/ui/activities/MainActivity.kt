package com.pavesid.devintensive.ui.activities

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.pavesid.devintensive.R
import com.pavesid.devintensive.data.managers.DataManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(){
    companion object{
        var EDIT_MODE = "EDIT_MODE"
    }

    private var currentEditMode = false

//    lateinit var iV: ImageView
    private lateinit var coordinatorLayout: CoordinatorLayout
    private lateinit var toolbar: Toolbar
    private lateinit var navigationDrawer: DrawerLayout
    private lateinit var floatingActionButton: FloatingActionButton
    private lateinit var userPhone: EditText
    private lateinit var userMail: EditText
    private lateinit var userVk: EditText
    private lateinit var userGit: EditText
    private lateinit var userBio: EditText

    private lateinit var dataManager: DataManager

    private lateinit var userInfoViews: ArrayList<EditText>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("M_MainActivity", "onCreate")

//        iV = call_img
//        iV.setOnClickListener {
//            showProgress()
//            runWithDelay()
//        }

        dataManager = DataManager

        coordinatorLayout = main_coordinator_container
        toolbar = wToolbar

        navigationDrawer = navigation_drawer
        floatingActionButton = fab

        userPhone = et_phone
        userVk = et_vk
        userMail = et_email
        userGit = et_github
        userBio = et_about

        userInfoViews = ArrayList()

        userInfoViews.add(userPhone)
        userInfoViews.add(userMail)
        userInfoViews.add(userVk)
        userInfoViews.add(userGit)
        userInfoViews.add(userBio)

        if(savedInstanceState == null){
            currentEditMode = false
//            showSnackBar("Activity starts for the first time")
            changeEditMode(currentEditMode)
        } else{
//            showSnackBar("Not the first time launch activity")
            currentEditMode = savedInstanceState.getBoolean(EDIT_MODE, false)
            changeEditMode(currentEditMode)
        }

        floatingActionButton.setOnClickListener {
//            showSnackBar("Click FAB")
            changeEditMode(currentEditMode)
        }

        setupToolbar()
        setupDrawer()
//        loadUserInfoValue()

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

//        saveUserInfoValue()
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

        outState.putBoolean(EDIT_MODE, !currentEditMode)

        Log.d("M_MainActivity", "onSaveInstanceState")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            navigationDrawer.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showSnackBar(message: String){
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
        val navigationView = navigation_view
        navigationView.setNavigationItemSelectedListener {
            showSnackBar(it.title.toString())
            it.isChecked = true
            navigationDrawer.closeDrawer(GravityCompat.START)
            false
        }
    }

    /**
     * Изменяем режим редактирования
     * @param mode если true, то редактируем, иначе режим просмотра
     */
    private fun changeEditMode(mode: Boolean){
        if(mode) {
            floatingActionButton.setImageResource(R.drawable.ic_done_black_24dp)
            for (userValue in userInfoViews) {
                userValue.isEnabled = true
                userValue.isFocusable = true
                userValue.isFocusableInTouchMode = true
            }
        } else {
            floatingActionButton.setImageResource(R.drawable.ic_create_black_24dp)
            for (userValue in userInfoViews) {
                userValue.isEnabled = false
                userValue.isFocusable = false
                userValue.isFocusableInTouchMode = false

//                saveUserInfoValue()

            }
        }
        currentEditMode = !currentEditMode
    }

    private fun loadUserInfoValue(){
        val userData = dataManager.preferencesManager.loadUserProfileData()
        for (i in 0 until userData.size){
            userInfoViews[i].setText(userData[i])
        }
    }

    private fun saveUserInfoValue(){
        val userData = ArrayList<String?>()
        for (userInfoView in userInfoViews) {
            userData.add(userInfoView.text.toString())
        }
        dataManager.preferencesManager.saveUserProfileData(userData)
    }

//    fun runWithDelay(){
//        var handler = Handler()
//        handler.postDelayed({
//            hideProgress()
//        }, 5000)
//    }
}

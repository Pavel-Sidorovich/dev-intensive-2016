package com.pavesid.devintensive.ui.activities

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.pavesid.devintensive.R

open class BaseActivity : AppCompatActivity() {

    //    lateinit var progressBar: ProgressBar
    private var dialog: AlertDialog? = null

    fun showProgress() {
        if (dialog == null) {
            val builder = AlertDialog.Builder(this)
            builder.setCancelable(false)
            builder.setView(R.layout.progress_splash)
            dialog = builder.create()
            dialog?.window?.setBackgroundDrawable(
                    ColorDrawable(Color.TRANSPARENT))
        } else {
            dialog?.show()
        }
    }

    fun hideProgress() {
        if (dialog != null) {
            if (dialog!!.isShowing) {
                dialog?.hide()
            }
        }
    }

    fun showError(str: String, error: Exception) {
        showToast(str)
        Log.e("M_BaseActivity", "$error")
    }

    fun showToast(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show()
    }

}
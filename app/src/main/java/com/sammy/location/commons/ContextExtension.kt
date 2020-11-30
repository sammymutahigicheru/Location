package com.sammy.location.commons

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

internal fun Activity.showSnackbar(view: View, message: String, isError: Boolean = false) {
    Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()

}

internal fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

internal inline fun <reified T : Activity> Context.startActivity(block: Intent.() -> Unit = {}) {
    val intent = Intent(this, T::class.java)
    block(intent)
    startActivity(intent)
}
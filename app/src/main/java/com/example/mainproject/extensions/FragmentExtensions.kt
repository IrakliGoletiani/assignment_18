package com.example.mainproject.extensions

import android.util.Log.d
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import java.lang.Exception

fun Fragment.hideKeyboard() {
    try {
        val imm = ContextCompat.getSystemService(requireContext(), InputMethodManager::class.java)
        imm?.hideSoftInputFromWindow(view?.windowToken, 0)
    } catch (e: Exception) {
        d("mainLog", "exception occurred: $e")
    }
}
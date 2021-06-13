package com.example.mainproject.util

import android.view.View
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import java.util.regex.Pattern

object Util {
    fun showSnackbar(view: View, text: String) {
        val snackbar = Snackbar.make(view, text, Snackbar.LENGTH_LONG)

        snackbar.setAction("Close") {
            snackbar.dismiss()
        }

        snackbar.show()
    }

    fun isEmailValid(email: EditText): Boolean {
        return Pattern.compile(
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                    + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        ).matcher(email.text.toString()).matches()
    }

    fun areFieldsValid(editTexts: List<EditText>): Boolean {

        var isValid = true

        editTexts.forEach {
            if (it.text.isEmpty()) {
                isValid = false
                return@forEach
            }
        }
        return isValid
    }
}
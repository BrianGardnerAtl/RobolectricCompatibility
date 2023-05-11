package com.example.sample

import android.widget.TextView
import app.cash.paparazzi.Paparazzi
import org.junit.Rule
import org.junit.Test

class PaparazziTest {
    @get:Rule
    val paparazzi = Paparazzi()

    @Test
    fun checkPaparazzi() {
        val view = TextView(paparazzi.context)
        paparazzi.snapshot(view)
    }
}
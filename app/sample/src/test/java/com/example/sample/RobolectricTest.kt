package com.example.sample

import android.view.View
import android.widget.TextView
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.MatcherAssert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric

@RunWith( AndroidJUnit4::class)
class RobolectricTest {

    @Test
    fun checkActivity() {
        val controller = Robolectric.buildActivity(MainActivity::class.java)
        controller.setup()
        val mainActivity = controller.get()

        val view = mainActivity.findViewById<TextView>(R.id.welcome_text)
        MatcherAssert.assertThat(
            "text should be visible on screen!",
            view.visibility == View.VISIBLE
        )
    }
}
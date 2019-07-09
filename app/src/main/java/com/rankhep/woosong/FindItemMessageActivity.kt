package com.rankhep.woosong

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.rankhep.woosong.utils.NetworkHelper
import kotlinx.android.synthetic.main.activity_find_item_message.*

class FindItemMessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_item_message)

        nextBtn.setOnClickListener {
            if (messageEditText.text.toString() != "") {
                NetworkHelper.networkInstance
            }
        }
    }
}

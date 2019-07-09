package com.rankhep.woosong

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.rankhep.woosong.adapter.MainItemAdapter
import com.rankhep.woosong.model.LostItem
import kotlinx.android.synthetic.main.activity_finish_item_list.*

class FinishItemListActivity : AppCompatActivity(), MainItemAdapter.OnItemClickedListener {
    override fun itemClickListener(v: View, position: Int, item: LostItem) {
        Toast.makeText(applicationContext, "아이템" + position, Toast.LENGTH_SHORT).show()
    }

    val mAdapter = MainItemAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish_item_list)


        finishItemList.run {
            adapter = mAdapter
        }

        mAdapter.setOnItemListener(this)
    }
}

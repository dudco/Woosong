package com.rankhep.woosong

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.rankhep.woosong.adapter.MainItemAdapter
import com.rankhep.woosong.model.LostItem
import com.rankhep.woosong.model.LostItemListResponseModel
import com.rankhep.woosong.utils.NetworkHelper
import kotlinx.android.synthetic.main.activity_finish_item_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FinishItemListActivity : AppCompatActivity(), MainItemAdapter.OnItemClickedListener {
    override fun itemClickListener(v: View, position: Int, item: LostItem) {
        val intent = Intent(this@FinishItemListActivity, LostItemInfoActivity::class.java)
        intent.putExtra("item", item)
        intent.putExtra("isReserve", true)
        startActivity(intent)
    }

    val mAdapter = MainItemAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish_item_list)

        val phone = intent.getStringExtra("phone")

        NetworkHelper.networkInstance.getMyReserveItem("01054461507")
            .enqueue(object : Callback<LostItemListResponseModel> {
                override fun onFailure(call: Call<LostItemListResponseModel>, t: Throwable) {
                    t.printStackTrace()
                }

                override fun onResponse(
                    call: Call<LostItemListResponseModel>,
                    response: Response<LostItemListResponseModel>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            mAdapter.setItem(it.list)
                            Log.e("Asd", "asd")
                        }
                    } else {
                        Log.e("Asd", response.message())
                    }

                }

            })

        finishItemList.run {
            adapter = mAdapter
        }

        finishBtn.setOnClickListener {
            finish()
        }

        mAdapter.setOnItemListener(this)
    }
}

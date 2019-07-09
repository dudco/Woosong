package com.rankhep.woosong

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.rankhep.woosong.model.LostItem
import com.rankhep.woosong.utils.NetworkHelper
import kotlinx.android.synthetic.main.activity_find_item_message.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FindItemMessageActivity : AppCompatActivity() {

    lateinit var item:LostItem
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_item_message)

        item = intent.getSerializableExtra("item") as LostItem
        item.owner = intent.getStringExtra("phone")
        nextBtn.setOnClickListener {
            if (messageEditText.text.toString() != "") {
                NetworkHelper.networkInstance.reserveItem(item.no, intent.getStringExtra("phone"), messageEditText.text.toString())
                    .enqueue(object: Callback<Any> {
                        override fun onFailure(call: Call<Any>, t: Throwable) {
                            t.printStackTrace()
                        }

                        override fun onResponse(call: Call<Any>, response: Response<Any>) {
                            if(response.isSuccessful){
                                Toast.makeText(applicationContext, "예약이 완료되었습니다.",Toast.LENGTH_SHORT).show()
                                setResult(Activity.RESULT_OK)
                                finish()
                            }else{
                                Toast.makeText(applicationContext, "에러" + response.message(),Toast.LENGTH_SHORT).show()
                            }
                        }

                    })
            }
        }
    }
}

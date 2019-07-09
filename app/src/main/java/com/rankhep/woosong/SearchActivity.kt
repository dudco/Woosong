package com.rankhep.woosongimport android.support.v7.app.AppCompatActivityimport android.os.Bundleimport android.support.v7.widget.LinearLayoutManagerimport com.rankhep.woosong.adapter.MainItemAdapterimport com.rankhep.woosong.model.LostItemimport com.rankhep.woosong.model.LostItemListResponseModelimport com.rankhep.woosong.utils.NetworkHelperimport kotlinx.android.synthetic.main.activity_search.*import retrofit2.Callimport retrofit2.Callbackimport retrofit2.Responseclass SearchActivity : AppCompatActivity() {    val mAdapter = MainItemAdapter()    override fun onCreate(savedInstanceState: Bundle?) {        super.onCreate(savedInstanceState)        setContentView(R.layout.activity_search)        val search = intent.getStringExtra("search")        NetworkHelper.networkInstance.searchList(search).enqueue(object: Callback<LostItemListResponseModel> {            override fun onFailure(call: Call<LostItemListResponseModel>, t: Throwable) {                t.printStackTrace()            }            override fun onResponse(call: Call<LostItemListResponseModel>, response: Response<LostItemListResponseModel>) {                if(response.isSuccessful){                    response.body()?.let {                        mAdapter.setItem(it.list)                    }                }            }        })        searchList.run {            adapter = mAdapter        }    }}
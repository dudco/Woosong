package com.rankhep.woosongimport android.support.v7.app.AppCompatActivityimport android.os.Bundleimport android.support.v7.widget.LinearLayoutManagerimport com.rankhep.woosong.adapter.MainItemAdapterimport com.rankhep.woosong.model.LostItemimport kotlinx.android.synthetic.main.activity_search.*class SearchActivity : AppCompatActivity() {    val mAdapter = MainItemAdapter()    override fun onCreate(savedInstanceState: Bundle?) {        super.onCreate(savedInstanceState)        setContentView(R.layout.activity_search)        mAdapter.addItem(LostItem(1,"","","","","","",""))        mAdapter.addItem(LostItem(1,"","","","","","",""))        mAdapter.addItem(LostItem(1,"","","","","","",""))        mAdapter.addItem(LostItem(1,"","","","","","",""))        mAdapter.addItem(LostItem(1,"","","","","","",""))        searchList.run {            adapter = mAdapter        }    }}
package com.rankhep.woosongimport android.os.Bundleimport android.support.v7.app.AppCompatActivityimport android.support.v7.widget.LinearLayoutManagerimport com.rankhep.woosong.adapter.MainItemAdapterimport com.rankhep.woosong.model.LostItemimport kotlinx.android.synthetic.main.activity_main.*import java.util.*class MainActivity : AppCompatActivity() {    val mAdapter = MainItemAdapter()    override fun onCreate(savedInstanceState: Bundle?) {        super.onCreate(savedInstanceState)        setContentView(R.layout.activity_main)        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)        mAdapter.addItem(LostItem(1,"","","","","","",""))        mAdapter.addItem(LostItem(1,"","","","","","",""))        mAdapter.addItem(LostItem(1,"","","","","","",""))        mAdapter.addItem(LostItem(1,"","","","","","",""))        mAdapter.addItem(LostItem(1,"","","","","","",""))        itemList.run {            this.layoutManager = layoutManager            adapter = mAdapter        }    }}
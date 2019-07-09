package com.rankhep.woosong

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator


class QRCodeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrcode)

        val intentIntegrator = IntentIntegrator(this)
        intentIntegrator.setBeepEnabled(false)//바코드 인식시 소리
        intentIntegrator.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            Toast.makeText(applicationContext,"시발련아",Toast.LENGTH_SHORT).show()
            if (result.contents == null) {
                Toast.makeText(applicationContext,"시발련아",Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(applicationContext,"ㅁㄴㅇ"+result.contents,Toast.LENGTH_SHORT).show()
                val intent = Intent(QRCodeActivity@ this, RegisterLostItemActivity::class.java)
                intent.putExtra("qr", ""+result.contents)
                startActivity(intent)
                finish()
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}

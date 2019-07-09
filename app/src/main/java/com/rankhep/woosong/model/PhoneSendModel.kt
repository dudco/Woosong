package com.rankhep.woosong.model

import org.json.JSONObject

class PhoneSendModel(val phone: String) {
    companion object {
        fun toJson(phone: PhoneSendModel): JSONObject {
            val paramObject = JSONObject()

            paramObject.put("phone", phone.phone)
            return paramObject
        }
    }
}
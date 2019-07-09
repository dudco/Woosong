package com.rankhep.woosong.model

import org.json.JSONObject

class CheckSendModel(val phone:String, val code:String) {
    companion object{
        fun toJson(check: CheckSendModel): JSONObject {
            val paramObject = JSONObject()

            paramObject.put("phone", check.phone)
            paramObject.put("code", check.code)
            return paramObject
        }
    }
}
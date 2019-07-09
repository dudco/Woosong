package com.rankhep.woosong.utils


import com.rankhep.woosong.model.LostItem
import com.rankhep.woosong.model.LostItemListResponseModel
import com.rankhep.woosong.model.Station
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*
import java.util.*


/**
 * Created by choi on 2017. 7. 15..
 */

interface RetrofitInterface {
    @GET("item/qrcheck/")
    fun getStation(@Query("qrdata") qrdata: String): Call<Station>

    @Multipart
    @POST("/item/register")
    fun registerLostItem(
        @Part imgBody: MultipartBody.Part,
        @Part("itemname") body: RequestBody,
        @Part("daytime") daytime: RequestBody,
        @Part("getLocation") locationBody: RequestBody,
        @Part("storageLocation") storageLocation: RequestBody,
        @Part("description") description:RequestBody) : Call<Any>

    @GET("/item/list")
    fun getList():Call<LostItemListResponseModel>

    @GET("/item/search")
    fun searchList(@Query("query") query: String):Call<LostItemListResponseModel>
}

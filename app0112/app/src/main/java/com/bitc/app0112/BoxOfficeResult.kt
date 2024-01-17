package com.bitc.app0112

import com.google.gson.annotations.SerializedName

data class BoxOfficeResult(

    @SerializedName("boxofficeType")
    var boxofficeType: String? = null,

    @SerializedName("showRange")
    var showRange: String? = null,

    @SerializedName("dailyBoxOfficeList")
    var dailyBoxOfficeList: ArrayList<DailyBoxOfficeList> = arrayListOf()

)
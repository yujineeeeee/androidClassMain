package com.bitc.app0112

import com.google.gson.annotations.SerializedName


data class Kobis(

    @SerializedName("boxOfficeResult")
    var boxOfficeResult: BoxOfficeResult? = BoxOfficeResult()

)
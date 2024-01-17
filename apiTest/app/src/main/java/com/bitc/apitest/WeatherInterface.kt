package com.bitc.apitest

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherInterface {
    // getVilageFcst : 동네 예보 조회
    @GET("getVilageFcst?serviceKey=zE%2Fz90B7fPj8I0TSlZCp02kCZ1iB2wySd3ZyScEttrCLUPr2WwD8KYnRUFHGImTGAGpNWUSsi5Lb6GRROv6xxg%3D%3D")

    fun GetWeather(@Query("dataType") data_type : String,
                   @Query("numOfRows") num_of_rows : Int,
                   @Query("pageNo") page_no : Int,
                   @Query("base_date") base_date : String,
                   @Query("base_time") base_time : String,
                   @Query("nx") nx : String,
                   @Query("ny") ny : String)
            : Call<WEATHER>
}
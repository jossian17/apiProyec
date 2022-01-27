package com.example.apiproyecto

import com.google.gson.annotations.SerializedName

data class Calorias (@SerializedName("status")var status:String,
                     @SerializedName("message") var images:List<String>)



/* class Calorias ( val data : RedditDataResponse)

class RedditDataResponse (
    val child : List<RedditChildrenResponse>,
    val after : String?,
    val before : String?
)

class RedditChildrenResponse ( val data : RedditNewsDataResponse)

class RedditNewsDataResponse (
    val author : String,
    val title : String,
    val num_comments : Int,
    val created : Long,
    val thumbnail : String,
    val url : String
)

 */


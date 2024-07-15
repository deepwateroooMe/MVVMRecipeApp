package com.codingwithmitch.mvvmrecipeapp.network.model

import com.google.gson.annotations.SerializedName

// 【双向转换桥梁】：这里定义了，/domain/model/Recipe 与 /network/model/RecipeDto 的双向转换定义。就是
// 网搜，从网络上扒下来的单条菜谱 RecipeDto，怎么转成、本地仓库、本应用认可的 Recipe; 向户上传Recipe, 怎么转成 RecipeDto 上传网站之类的？
data class RecipeDto( // dto: 是什么意思，这里

        @SerializedName("pk")
        var pk: Int,

        @SerializedName("title")
        var title: String,

        @SerializedName("publisher")
        var publisher: String,

        @SerializedName("featured_image")
        var featuredImage: String,

        @SerializedName("rating")
        var rating: Int = 0,

        @SerializedName("source_url")
        var sourceUrl: String,

        @SerializedName("ingredients")
        var ingredients: List<String> = emptyList(),

        @SerializedName("date_added")
        var dateAdded: String,

        @SerializedName("date_updated")
        var dateUpdated: String,

        // 这里添加一些 tag 相关的。。
)
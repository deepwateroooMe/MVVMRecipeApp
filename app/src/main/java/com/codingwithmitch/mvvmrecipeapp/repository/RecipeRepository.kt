package com.codingwithmitch.mvvmrecipeapp.repository

import com.codingwithmitch.mvvmrecipeapp.domain.model.Recipe

interface RecipeRepository { // 接口
     // 一个是：网搜，后显示，各菜谱链条
    suspend fun search(token: String, page: Int, query: String): List<Recipe>
     // 一个是：网搜，后显示：单个菜谱、供读阅
    suspend fun get(token: String, id: Int): Recipe

}

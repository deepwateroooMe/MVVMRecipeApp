package com.codingwithmitch.mvvmrecipeapp.repository

import com.codingwithmitch.mvvmrecipeapp.domain.model.Recipe
import com.codingwithmitch.mvvmrecipeapp.network.RecipeService
import com.codingwithmitch.mvvmrecipeapp.network.model.RecipeDtoMapper

class RecipeRepository_Impl ( 
        private val recipeService: RecipeService,
        private val mapper: RecipeDtoMapper, 
): RecipeRepository {

    override suspend fun search(token: String, page: Int, query: String): List<Recipe> {
        return mapper.toDomainList(recipeService.search(token = token, page = page, query = query).recipes)
    }

    override suspend fun get(token: String, id: Int): Recipe { // 网搜：从网络上，把指定菜谱给抓下来、转为本应用的 DomainModel Recipe
                              // 任何时候调用，都网搜，再下载一遍。因为应用、没有设置本地数据库之类的任何缓存
                             return mapper.mapToDomainModel(recipeService.get(token = token, id))
                         }
}
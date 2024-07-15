package com.codingwithmitch.mvvmrecipeapp.presentation.ui.recipe

sealed class RecipeEvent { // 内部密封类

    data class GetRecipeEvent( // 只定义了，这一个加载菜谱事件、数据类。。
        val id: Int
    ): RecipeEvent()

}
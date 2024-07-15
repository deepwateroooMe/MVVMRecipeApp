package com.codingwithmitch.mvvmrecipeapp.presentation.ui.recipe_list

sealed class RecipeListEvent {

    object NewSearchEvent : RecipeListEvent()

    object NextPageEvent : RecipeListEvent()

    // restore after process death
    object RestoreStateEvent: RecipeListEvent()

    // 【下拉列表框】：亲爱的表哥的活宝妹的、新添加的【限制类】里搜索，应为它添加相应事件、事件驱动。而不是如现在独立于海天之外。。
    // 【TODO】：
}
package com.codingwithmitch.mvvmrecipeapp.domain.model

/**
 * See Recipe example: https://food2fork.ca/
 */
// 方便存储进、仓库数据库的、定义的数据类、小单位 Unit.. 一个菜谱所包括的、所想要存储的、必要成员数据。这里也可以加 tag 呀
data class Recipe (
    val id: Int,
    val title: String,
    val publisher: String,
    val featuredImage: String,
    val rating: Int = 0,
    val sourceUrl: String,
    val ingredients: List<String> = listOf(),
    val dateAdded: String,
    val dateUpdated: String,
)
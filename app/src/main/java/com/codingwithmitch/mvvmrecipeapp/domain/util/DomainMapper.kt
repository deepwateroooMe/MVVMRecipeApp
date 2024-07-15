package com.codingwithmitch.mvvmrecipeapp.domain.util

 // 声明：接口类
interface DomainMapper <T, DomainModel> { // 【TODO】：DomainModel 是什么意思？像是【泛型】的写法，随便起名的。。把ViewModel 声称为 DomainModel
    // DomainModel, 这里就是， domain/model/ 下定义过的，都算是 DomainModel 的实例
    fun mapToDomainModel(model: T): DomainModel
    fun mapFromDomainModel(domainModel: DomainModel): T
}
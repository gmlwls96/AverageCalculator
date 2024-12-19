package com.hj.average.core.data.mapper

import com.hj.average.core.db.entity.ItemEntity
import com.hj.average.core.models.ItemModel

fun ItemEntity.toModel() = ItemModel(
    id = id,
    name = name,
    date = date,
    firstPrice = firstPrice,
    firstQuantity = firstQuantity,
    secondPrice = secondPrice,
    secondQuantity = secondQuantity
)

fun ItemModel.toEntity() = ItemEntity(
    id = id,
    name = name,
    date = date,
    firstPrice = firstPrice,
    firstQuantity = firstQuantity,
    secondPrice = secondPrice,
    secondQuantity = secondQuantity
)
package com.example.base

import android.content.Context


interface BaseViewModelDelegate {
    val ctx: Context
    fun resources() = ctx.resources!!
}
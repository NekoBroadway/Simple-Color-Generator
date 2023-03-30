package com.mobile.simple_generator.models

import com.mobile.simple_generator.R

data class Card(
    var text: String = "#FFFFFF",
    var color: String = "#FFFFFF",
    var statement: Boolean = false,
    var icon: Int = R.drawable.outline_lock_open_24)
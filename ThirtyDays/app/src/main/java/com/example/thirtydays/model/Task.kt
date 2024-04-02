package com.example.thirtydays.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.thirtydays.R

data class Task(
    @StringRes val title: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int,
)

val tasksList = listOf(
    Task(title = R.string.day_01_head, description = R.string.day_01_body, image = R.drawable.day_01),
    Task(title = R.string.day_02_head, description = R.string.day_02_body, image = R.drawable.day_02),
    Task(title = R.string.day_03_head, description = R.string.day_03_body, image = R.drawable.day_03),
    Task(title = R.string.day_04_head, description = R.string.day_04_body, image = R.drawable.day_04),
    Task(title = R.string.day_05_head, description = R.string.day_05_body, image = R.drawable.day_05),
    Task(title = R.string.day_06_head, description = R.string.day_06_body, image = R.drawable.day_06),
    Task(title = R.string.day_07_head, description = R.string.day_07_body, image = R.drawable.day_07),
    Task(title = R.string.day_08_head, description = R.string.day_08_body, image = R.drawable.day_08),
    Task(title = R.string.day_09_head, description = R.string.day_09_body, image = R.drawable.day_09),
    Task(title = R.string.day_10_head, description = R.string.day_10_body, image = R.drawable.day_10),
    Task(title = R.string.day_11_head, description = R.string.day_11_body, image = R.drawable.day_11),
    Task(title = R.string.day_12_head, description = R.string.day_12_body, image = R.drawable.day_12),
    Task(title = R.string.day_13_head, description = R.string.day_13_body, image = R.drawable.day_13),
    Task(title = R.string.day_14_head, description = R.string.day_14_body, image = R.drawable.day_14),
    Task(title = R.string.day_15_head, description = R.string.day_15_body, image = R.drawable.day_15),
    Task(title = R.string.day_16_head, description = R.string.day_16_body, image = R.drawable.day_16),
    Task(title = R.string.day_17_head, description = R.string.day_17_body, image = R.drawable.day_17),
    Task(title = R.string.day_18_head, description = R.string.day_18_body, image = R.drawable.day_18),
    Task(title = R.string.day_19_head, description = R.string.day_19_body, image = R.drawable.day_19),
    Task(title = R.string.day_20_head, description = R.string.day_20_body, image = R.drawable.day_20),
    Task(title = R.string.day_21_head, description = R.string.day_21_body, image = R.drawable.day_21),
    Task(title = R.string.day_22_head, description = R.string.day_22_body, image = R.drawable.day_22),
    Task(title = R.string.day_23_head, description = R.string.day_23_body, image = R.drawable.day_23),
    Task(title = R.string.day_24_head, description = R.string.day_24_body, image = R.drawable.day_24),
    Task(title = R.string.day_25_head, description = R.string.day_25_body, image = R.drawable.day_25),
    Task(title = R.string.day_26_head, description = R.string.day_26_body, image = R.drawable.day_26),
    Task(title = R.string.day_27_head, description = R.string.day_27_body, image = R.drawable.day_27),
    Task(title = R.string.day_28_head, description = R.string.day_28_body, image = R.drawable.day_28),
    Task(title = R.string.day_29_head, description = R.string.day_29_body, image = R.drawable.day_29),
    Task(title = R.string.day_30_head, description = R.string.day_30_body, image = R.drawable.day_30),
    )
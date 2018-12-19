package com.kestrel9.android.rxdatabindingntptimer.util

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.DateFormat
import java.util.*

/**
 * RxDatabindingNTPTimer
 * Class: BindingAdapters
 * Created by kestr on 2018-12-19.
 *
 * Description:
 */
@BindingAdapter(value = ["date"])
fun TextView.setDate(timestamp: Long) {
    text = DateFormat.getDateTimeInstance().format(Date(timestamp))
}
package com.kestrel9.android.rxdatabindingntptimer

import com.kestrel9.android.rxdatabindingntptimer.util.NetworkTime
import org.junit.Test

import org.junit.Assert.*
import java.text.DateFormat
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun ntpIsCorrect() {
        val longTime = NetworkTime.getCurrentTime()
        val date = Date(longTime)
        val format = DateFormat.getInstance()
        format.format(date)
        println(format.format(date))

        val calender = GregorianCalendar()
        calender.time = date
        val year = calender.get(Calendar.YEAR)
        val month = calender.get(Calendar.MONTH) + 1
        val day = calender.get(Calendar.DAY_OF_MONTH)
        val hour = calender.get(Calendar.HOUR_OF_DAY)
        val minute = calender.get(Calendar.MINUTE)
        val second = calender.get(Calendar.SECOND)
        val millis = calender.get(Calendar.MILLISECOND)

        assertEquals(12, month)

    }

    @Test
    fun timer() {
        val longTime = NetworkTime.getCurrentTime() ?: 0
        val date = Date(longTime)
        val calender = Calendar.getInstance()
        io.reactivex.Observable.interval(1, TimeUnit.SECONDS)
//            .take(30) // up to 30 items
            .map { v -> v + 1 } // shift it to 1 .. 30
            .subscribe {
                println(Date(longTime + it * 1000))
            }
        Thread.sleep(60000)

//        io.reactivex.Observable.range(longTime)
    }

    @Test
    fun setDate() {
        val timestamp: Long? = NetworkTime.getCurrentTime()
        val text = if (timestamp != null) {
            DateFormat.getInstance().format(Date(timestamp))
        } else {
            DateFormat.getInstance().format(Calendar.getInstance().time)
        }
        println(text)
    }

}

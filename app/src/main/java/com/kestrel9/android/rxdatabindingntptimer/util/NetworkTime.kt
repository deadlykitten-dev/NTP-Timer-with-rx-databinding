package com.kestrel9.android.rxdatabindingntptimer.util

import org.apache.commons.net.ntp.NTPUDPClient
import java.lang.Exception
import java.net.InetAddress
import java.util.*

/**
 * RxDatabindingNTPTimer
 * Class: NetworkTime
 * Created by kestr on 2018-12-19.
 *
 * Description:
 */
object NetworkTime {
    private const val TIME_SERVER = "pool.ntp.org"
    fun getCurrentTime(): Long = try {
        NTPUDPClient().apply { defaultTimeout = 3000 }.run {
            getTime(InetAddress.getByName(TIME_SERVER))
                .message.transmitTimeStamp.time
        }
    } catch (e: Exception) {
        GregorianCalendar.getInstance().time.time
    }
}
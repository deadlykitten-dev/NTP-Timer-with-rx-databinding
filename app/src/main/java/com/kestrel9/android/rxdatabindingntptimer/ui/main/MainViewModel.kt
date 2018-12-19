package com.kestrel9.android.rxdatabindingntptimer.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kestrel9.android.rxdatabindingntptimer.util.NetworkTime
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

class MainViewModel : ViewModel() {
    val date = MutableLiveData<Long>()
    private var ob: Disposable? = null
    fun setTimer() {
        val timestamp = NetworkTime.getCurrentTime()
        ob = Observable.interval(1, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .map { v -> v + 1 }
            .subscribe {
                date.postValue(timestamp + it * 1000)
                Log.d("viewmodel", "$it")
            }
    }

    fun stop(){
        ob?.dispose()
    }

}

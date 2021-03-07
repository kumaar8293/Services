package com.themovies.servicedemo.intentservice

import android.app.IntentService
import android.content.Intent
import android.util.Log

/**
 * IntentService is an extension of the Service component class that handles asynchronous requests
 * (expressed as Intents) on demand.
 * Clients send requests through Context.startService(Intent) calls;
 * the service is started as needed, handles each Intent in turn using a worker thread,
 * and stops itself when it runs out of work.
 *
 * All requests are handled on a single worker thread -- they may take as long as necessary
 * (and will not block the application's main loop), but only one request will be processed at a time.
 */

class MyIntentService : IntentService("MyIntentService") {

    init {
        instance = this
    }

    companion object {
        private lateinit var instance: MyIntentService
        var isRunning = false
        fun stopService() {
            isRunning = false
            instance.stopSelf()
        }
    }

    override fun onHandleIntent(intent: Intent?) {
        isRunning = true

        Log.d("MyIntentService", "onHandleIntent: ${Thread.currentThread().name}")
        try {
            Thread.sleep(5000)
//            for (i in 1..10) {
//                Log.d("MyIntentService", "My intent service is running...$i")
//                Thread.sleep(500)
//            }
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
        }
        Log.d("MyIntentService", "onHandleIntent: ${Thread.currentThread().name}")
        isRunning = false
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
        Log.d("MyIntentService", "onDestroy: ")
    }
}
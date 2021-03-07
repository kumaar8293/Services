package com.themovies.servicedemo.service

import android.app.Service
import android.content.Intent
import android.os.AsyncTask
import android.os.IBinder
import android.util.Log
import kotlin.math.log

/**
 * A Service is an application component that can perform long-running operations in the background.
 * It does not provide a user interface. Once started, a service might continue
 * running for some time, even after the user switches to another application.
 *
 * Additionally, a component can bind to a service to interact with it and even perform
 * interprocess communication (IPC). For example, a service can handle network transactions,
 * play music, perform file I/O, or interact with a content provider, all from the background.
 *
 * Caution: A service runs in the main thread of its hosting process;
 * the service does not create its own thread and does not run in a separate process
 * unless you specify otherwise. You should run any blocking operations on a separate thread within the
 * service to avoid Application Not Responding (ANR) errors.
 *
 * Even job is done Service wont stop automatically but intent service does. We have to stop service manually
 * or OS will kill after some times.
 *
 * A service is started when an application component, such as an activity, starts it by calling startService().
 * Once started, a service can run in the background indefinitely,
 * even if the component that started it is destroyed.
 */

class MyService : Service() {

    val TAG = "MyService"

    init {
        Log.d(TAG, "Service is running..: ")
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate: ")
    }

    /** Called when the service is being created. */
    override fun onStart(intent: Intent?, startId: Int) {
        super.onStart(intent, startId)
        Log.d(TAG, "onStart: ")
    }

    /** A client is binding to the service with bindService() */
    override fun onBind(intent: Intent?): IBinder? = null

    /** Called when all clients have unbound with unbindService() */
    override fun onUnbind(intent: Intent?): Boolean {
        return super.onUnbind(intent)
    }

    /** Called when a client is binding to the service with bindService()*/
    override fun onRebind(intent: Intent?) {
        super.onRebind(intent)
    }

    /**
     *  If you implement this method, it is your responsibility to stop the service when its work is done,
     *  by calling stopSelf() or stopService() methods.
     */

    /** The service is starting, due to a call to startService() */
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Log.d(TAG, "onStartCommand: ${Thread.currentThread().name} ")
        intent?.getStringExtra("EXTRA_DATA")?.let {
            Log.d(TAG, "onStartCommand: $it")
        }

//        Thread {
//            while (true) {
//                Log.d(TAG, "onStartCommand: 11")
//            }
//        }.start()

        // Indicates how to behave if the service is killed
        return START_NOT_STICKY
    }

    /** Called when The service is no longer used and is being destroyed */
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: Service is being killed")
    }
}
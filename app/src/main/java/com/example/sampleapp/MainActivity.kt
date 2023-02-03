package com.example.sampleapp

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.provider.Settings
import android.util.Log

class MainActivity : AppCompatActivity() {

  //private var iDataServiceCallback:IDataServiceCallback? = null

 /*   private val connection = object :ServiceConnection{

        override fun onServiceConnected(p0: ComponentName?, service: IBinder?) {
            iDataServiceCallback = IDataServiceCallback.Stub.asInterface(service)

            iDataServiceCallback?.getinstalledAppList()?.forEach {
                Log.d("MainActivity", "Service onBind ${it.applicationPackageName}")

            }


        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            iDataServiceCallback = null
        }

    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, AppService::class.java)
        startService(intent)
        //bindService(intent,connection,Context.BIND_AUTO_CREATE)



    }
}
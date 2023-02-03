package com.example.sampleapp

import android.app.Service
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Binder
import android.os.IBinder
import android.util.Log


class AppService : Service() {

    companion object {
        val TAG: String = AppService::class.java.simpleName
    }


    override fun onCreate() {
        Log.d(TAG, "Service onCreate")

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand")

        return START_STICKY
    }


    override fun onBind(intent: Intent): IBinder {
        Log.d(TAG, "onBind")

        return binder
    }


  /*  inner class DataBinder : IDataServiceCallback.Stub() {
        override fun getinstalledAppList(): MutableList<AppInfo> {
            return getInstalledAppList().also {
                Log.d("AppService", " IDataServiceCallback ${it.size}")
            }
        }
    }*/

    private val binder = object : IDataServiceCallback.Stub(){
        override fun getinstalledAppList(): MutableList<AppInfo> {
            return getInstalledAppList().also {
                Log.d("AppService", " IDataServiceCallback ${it.size}")

            }
        }

    }
@Suppress("DEPRECATION")
private fun getInstalledAppList(): MutableList<AppInfo> {
    val applicationInfo = mutableListOf<AppInfo>()
    val installedApps = packageManager.getInstalledApplications(PackageManager.GET_META_DATA)
    for (app in installedApps) {
        val packageName = app.packageName
        val appName = packageManager.getApplicationLabel(app)
        val appIcon = packageManager.getApplicationIcon(app)
        applicationInfo.add(
            AppInfo(
                applicationName = appName.toString(),
                applicationPackageName = packageName.toString()
            )
        )
    }

    applicationInfo.forEach {
        Log.d(TAG, "getAllApplicationList ${it.applicationPackageName}")
    }
    return applicationInfo
}


}
package com.gladiator.security

import android.content.Context
import android.content.pm.PackageManager

/**
 * Gladiator Shield - Scanner Engine
 * هذا المحرك مسؤول عن فحص التطبيقات وكشف الصلاحيات المشبوهة
 */
class ScannerEngine(private val context: Context) {

    // قائمة بالأذونات التي تستعملها تطبيقات التجسس عادة
    private val spyPermissions = listOf(
        "android.permission.READ_SMS",
        "android.permission.RECORD_AUDIO",
        "android.permission.CAMERA",
        "android.permission.ACCESS_FINE_LOCATION"
    )

    fun checkDeviceSecurity(): List<String> {
        val riskyApps = mutableListOf<String>()
        val pm = context.packageManager
        val installedApps = pm.getInstalledPackages(PackageManager.GET_PERMISSIONS)

        for (app in installedApps) {
            val permissions = app.requestedPermissions
            if (permissions != null) {
                for (perm in permissions) {
                    if (perm in spyPermissions) {
                        riskyApps.add("Warning: ${app.packageName} uses $perm")
                    }
                }
            }
        }
        return riskyApps
    }
}

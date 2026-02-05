package com.gladiator.shield

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

/**
 * Gladiator Shield: Security Service
 * المحرك المركزي الذي يربط الكاميرا والميكروفون بنظام الحماية المستمر
 */
class SecurityService : Service() {

    private lateinit var audioGuardian: AudioGuardian
    private lateinit var cameraGuardian: CameraGuardian

    override fun onCreate() {
        super.onCreate()
        audioGuardian = AudioGuardian(this)
        cameraGuardian = CameraGuardian(this)
        
        Log.d("GladiatorShield", "Security Shield is Active and Protecting.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // بدء مراقبة الكاميرا فوراً
        cameraGuardian.registerCameraCallback()
        
        // التحقق الدوري من الميكروفون
        if (audioGuardian.isMicrophoneInUse()) {
            Log.w("GladiatorShield", "Warning: Microphone access detected!")
        }

        return START_STICKY // لضمان عدم إغلاق النظام من قبل أندرويد
    }

    override fun onBind(intent: Intent?): IBinder? = null
}

package com.gladiator.security

import android.os.Bundle
import android.widget.TextView
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState: Bundle?)
        
        // إنشاء واجهة عرض بسيطة تظهر حالة الحماية
        val statusView = TextView(this).apply {
            text = "🛡️ Gladiator Shield\n\nStatus: Scanning...\nEngine: ACTIVE"
            textSize = 24f
            setTextColor(Color.GREEN)
            setPadding(60, 60, 60, 60)
        }
        
        setContentView(statusView)
    }
}

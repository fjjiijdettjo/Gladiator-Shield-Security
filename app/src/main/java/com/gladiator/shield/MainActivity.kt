package com.gladiator.shield

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.content.Intent

/**
 * Gladiator Shield: Main Command Center
 * الواجهة الرئيسية للتحكم في درع الحماية
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val statusText = findViewById<TextView>(R.id.status_text)
        val shieldButton = findViewById<Button>(R.id.shield_button)

        shieldButton.setOnClickListener {
            // تفعيل محرك الحماية (Security Service)
            val intent = Intent(this, SecurityService::class.java)
            startService(intent)
            
            statusText.text = "🛡️ Gladiator Shield: ACTIVE"
            shieldButton.text = "PROTECTION ENABLED"
            shieldButton.isEnabled = false // تأكيد تفعيل الحماية
        }
    }
}

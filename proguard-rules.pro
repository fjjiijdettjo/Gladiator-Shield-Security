# Gladiator Shield: Security Obfuscation Rules
# يحمي الكود من الهندسة العكسية

-keep class com.gladiator.shield.** { *; }
-dontwarn com.gladiator.shield.**

# حماية مكتبات أندرويد الأساسية لضمان الاستقرار
-keepattributes Signature
-keepattributes *Annotation*

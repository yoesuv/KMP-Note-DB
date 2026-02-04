# Keep Kotlin Serialization metadata and serializers
-keepattributes *Annotation*,InnerClasses,EnclosingMethod
-keepclassmembers class **$Companion {
    kotlinx.serialization.KSerializer serializer(...);
}
-keepclassmembers class ** {
    kotlinx.serialization.KSerializer serializer(...);
}
-keepclassmembers @kotlinx.serialization.Serializable class * {
    <fields>;
}
-keepclassmembers class **$serializer { *; }

# Keep application routes referenced by name/reflection
-keep class com.yoesuv.kmptask.core.route.AppRoute { *; }

-keep @androidx.room.Database class * { *; }
-keep @androidx.room.Entity class * { *; }
-keep @androidx.room.Dao class * { *; }
-keepclassmembers class * extends androidx.room.RoomDatabase { *; }

# Retain class annotations (important for Koin's reflection)
-keepattributes *Annotation*

# Keep all Koin classes and their members
-keep class org.koin.** { *; }
-dontwarn org.koin.**

# Keep your ViewModels if you use Koin's inject/viewModel
-keep class androidx.lifecycle.ViewModel { *; }

# Prevent obfuscation of constructors required for injection
-keepclassmembers class * {
    public <init>(...);
}
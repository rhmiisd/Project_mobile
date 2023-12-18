package coding.project_sekolahku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent;
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.View;
import android.widget.Button

class home_activity : AppCompatActivity() {
    private lateinit var btnSignout: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnSignout = findViewById(R.id.out)

        btnSignout.setOnClickListener {
            val intent = Intent(this, masuk_activity::class.java)
            startActivity(intent)
            val vibrator = getSystemService(VIBRATOR_SERVICE) as Vibrator

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                // Definisikan getar sesuai kebutuhan
                val getar = longArrayOf(0, 70) // Contoh pola getaran

                val vibrationEffect = VibrationEffect.createWaveform(getar, -1)
                vibrator.cancel()
                vibrator.vibrate(vibrationEffect)
            }
        }

    }

    fun profileMenu(v: View) {
        val intent = Intent(this, profile_activity::class.java)
        startActivity(intent)
        val vibrator = getSystemService(VIBRATOR_SERVICE) as Vibrator

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Definisikan getar sesuai kebutuhan
            val getar = longArrayOf(0, 70) // Contoh pola getaran

            val vibrationEffect = VibrationEffect.createWaveform(getar, -1)
            vibrator.cancel()
            vibrator.vibrate(vibrationEffect)
        }
    }

    fun schoolMenu(v: View) {
        val i = Intent(this, school_activity::class.java)
        startActivity(i)
        val vibrator = getSystemService(VIBRATOR_SERVICE) as Vibrator

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Definisikan getar sesuai kebutuhan
            val getar = longArrayOf(0, 70) // Contoh pola getaran

            val vibrationEffect = VibrationEffect.createWaveform(getar, -1)
            vibrator.cancel()
            vibrator.vibrate(vibrationEffect)
        }
    }

    fun programMenu(v: View) {
        val i = Intent(this, Progju_activity::class.java)
        startActivity(i)
        val vibrator = getSystemService(VIBRATOR_SERVICE) as Vibrator

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Definisikan getar sesuai kebutuhan
            val getar = longArrayOf(0, 70) // Contoh pola getaran

            val vibrationEffect = VibrationEffect.createWaveform(getar, -1)
            vibrator.cancel()
            vibrator.vibrate(vibrationEffect)
        }
    }

    fun aboutusMenu(v: View) {
        val i = Intent(this, aboutus_activity::class.java)
        startActivity(i)
        val vibrator = getSystemService(VIBRATOR_SERVICE) as Vibrator

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Definisikan getar sesuai kebutuhan
            val getar = longArrayOf(0, 70) // Contoh pola getaran

            val vibrationEffect = VibrationEffect.createWaveform(getar, -1)
            vibrator.cancel()
            vibrator.vibrate(vibrationEffect)
        }
    }

}
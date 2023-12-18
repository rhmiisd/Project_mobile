package coding.project_sekolahku

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.os.VibrationEffect
import android.os.Vibrator

class masuk_activity : AppCompatActivity() {

    private lateinit var btnLogin: Button
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_masuk)

        btnLogin = findViewById(R.id.btn_firstlogin)
        btnRegister = findViewById(R.id.btn_firstregister)



        btnRegister.setOnClickListener {
            val intent = Intent(this, register_activity::class.java)
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

        btnLogin.setOnClickListener {
            val intent = Intent(this, login_activity::class.java)
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
}

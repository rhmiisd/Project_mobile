package coding.project_sekolahku

import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.Window
import android.view.WindowManager
import android.widget.Button

class register_activity : AppCompatActivity() {

    private lateinit var btnLogin: Button
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnLogin = findViewById(R.id.ke_login)
        btnRegister = findViewById(R.id.register)


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

        btnRegister.setOnClickListener {
            val intent = Intent(this, home_activity::class.java)
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

    private fun setWindowFlag(activity: Activity, bits: Int, on: Boolean) {
        val win: Window = activity.window
        val winParams: WindowManager.LayoutParams = win.attributes
        if (on) {
            winParams.flags = winParams.flags or bits
        } else {
            winParams.flags = winParams.flags and bits.inv()
        }
        win.attributes = winParams
    }

    }

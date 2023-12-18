package coding.project_sekolahku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.appcompat.app.AlertDialog

class login_activity : AppCompatActivity() {

        private lateinit var txtUsername: EditText
        private lateinit var txtPassword: EditText
        private lateinit var btnLogin: Button
        private lateinit var btnRegister: Button
        private lateinit var alert: alert_activity
        private lateinit var session: session_activity

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_login)
            btnLogin = findViewById(R.id.masuk)
            btnRegister = findViewById(R.id.ke_daftar)



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

    override fun onBackPressed() {
        super.onBackPressed()
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Apakah Anda ingin keluar dari aplikasi?")
        builder.setCancelable(true)
        builder.setNegativeButton(getString(R.string.batal)) { dialog, which -> dialog.cancel() }
        builder.setPositiveButton(getString(R.string.keluar)) { dialog, which -> finishAffinity() }
        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }

}
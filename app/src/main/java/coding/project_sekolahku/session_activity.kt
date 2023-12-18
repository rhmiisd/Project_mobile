package coding.project_sekolahku

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences

class session_activity (private val context: Context){
    private val pref: SharedPreferences
    private val editor: SharedPreferences.Editor
    private val PRIVATE_MODE = 0

    private val PREF_NAME = "Rahmi sefrial dayanti"
    private val IS_LOGIN = "IsLoggedIn"
    private val KEY_NAME = "name"
    private val KEY_EMAIL = "email"

    init {
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref.edit()
    }

    fun createLoginSession(email: String) {
        editor.putBoolean(IS_LOGIN, true)
        editor.putString(KEY_EMAIL, email)
        editor.apply()
    }

    fun checkLogin() {
        if (!isLoggedIn()) {
            val i = Intent(context, login_activity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(i)
        }
    }

    fun getUserDetails(): HashMap<String, String> {
        val user = HashMap<String, String>()
        user[KEY_NAME] = pref.getString(KEY_NAME, "") ?: ""
        user[KEY_EMAIL] = pref.getString(KEY_EMAIL, "") ?: ""
        return user
    }

    fun logoutUser() {
        editor.clear()
        editor.apply()

        val i = Intent(context, login_activity::class.java)
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(i)
    }

    fun isLoggedIn(): Boolean {
        return pref.getBoolean(IS_LOGIN, false)
    }
}
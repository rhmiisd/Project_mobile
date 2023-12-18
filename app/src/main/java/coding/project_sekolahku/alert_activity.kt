package coding.project_sekolahku

import android.app.AlertDialog
import android.content.Context

class alert_activity {
    fun showAlertDialog(context: Context, title: String, message: String, status: Boolean?) {
        val alertDialog = AlertDialog.Builder(context).create()
        alertDialog.setTitle(title)
        alertDialog.setMessage(message)

        if (status != null) {
            alertDialog.setIcon(if (status) R.drawable.ic_email else R.drawable.ic_password)
        }

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK") { dialog, _ -> dialog.dismiss() }

        alertDialog.show()
    }
}
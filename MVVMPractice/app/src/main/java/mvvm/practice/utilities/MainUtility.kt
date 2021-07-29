package mvvm.practice.utilities

import android.app.AlertDialog
import android.content.Context
import android.view.View
import android.widget.Toast

class MainUtility(private val context: Context) {

    fun showViewInDialog(v: View):AlertDialog{
        val dialog = AlertDialog.Builder(context)
        dialog.setView(v)
        dialog.create()
        return dialog.show()
    }


    fun makeToast(data:Any?){
        Toast.makeText(context,"$data",Toast.LENGTH_SHORT).show()
    }




}
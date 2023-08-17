package pl.kopczynski.praca_magisterska_amtp

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.Calendar

class MyDatePickerDialog: DialogFragment() {

    private val c = Calendar.getInstance()
    private val year = c.get((Calendar.YEAR))
    private val month = c.get(Calendar.MONTH)
    private val day = c.get(Calendar.DAY_OF_MONTH)


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return DatePickerDialog(requireActivity(), activity as OnDateSetListener, year, month, day)
    }
}
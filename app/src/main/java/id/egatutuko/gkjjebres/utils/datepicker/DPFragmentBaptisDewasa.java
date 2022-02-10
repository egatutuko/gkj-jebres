package id.egatutuko.gkjjebres.utils.datepicker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DPFragmentBaptisDewasa extends DialogFragment implements DatePickerDialog.OnDateSetListener{
    private DPFragmentListenerDewasa listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Get the current date to start the DatePicker with
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        listener.onDateSet(year, month, day);
    }
    // This is the method from the DatePicker fragment to implement in the Main Activity
    public interface DPFragmentListenerDewasa {
        void onDateSet(int year, int month, int day);
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        listener = (DPFragmentListenerDewasa) context;
    }
}

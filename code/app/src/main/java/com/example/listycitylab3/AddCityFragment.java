package com.example.listycitylab3;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class AddCityFragment extends DialogFragment {
    interface AddCityDialogListener {
        void addCity(City city);
        void updateCity(City city);
    }


    private AddCityDialogListener listener;
    public City city;

public AddCityFragment() {
}


public AddCityFragment(City c) {
    this.city = c;
}


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof AddCityDialogListener) {
                listener = (AddCityDialogListener) context;
        } else {
            throw new RuntimeException(context + " must implement AddCityDialogListener");

        }

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_add_city, null);
        EditText editCityName = view.findViewById(R.id.edit_text_city_text);
        EditText editProvinceName = view.findViewById(R.id.edit_text_province_text);
            if(city != null) {
                editCityName.setText(city.getName());
                editProvinceName.setText(city.getProvince());
            }

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
         builder
                .setView(view)
                .setTitle(city == null ? "Add a city" : "Edit city")
                .setNegativeButton("Cancel", null)
                .setPositiveButton(city == null ? "Add" : "Save Changes", (dialog, which) ->
        {
            String cityName = editCityName.getText().toString();
            String provinceName = editProvinceName.getText().toString();
                if(city == null) {
                    listener.addCity(new City(cityName, provinceName));
                } else {
                    city.setName(cityName);
                    city.setProvince(provinceName);
                    listener.updateCity(city);
                }

        });
          return      builder.create();
    }



}
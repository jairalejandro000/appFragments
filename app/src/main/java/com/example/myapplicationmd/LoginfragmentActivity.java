package com.example.myapplicationmd;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginfragmentActivity extends Fragment {
    private MaterialButton homebtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_loginfragment, container, false);
        //Guardar las propiedades de los views en variables de java
        TextInputLayout textInputLayout = view.findViewById(R.id.TextInputLayoutPswd);
        TextInputEditText textInputLayoutPswd = view.findViewById(R.id.TextInputEditTextPswd);
        MaterialButton materialButton = view.findViewById(R.id.home);
        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!Validar(textInputLayoutPswd.getText())) {
                    textInputLayout.setError("Error");
                }
            }
        });
        textInputLayoutPswd.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (Validar(textInputLayoutPswd.getText())) {
                    textInputLayout.setError(null);
                }
                return false;
            }
        });
        //Onclicklistener para el segundo fragment
        homebtn = view.findViewById(R.id.home);
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new HomefragmentActivity())
                .addToBackStack(null)
                .commit();
            }
        });
        return view;
    }
    public boolean Validar(Editable entrada){
        return entrada != null && entrada.length() > 6;
    }


}
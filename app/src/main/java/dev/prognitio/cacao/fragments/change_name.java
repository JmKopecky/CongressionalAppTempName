package dev.prognitio.cacao.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import dev.prognitio.cacao.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link change_name#newInstance} factory method to
 * create an instance of this fragment.
 */
public class change_name extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public change_name() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment change_name.
     */
    // TODO: Rename and change types and number of parameters
    public static change_name newInstance(String param1, String param2) {
        change_name fragment = new change_name();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_change_name, container, false);
        Context context = view.getContext();
        Button ConfirmName = view.findViewById(R.id.confirm_blue);
        EditText NameText = view.findViewById(R.id.input_name);
        String name = NameText.getText().toString();

        SharedPreferences sharedPref = context.getSharedPreferences(getString(R.string.userinfo_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("usersupplied_name", name);
        editor.apply();

        return view;
    }
}
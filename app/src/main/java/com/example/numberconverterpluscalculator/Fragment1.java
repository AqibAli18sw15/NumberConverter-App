package com.example.numberconverterpluscalculator;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private EditText getnum;
    private TextView result;
    private View view;
    Button buton;
    String inserted_text;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String[] items1;


    private Spinner spi1;
    private Spinner spi2;

    public Fragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
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
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_1, container, false);
        spi1 = view.findViewById(R.id.spinerone);
        ArrayList<String > spi1_items = new ArrayList<>();
        spi1_items.add("Decimal");
        spi1_items.add("Binary");
        spi1_items.add("Quinary");
        spi1_items.add("Octal");
        ArrayList<String> whenDecimalSelected = new ArrayList<>();
        whenDecimalSelected.add("Binary");
        whenDecimalSelected.add("Quinary");
        whenDecimalSelected.add("Octal");
        ArrayAdapter<String> arrayAdapterDecimal = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item,whenDecimalSelected);
        ArrayList<String> whenBinarySelected = new ArrayList<>();
        whenBinarySelected.add("Decimal");
        whenBinarySelected.add("Quinary");
        whenBinarySelected.add("Octal");
        ArrayAdapter<String> arrayAdapterBinary = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item,whenBinarySelected);
        ArrayList<String> whenQuinSelected = new ArrayList<>();
        whenQuinSelected.add("Decimal");
        whenQuinSelected.add("Binary");
        whenQuinSelected.add("Octal");
        ArrayAdapter<String> arrayAdapterQuinary = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item,whenQuinSelected);
        ArrayList<String> whenOctalSelected = new ArrayList<>();
        whenOctalSelected.add("Decimal");
        whenOctalSelected.add("Binary");
        whenOctalSelected.add("Quinary");
        ArrayAdapter<String> arrayAdapterOctal= new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item,whenOctalSelected);
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item,spi1_items);
        spi1.setAdapter(arrayAdapter1);

        spi2 = view.findViewById(R.id.spinertwo);
        ArrayList<String > spi2_items = new ArrayList<>();
        spi2_items.add("Decimal");
        spi2_items.add("Binary");
        spi2_items.add("Quinary");
        spi2_items.add("Octal");
        spi1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                           @Override
                                           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                                               if(spi1.getSelectedItem().toString().matches("Decimal")){spi2.setAdapter(arrayAdapterDecimal);
//                                               if(spi2.getSelectedItem().toString().matches("Binary"))result.setText(Converter.decToBin(inserted_text));
//                                               else if(spi2.getSelectedItem().toString().matches("Quinary"))result.setText(Converter.decToQuin(inserted_text));
//                                               else if(spi2.getSelectedItem().toString().matches("Octal"))result.setText(Converter.decToOctal(inserted_text));
                                               }//end of outer if
                                               else if(spi1.getSelectedItem().toString().matches("Binary")){spi2.setAdapter(arrayAdapterBinary);
//                                               if(spi2.getSelectedItem().toString().matches("Decimal"))result.setText(Converter.binToDec(inserted_text));
//                                               else if(spi2.getSelectedItem().toString().matches("Quinary"))result.setText(Converter.binToQuin(inserted_text));
//                                               else if(spi2.getSelectedItem().toString().matches("Octal"))result.setText(Converter.binToOctal(inserted_text));
                                               }//end of outer if
                                               else if(spi1.getSelectedItem().toString().matches("Quinary")){spi2.setAdapter(arrayAdapterQuinary);
//                                               if(spi2.getSelectedItem().toString().matches("Decimal"))result.setText(Converter.quinToDec(inserted_text));
//                                               else if(spi2.getSelectedItem().toString().matches("Binary"))result.setText(Converter.quinToBinary(inserted_text));
//                                               else if(spi2.getSelectedItem().toString().matches("Octal"))result.setText(Converter.quinToOctal(inserted_text));
                                               }//end of outer if
                                               else if(spi1.getSelectedItem().toString().matches("Octal")){spi2.setAdapter(arrayAdapterOctal);
//                                                   if(spi2.getSelectedItem().toString().matches("Decimal"))result.setText(Converter.octToDec(inserted_text));
//                                                   else if(spi2.getSelectedItem().toString().matches("Binary"))result.setText(Converter.octToBin(inserted_text));
//                                                   else if(spi2.getSelectedItem().toString().matches("Quinary"))result.setText(Converter.octToQuin(inserted_text));
                                               }//end of outer if


                                           }

                                           @Override
                                           public void onNothingSelected(AdapterView<?> parent) {

                                           }
                                       }
        );
        buton = view.findViewById(R.id.convert);
        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonAction(v);
            }
        });





        return view;

    }
    public void buttonAction(View v){
        result = view.findViewById(R.id.result);
        getnum = view.findViewById(R.id.insert);
        inserted_text = getnum.getText().toString();
        if(inserted_text.matches(""))result.setText("PleaseInsert number");
        else{
            if(spi1.getSelectedItem().toString().matches("Decimal")&&spi2.getSelectedItem().toString().matches("Binary")){
                result.setText(Converter.decToBin(inserted_text));
            }//end of decimal to binary
            else if(spi1.getSelectedItem().toString().matches("Decimal")&&spi2.getSelectedItem().toString().matches("Quinary")){
                result.setText(Converter.decToQuin(inserted_text));
            }//end of decimal to Quinary
            else if(spi1.getSelectedItem().toString().matches("Decimal")&&spi2.getSelectedItem().toString().matches("Octal")){
                result.setText(Converter.decToOctal(inserted_text));
            }//end of decimal to Octal
            else if(spi1.getSelectedItem().toString().matches("Binary")&&spi2.getSelectedItem().toString().matches("Decimal")){
                result.setText(Converter.binToDec(inserted_text));
            }//end of Binary to decimal
            else if(spi1.getSelectedItem().toString().matches("Binary")&&spi2.getSelectedItem().toString().matches("Quinary")){
                result.setText(Converter.binToQuin(inserted_text));
            }//end of Binary to decimal
            else if(spi1.getSelectedItem().toString().matches("Binary")&&spi2.getSelectedItem().toString().matches("Octal")){
                result.setText(Converter.binToOctal(inserted_text));
            }//end of Binary to decimal
            else if(spi1.getSelectedItem().toString().matches("Quinary")&&spi2.getSelectedItem().toString().matches("Decimal")){
                result.setText(Converter.quinToDec(inserted_text));
            }//end of Binary to decimal
            else if(spi1.getSelectedItem().toString().matches("Quinary")&&spi2.getSelectedItem().toString().matches("Binary")){
                result.setText(Converter.quinToBinary(inserted_text));
            }//end of Binary to decimal
            else if(spi1.getSelectedItem().toString().matches("Quinary")&&spi2.getSelectedItem().toString().matches("Octal")){
                result.setText(Converter.quinToOctal(inserted_text));
            }//end of Binary to decimal

            else if(spi1.getSelectedItem().toString().matches("Octal")&&spi2.getSelectedItem().toString().matches("Decimal")){
                result.setText(Converter.octToDec(inserted_text));
            }//end of Binary to decimal
            else if(spi1.getSelectedItem().toString().matches("Octal")&&spi2.getSelectedItem().toString().matches("Binary")){
                result.setText(Converter.octToBin(inserted_text));
            }//end of Binary to decimal
            else if(spi1.getSelectedItem().toString().matches("Octal")&&spi2.getSelectedItem().toString().matches("Quinary")){
                result.setText(Converter.octToQuin(inserted_text));
            }//end of Binary to decimal
            else result.setText("Not implemented yet");
        }//end of else



    }//end of ButtonActionMethod

}
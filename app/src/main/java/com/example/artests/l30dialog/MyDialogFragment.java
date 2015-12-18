package com.example.artests.l30dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by artests on 16.12.2015.
 */
public class MyDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //return super.onCreateDialog(savedInstanceState);
        final String[] arrayDialog=getResources().getStringArray(R.array.stringDialog);
        final boolean[] checkedItemsArray = {false, false, false};
        String button2String = "Здоровая пища";

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
/*
        builder.setTitle("An important message!")
                .setMessage("Feed the cat!")
                .setIcon(R.drawable.l131)
                .setPositiveButton("Ok, I am going to go to the kitchen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "Вы сделали правильный выбор",
                                Toast.LENGTH_LONG).show();
                        //dialog.cancel();
                    }
                });
        builder.setNegativeButton("Сам дурак!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "Возможно вы правы", Toast.LENGTH_LONG)
                        .show();
            }
        });
        builder.setNeutralButton(button2String, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "Возможно вы неправы", Toast.LENGTH_LONG)
                        .show();
            }
        });*/
        /*builder.setTitle("An important message!")
                .setIcon(R.drawable.l131)
                .setItems(arrayDialog, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "Выбранный кот:" + arrayDialog[which],
                                Toast.LENGTH_LONG).show();
                        //dialog.cancel();
                    }
                });*/
        /*builder.setTitle("An important message!")
                .setIcon(R.drawable.l131)
                .setSingleChoiceItems(arrayDialog,-1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "Выбранный кот:" + arrayDialog[which],
                                Toast.LENGTH_LONG).show();
                        //dialog.cancel();
                    }
                });
        builder.setPositiveButton("Ok, I am going to go to the kitchen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "Выбранный кот:" + arrayDialog[which],
                        Toast.LENGTH_LONG).show();
                //dialog.cancel();
            }
        });
        builder.setNegativeButton("Сам дурак!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "Выбранный кот:" + arrayDialog[which],
                        Toast.LENGTH_LONG).show();
            }
        });*/
        builder.setTitle("An important message!")
                .setIcon(R.drawable.l131)
                .setMultiChoiceItems(arrayDialog, checkedItemsArray, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                    }
                })
                .setPositiveButton("Готово",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                StringBuilder state = new StringBuilder();
                                for (int i = 0; i < arrayDialog.length; i++) {
                                    state.append("" + arrayDialog[i]);
                                    if (checkedItemsArray[i])
                                        state.append(" выбран\n");
                                    else
                                        state.append(" не выбран\n");
                                }
                                Toast.makeText(getActivity(),
                                        state.toString(), Toast.LENGTH_LONG)
                                        .show();
                            }
                        })

                .setNegativeButton("Отмена",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                dialog.cancel();
                            }
                        });
        builder.setCancelable(true);
        return  builder.create();
    }
}

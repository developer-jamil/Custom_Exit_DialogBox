package com.jamillabltd.customexitdialogbox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Dialog dialog;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Dialog Style 1
        Button style_1 = findViewById(R.id.style_1_id);
        style_1.setOnClickListener(view -> dialog_one_show());
        //Dialog Style 2
        Button style_2 = findViewById(R.id.style_2_id);
        style_2.setOnClickListener(view -> dialog_two_show());

        //Dialog Style 3
        Button style_3 = findViewById(R.id.style_3_id);
        style_3.setOnClickListener(view -> dialog_three_show());

        //Dialog Style 4
        Button style_4 = findViewById(R.id.style_4_id);
        style_4.setOnClickListener(view -> dialog_four_show());


    }

    private void dialog_one_show() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.jamil);
        builder.setTitle("Jamil Lab LTD");
        builder.setMessage("Do you want to exit the app?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", (dialog, id) -> {
            finish();
        });
        builder.setNegativeButton("No", (dialog, id) -> {
            dialog.cancel();
        });
        builder.setNeutralButton("Cancel", (dialog, id) -> {
            // Do nothing
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void dialog_two_show() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.jamil);
        builder.setTitle("Jamil Lab LTD");

        // create an ImageView with the desired image
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.warning);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(200, 200);
        layoutParams.setMargins(0, 10, 0, 0);
        imageView.setLayoutParams(layoutParams);
        imageView.setPadding(10, 10, 10, 10); // add padding

        // create a LinearLayout to hold the ImageView and the message
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER); // center contents horizontally and vertically
        layout.addView(imageView);
        TextView message = new TextView(this);
        message.setText("Do you want to exit the app?");
        message.setTextSize(20);
        message.setTextColor(Color.BLACK); // set text color
        message.setGravity(Gravity.CENTER); // center the text
        layout.addView(message);

        builder.setView(layout);

        builder.setCancelable(false);
        // set button colors using a custom style
        builder.setPositiveButton("Yes", (dialog, id) -> {
            finish();
        });
        builder.setNegativeButton("No", (dialog, id) -> {
            dialog.cancel();
        });
        builder.setNeutralButton("Cancel", (dialog, id) -> {
            // Do nothing
        });
        AlertDialog dialog = builder.create();
        dialog.show();

        Button positiveButton = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
        Button negativeButton = dialog.getButton(DialogInterface.BUTTON_NEGATIVE);
        Button neutralButton = dialog.getButton(DialogInterface.BUTTON_NEUTRAL);


        positiveButton.setTextColor(Color.RED);
        negativeButton.setTextColor(Color.GREEN);
        neutralButton.setTextColor(Color.BLACK);
    }


    @SuppressLint("ResourceAsColor")
    private void dialog_three_show() {
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_3);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.R.color.transparent));
        dialog.show();

        //cancel image
        ImageView cancelDialog = dialog.findViewById(R.id.cancelDialogId);
        cancelDialog.setOnClickListener(view -> dialog.dismiss());

        //cancel button
        TextView cancelButton = dialog.findViewById(R.id.cancelButtonId_D3);
        cancelButton.setOnClickListener(v -> dialog.dismiss());
        //yes button
        TextView yesButton = dialog.findViewById(R.id.yesButtonId_D3);
        yesButton.setOnClickListener(v -> finish());

    }


    @SuppressLint("ResourceAsColor")
    private void dialog_four_show() {
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_4);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.R.color.transparent));
        dialog.show();

        //cancel button
        TextView cancelButton = dialog.findViewById(R.id.cancelButtonId_D4);
        cancelButton.setOnClickListener(v -> dialog.dismiss());
        //yes button
        TextView yesButton = dialog.findViewById(R.id.yesButtonId_D4);
        yesButton.setOnClickListener(v -> finish());

    }
}
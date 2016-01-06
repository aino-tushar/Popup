package com.ainosoft.popup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout layoutOfPopup;
    PopupWindow popupMessage;
    Button popupButton, insidePopupButton;
    TextView popupText;

    //this is oncreate method

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        popupInit();
    }


    public void init() {
        popupButton = (Button) findViewById(R.id.searchButton);
        popupText = new TextView(this);
        insidePopupButton = new Button(this);
        layoutOfPopup = new LinearLayout(this);
        insidePopupButton.setText("OK");
        popupText.setText("This is Popup Window.press OK to dismiss it.");
        popupText.setPadding(0, 0, 0, 20);
        layoutOfPopup.setOrientation(LinearLayout.HORIZONTAL);
        layoutOfPopup.addView(popupText);
        layoutOfPopup.addView(insidePopupButton);
    }

    public void popupInit() {

        popupButton.setOnClickListener(this);
        insidePopupButton.setOnClickListener(this);
        LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = layoutInflater.inflate(R.layout.popup, null);


        popupMessage = new PopupWindow(popupView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupMessage.setContentView(popupView);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.searchButton) {
            popupMessage.showAsDropDown(popupButton, 0, 0);
        } else {
            popupMessage.dismiss();
        }
    }

}

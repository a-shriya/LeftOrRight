package com.example.leftorright;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.leftorright.modals.LeftOrRightExpert;

public class DescriptionActivity extends AppCompatActivity
{
    TextView descriptionTextView;
    LeftOrRightExpert leftOrRightExpert = new LeftOrRightExpert();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_description);
        bindViews();
        createNextActivity();
    }

    private void bindViews()
    {
        descriptionTextView = findViewById(R.id.textView_description);
    }

    private void createNextActivity()
    {
        Intent intent = getIntent();
        intent.getIntExtra("index",0);
        descriptionTextView.setText(leftOrRightExpert.nextDescription(leftOrRightExpert.getIndex()));
    }
}

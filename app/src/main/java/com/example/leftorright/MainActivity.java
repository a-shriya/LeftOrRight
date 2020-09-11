package com.example.leftorright;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.leftorright.modals.LeftOrRightExpert;

import java.io.File;
import java.net.URI;

public class MainActivity extends AppCompatActivity
{
    TextView houseNameView;
    TextView chooseTextView;
    Button otherButton;
    Button putMeHereButton;
    ImageView imageView;

    LeftOrRightExpert leftOrRightExpert = new LeftOrRightExpert();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        setupListeners();
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
    }

    private void  bindViews()
    {

        otherButton = findViewById(R.id.textView_other);
        chooseTextView = findViewById(R.id.textView_choose);
        putMeHereButton = findViewById(R.id.textView_putMeHere);
        imageView = findViewById(R.id.imageView);
    }

    private void setupListeners()
    {
        otherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                leftOrRightExpert.setIndex();
                imageView.setImageDrawable(getDrawable(leftOrRightExpert.nextHouse()));
            }
        });

        putMeHereButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("image/jpeg");
                intent.putExtra(Intent.EXTRA_EMAIL, "anegondi.shriya.@gmail.com");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                intent.putExtra(Intent.EXTRA_TEXT, leftOrRightExpert.nextDescription(leftOrRightExpert.getIndex()));
                File f = new File("drawable://"+leftOrRightExpert.nextHouse());
                intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(f));
                startActivity(Intent.createChooser(intent, "Send Email"));
            }
        });
    }
}
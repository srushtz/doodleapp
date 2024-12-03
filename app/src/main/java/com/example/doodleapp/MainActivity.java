package com.example.doodleapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private DoodleView doodleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        doodleView = findViewById(R.id.doodleView);

        // Clear Button
        Button clearButton = findViewById(R.id.clearButton);
        clearButton.setOnClickListener(view -> doodleView.clearCanvas());

        // Brush Size Button
        Button brushSizeButton = findViewById(R.id.brushSizeButton);
        brushSizeButton.setOnClickListener(view -> doodleView.setBrushSize(20));

        // Color Picker Button
        Button colorPickerButton = findViewById(R.id.colorPickerButton);
        colorPickerButton.setOnClickListener(view -> doodleView.setBrushColor(Color.RED));
    }
}

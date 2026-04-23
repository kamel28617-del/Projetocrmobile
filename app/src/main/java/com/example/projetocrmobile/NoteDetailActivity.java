package com.example.projetocrmobile;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class NoteDetailActivity extends AppCompatActivity {

    private TextView tvTitle, tvContent, tvSummary, tvKeywords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);

        tvTitle = findViewById(R.id.tvTitle);
        tvContent = findViewById(R.id.tvContent);
        tvSummary = findViewById(R.id.tvSummary);
        tvKeywords = findViewById(R.id.tvKeywords);

        Note note = (Note) getIntent().getSerializableExtra("note");
        if (note != null) {
            tvTitle.setText(note.getTitle());
            tvContent.setText(note.getContent());
            tvSummary.setText(note.getSummary() != null ? note.getSummary() : "No summary available");
            tvKeywords.setText(note.getKeywords() != null ? note.getKeywords() : "No keywords");
        }
    }
}
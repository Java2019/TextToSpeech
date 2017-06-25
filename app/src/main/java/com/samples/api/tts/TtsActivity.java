package com.samples.api.tts;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TtsActivity extends Activity
    implements TextToSpeech.OnInitListener, View.OnClickListener{

    private TextToSpeech tts;
    private Button button;
    private EditText text;

    @Override
    protected void onStop() {
        super.onStop();

        tts.shutdown();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tts);

        text = (EditText) findViewById(R.id.text);

        button = (Button)findViewById(R.id.bSpeech);
        button.setEnabled(false);

        tts = new TextToSpeech(getApplicationContext(), this);
    }

    @Override
    public void onInit(int status) {
        if ((status == tts.SUCCESS))
            button.setEnabled(true);
    }

    @Override
    public void onClick(View view) {
        tts.speak(text.getText().toString(),
                TextToSpeech.QUEUE_FLUSH, null);
    }
}

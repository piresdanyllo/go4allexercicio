package com.example.go4all;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void didClickDateButton(View view) {
        String instantNow = getInstantNow();
        String newTextDate = "Timestamp:" + instantNow;
        updateTextViewTimestamp(newTextDate);
        String lastCharacter = getLastCharacterOfString(instantNow);
        int color = getColorBasedOnLastCharacter(lastCharacter);
        updateMainActivityBackgroundColor(color);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private String getInstantNow() {
        Instant instantNow = Instant.now(); //instancia timestamp atual
        return instantNow.toString();
    }

    private void updateMainActivityBackgroundColor(int color){
         View view = this.getWindow().getDecorView();
         view.setBackgroundColor(color);
    }

    private String getLastCharacterOfString(String string){
        int stringLength = string.length();//retornar o tamanho de comprimento da string timstamp
        String codeColor = string.substring(stringLength-2,stringLength-1);//retornar o ultimo caractere da string
        return codeColor;
    }

    private void updateTextViewTimestamp(String newText) {
        TextView timestampRightNow = findViewById(R.id.timestamprightnow); // pegando instância baseado no identificador
        timestampRightNow.setText(newText);//setando novo texto baseado na string anterior
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private int getColorBasedOnLastCharacter(String lastCharacter){
        switch (lastCharacter)//define a cor baseado no ultimo caractere
        {
            case "0":
                return getColor(R.color.white);
            case "1":
                return getColor(R.color.black);
            case "2":
                return getColor(R.color.blue);
            case "3":
                return getColor(R.color.green);
            case "4":
                return getColor(R.color.pink);
            case "5":
                return getColor(R.color.red);
            case "6":
                return getColor(R.color.purple);
            case "7":
                return getColor(R.color.yellow);
            case "8":
                return getColor(R.color.gray);
            case "9":
                return getColor(R.color.orange);
            default:
                return getColor(R.color.white);
        }
    }
}


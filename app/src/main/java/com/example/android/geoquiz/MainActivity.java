package com.example.android.geoquiz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    RadioGroup question1;
    boolean answer1;
    RadioGroup question2;
    boolean answer2;
    RadioGroup question3;
    boolean answer3;
    RadioGroup question4;
    boolean answer4;
    RadioGroup question6;
    boolean answer6;
    RadioGroup question10;
    boolean answer10;
    CheckBox lasagnaCBox;
    boolean isLasagna;
    CheckBox focacciaCBox;
    boolean isFocaccia;
    CheckBox mussacàCBox;
    boolean isMussacà;
    CheckBox tortelliniCBox;
    boolean isTortellini;
    CheckBox koftaCBox;
    boolean isKofta;
    CheckBox switzCBox;
    boolean isSwitz;
    CheckBox ausCBox;
    boolean isAus;
    CheckBox fraCBox;
    boolean isFra;
    CheckBox sloCBox;
    boolean isSlo;
    CheckBox croCBox;
    boolean isCro;
    CheckBox gerCBox;
    boolean isGer;
    CheckBox luxCBox;
    boolean isLux;
    CheckBox sMarCBox;
    boolean isSMar;
    CheckBox vatCBox;
    boolean isVat;
    CheckBox spainCBox;
    boolean isSpain;
    EditText question7;
    String answer7;
    EditText question9;
    String answer9;
    EditText question11;
    String name;

    int scoreCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitAnswers(View view) {
        if (answerChecker()) {
            scoreCounter();
            if (scoreCount == 0) {
                Toast.makeText(this, getString(R.string.zero_points, name), Toast.LENGTH_LONG).show();
            } else if (scoreCount <= 5) {
                Toast.makeText(this, getString(R.string.too_bad, name, scoreCount), Toast.LENGTH_LONG).show();
            } else if (scoreCount < 8) {
                Toast.makeText(this, getString(R.string.good_job_toast, name, scoreCount), Toast.LENGTH_LONG).show();
            } else if (scoreCount < 10) {
                Toast.makeText(this, getString(R.string.congrats, name, scoreCount), Toast.LENGTH_LONG).show();
            } else if (scoreCount == 10) {
                Toast.makeText(this, getString(R.string.awestanding, name, scoreCount), Toast.LENGTH_LONG).show();
            }

        } else {
            errorMessage();
        }

    }

    public boolean answerChecker() {
        question1 = (RadioGroup) findViewById(R.id.answer_1);
        answer1 = question1.getCheckedRadioButtonId() == question1.getChildAt(0).getId();

        question2 = (RadioGroup) findViewById(R.id.answer_2);
        answer2 = question2.getCheckedRadioButtonId() == question2.getChildAt(1).getId();

        question3 = (RadioGroup) findViewById(R.id.answer_3);
        answer3 = question3.getCheckedRadioButtonId() == question3.getChildAt(2).getId();

        question4 = (RadioGroup) findViewById(R.id.answer_4);
        answer4 = question4.getCheckedRadioButtonId() == question4.getChildAt(1).getId();

        question6 = (RadioGroup) findViewById(R.id.answer_6);
        answer6 = question6.getCheckedRadioButtonId() == question6.getChildAt(1).getId();

        question10 = (RadioGroup) findViewById(R.id.answer_10);
        answer10 = question10.getCheckedRadioButtonId() == question10.getChildAt(0).getId();

        lasagnaCBox = (CheckBox) findViewById(R.id.lasagna_checkbox);
        isLasagna = lasagnaCBox.isChecked();

        focacciaCBox = (CheckBox) findViewById(R.id.focaccia_checkbox);
        isFocaccia = focacciaCBox.isChecked();

        mussacàCBox = (CheckBox) findViewById(R.id.mussacà_checkbox);
        isMussacà = mussacàCBox.isChecked();

        tortelliniCBox = (CheckBox) findViewById(R.id.tortellini_checkbox);
        isTortellini = tortelliniCBox.isChecked();

        koftaCBox = (CheckBox) findViewById(R.id.kofta_checkbox);
        isKofta = koftaCBox.isChecked();

        switzCBox = (CheckBox) findViewById(R.id.switz_checkbox);
        isSwitz = switzCBox.isChecked();

        ausCBox = (CheckBox) findViewById(R.id.aus_checkbox);
        isAus = ausCBox.isChecked();

        fraCBox = (CheckBox) findViewById(R.id.fra_checkbox);
        isFra = fraCBox.isChecked();

        sloCBox = (CheckBox) findViewById(R.id.slov_checkbox);
        isSlo = sloCBox.isChecked();

        croCBox = (CheckBox) findViewById(R.id.cro_checkbox);
        isCro = croCBox.isChecked();

        gerCBox = (CheckBox) findViewById(R.id.ger_checkbox);
        isGer = gerCBox.isChecked();

        luxCBox = (CheckBox) findViewById(R.id.lux_checkbox);
        isLux = luxCBox.isChecked();

        sMarCBox = (CheckBox) findViewById(R.id.smar_checkbox);
        isSMar = sMarCBox.isChecked();

        vatCBox = (CheckBox) findViewById(R.id.vat_checkbox);
        isVat = vatCBox.isChecked();

        spainCBox = (CheckBox) findViewById(R.id.spain_checkbox);
        isSpain = spainCBox.isChecked();

        question7 = (EditText) findViewById(R.id.answer_7);
        answer7 = question7.getText().toString();

        question9 = (EditText) findViewById(R.id.answer_9);
        answer9 = question9.getText().toString();

        question11 = (EditText) findViewById(R.id.name);
        name = question11.getText().toString();

        int answeredCount = 0;

        if (question1.getCheckedRadioButtonId() != -1 && question2.getCheckedRadioButtonId() != -1 && question3.getCheckedRadioButtonId() != -1 && question4.getCheckedRadioButtonId() != -1 && question6.getCheckedRadioButtonId() != -1 && question10.getCheckedRadioButtonId() != -1) {
            answeredCount++;
        }
        if (isLasagna || isFocaccia || isMussacà || isKofta || isTortellini) {
            answeredCount++;
        }
        if (isAus || isCro || isFra || isGer || isLux || isSlo || isSMar || isSpain || isSwitz) {
            answeredCount++;
        }

        if (answer7.length() != 0 && answer9.length() != 0 && name.length() != 0) {
            answeredCount++;
        }

        if (answeredCount == 4) {
            return true;
        } else {
            return false;
        }
    }

    public void scoreCounter() {

        scoreCount = 0;

        if (answer1) {
            scoreCount++;
        }

        if (answer2) {
            scoreCount++;
        }

        if (answer3) {
            scoreCount++;
        }

        if (answer4) {
            scoreCount++;
        }


        if (answer6) {
            scoreCount++;
        }

        if (answer10) {
            scoreCount++;
        }

        if (!isFocaccia && isKofta && !isLasagna && isMussacà && !isTortellini) {
            scoreCount++;
        }

        if (isAus && !isCro && isFra && !isGer && !isLux && isSlo && isSMar && !isSpain && isVat && isSwitz) {
            scoreCount++;
        }

        if (answer7.equals(getString(R.string.switzerland))) {
            scoreCount++;
        }

        if (answer9.equals("Buenos Aires")) {
            scoreCount++;
        }
    }

    public void share(View view) {
        if (scoreCount != 0) {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.email_main, scoreCount));
            intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        } else {
            Toast.makeText(this, getString(R.string.error_share), Toast.LENGTH_SHORT).show();
        }
    }

    public void errorMessage() {
        Toast.makeText(this, getString(R.string.error_message), Toast.LENGTH_SHORT).show();
    }
}
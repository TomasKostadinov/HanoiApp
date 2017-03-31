/*
 * Copyright (c) 2017 Tomas Kostadinov
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this
 * software and associated documentation files (the "Software"), to deal in the Software
 * without restriction, including without limitation the rights to use, copy, modify, merge,
 * publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons
 * to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR
 * IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package com.tomaskostadinov.hanoi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private int ZugNr;
    private int count;

    private TextView mTextView;
    private EditText mEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textView);
        mEditText = (EditText) findViewById(R.id.editText);
        Button mButton = (Button) findViewById(R.id.button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.buttonClick();
            }
        });
    }


    public void buttonClick() {
        ZugNr = 0;
        count = Integer.parseInt(mEditText.getText().toString());
        mTextView.setText("");
        mTextView.append("Türme von Hanoi. count " + count);
        mTextView.append("\n\n");
        Hanoi(count, "links", "rechts", "mitte");
    }

    public void move(int n, String startpfosten, String zielpfosten) {
        ZugNr++;
        if (n == count) {
            mTextView.append("      -----------------------------------------------------\n");
        }

        mTextView.append(String.format("%4d. ", ZugNr));
        for (int i = 1; i <= (count - n); i++) {
            mTextView.append("  ");
        }
        mTextView.append("Trage Scheibe " + n + " von " + startpfosten + " nach " + zielpfosten + "\n");

        if (n == count) {
            mTextView.append("      -----------------------------------------------------\n");
        }
    }

    public void Hanoi(int n, String start, String ziel, String hilf) {
        if (n > 1) {
            Hanoi(n - 1, start, hilf, ziel);
        }
        move(n, start, ziel);
        if (n > 1) {
            Hanoi(n - 1, hilf, ziel, start);
        }
    } // Hanoi


}

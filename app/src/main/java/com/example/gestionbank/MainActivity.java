package com.example.gestionbank;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gestionbank.models.Account;
import java.util.Date;



public class MainActivity extends AppCompatActivity {
    private TextView solde;
    private EditText amountInput;
    private EditText motif;
    private Account account;
    private Date date ;
    private Button btnDebit;
    private Button btnCredit;
    private int i=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        account = new Account();
        displaySolde(account);
        this.btnDebit = findViewById(R.id.btnDebit);
        btnDebit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amountInput = findViewById(R.id.amoutInput);
                motif = findViewById(R.id.motif);
                String amountText = amountInput.getText().toString();
                String motifText = motif.getText().toString();
                if(amountText != null) {
                    double amount = Double.parseDouble(amountText);
                    double data = account.Debit(amount);
                    if(data >=0) {
                        date = new Date();
                        displaySolde(account);
                        LinearLayout llMain = findViewById(R.id.llayoutv);
                        TextView textView = new TextView(MainActivity.this);
                        textView.setId(++i);
                        textView.setText(i + ":\t-" + amountText +" USD\t|\t" + motifText + "\t|" + date);
                        textView.setBackgroundColor(Color.parseColor("#D3D3D3"));
                        textView.setTextColor(Color.parseColor("#FF0000"));
                        textView.setTextSize(20);
                        textView.setBottom(5);

                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT

                        );
                        textView.setLayoutParams(params);
                        llMain.addView(textView);
                    }
                }

            }
        });

        this.btnCredit = findViewById(R.id.btnCredit);
        btnCredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amountInput = findViewById(R.id.amoutInput);
                motif = findViewById(R.id.motif);
                String amountText = amountInput.getText().toString();
                String motifText = motif.getText().toString();
                if (amountText != null) {
                    double amount = Double.parseDouble(amountText);
                    double data = account.Credit(amount);
                    displaySolde(account);
                    date = new Date();
                    LinearLayout llMain = findViewById(R.id.llayoutv);
                    TextView textView = new TextView(MainActivity.this);
                    textView.setId(++i);
                    textView.setText(i + ":\t+" + amountText + " USD\t|\t" + motifText + "\t|" + date);
                    textView.setBackgroundColor(Color.parseColor("#D3D3D3"));
                    textView.setTextColor(Color.parseColor("#008000"));
                    textView.setTextSize(20);
                    textView.setBottom(5);

                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT

                    );
                    textView.setLayoutParams(params);
                    llMain.addView(textView);
                }

            }
        });
    }

    public void displaySolde(Account acc){
        this.solde = (TextView)findViewById(R.id.soldeView);
        double sld = acc.getAmount();
        this.solde.setText(Double.toString(sld));
    }


}
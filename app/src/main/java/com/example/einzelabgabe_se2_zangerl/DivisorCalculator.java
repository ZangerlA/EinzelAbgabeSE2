package com.example.einzelabgabe_se2_zangerl;

import android.widget.TextView;

public class DivisorCalculator implements Runnable {
    private TextView view;
    private String matNr;

    public DivisorCalculator(TextView view, String matNr) {
        this.view = view;
        this.matNr = matNr;
    }

    @Override
    public void run() {
        String result = calculateMatNr(matNr);
        view.setText(result);
    }

    public String calculateMatNr(String matNr) {
        String result = "";
        for (int i = 0; i < matNr.length(); i++) {
            for (int j = i+1; j < matNr.length(); j++) {
                for (int k = 2; k < 10; k++) {
                    if (matNr.charAt(i) % k == 0 && matNr.charAt(i) != '0') {
                        if (matNr.charAt(j) % k == 0 && matNr.charAt(j) != '0') {
                            result += i + " + " + j + " | ";
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
}

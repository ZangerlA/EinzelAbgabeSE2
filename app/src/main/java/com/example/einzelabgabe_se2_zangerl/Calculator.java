package com.example.einzelabgabe_se2_zangerl;

import android.widget.TextView;

public class Calculator implements Runnable {
    TextView view;
    String matNr;

    public Calculator(TextView view, String matNr) {
        this.view = view;
        this.matNr = matNr;
    }

    @Override
    public void run() {
        calculateMatNr(matNr);
    }

    public static void calculateMatNr(String matNr) {
        int index1 = -1;
        int index2 = -1;
        for (int i = 0; i < matNr.length(); i++) {
            for (int j = i+1; j < matNr.length(); j++) {
                for (int k = 0; k < 10; k++) {
                    if (matNr.charAt(i) % k == 0) {
                        if (matNr.charAt(j) % k == 0) {
                            index1 = i;
                            index2 = j;
                        }
                    }
                }
            }
        }
        System.out.println(index1);
        System.out.println(index2);
    }
}

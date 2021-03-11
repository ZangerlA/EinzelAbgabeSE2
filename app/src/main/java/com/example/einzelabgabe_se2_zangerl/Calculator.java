package com.example.einzelabgabe_se2_zangerl;

public class Calculator implements Runnable {
    @Override
    public void run() {
    }

    public void calculateMatNr(String matNr) {
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

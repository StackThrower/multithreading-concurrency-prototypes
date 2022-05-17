package com.multitreading;

public enum Currency {

    USD("USD", "D"),
    EUR("EUR", "E"),
    CAD("CAD", "C"),
    GBP("GBP", "G");

    String label;

    String isoCode;

    Currency(String label, String isoCode) {
        this.label = label;
        this.isoCode = isoCode;
    }

}

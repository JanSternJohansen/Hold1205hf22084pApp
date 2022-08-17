package com.example.customcarlist;

public class Bil
{
    String overskrift;
    String beskrivelse;
    int bilBillede;

    public Bil(String overskrift, String beskrivelse, int bilBillede) {
        this.overskrift = overskrift;
        this.beskrivelse = beskrivelse;
        this.bilBillede = bilBillede;
    }

    public String getOverskrift() {
        return overskrift;
    }

    public void setOverskrift(String overskrift) {
        this.overskrift = overskrift;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public int getBilBillede() {
        return bilBillede;
    }

    public void setBilBillede(int bilBillede) {
        this.bilBillede = bilBillede;
    }
}

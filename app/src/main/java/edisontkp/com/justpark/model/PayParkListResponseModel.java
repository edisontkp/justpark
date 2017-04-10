package edisontkp.com.justpark.model;

import java.util.ArrayList;

/**
 * Created by edisontkp on 16/10/2016.
 */

public class PayParkListResponseModel {
    ArrayList<PayParkResponseModel> PayList;

    public PayParkListResponseModel(ArrayList<PayParkResponseModel> payList) {
        PayList = payList;
    }

    public ArrayList<PayParkResponseModel> getPayList() {
        return PayList;
    }

    public void setPayList(ArrayList<PayParkResponseModel> payList) {
        PayList = payList;
    }
}

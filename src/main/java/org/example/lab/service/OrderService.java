package org.example.lab.service;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    public List<String> getCardType(){
        List<String> list = new ArrayList<String>();
        list.add("Visa");
        list.add("Mastercard");
        list.add("Diners");
        return list;
    }


}

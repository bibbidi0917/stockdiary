package com.koscom.stockdiary.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTransList {
    List<Item> item;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class Item {
        private String type;
        private String date;
        private String sum;
        private int count;
        private String price;
        private String curSum;
        private String stockName;
    }
}

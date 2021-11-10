package com.koscom.stockdiary.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Builder
@Getter
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue
    private Long id;

    private String type;
    private String date;
    private String sum;
    private int count;
    private String price;
    private String curSum;
    private String stockName;


}
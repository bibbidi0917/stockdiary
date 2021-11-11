package com.koscom.stockdiary.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@Getter
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
    String stockName;
    @Id
    String stockcode;
}
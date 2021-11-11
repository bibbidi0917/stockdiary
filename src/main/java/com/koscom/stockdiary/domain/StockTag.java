package com.koscom.stockdiary.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
public class StockTag {
    private String name;

    @Id
    private String marketCode;
}

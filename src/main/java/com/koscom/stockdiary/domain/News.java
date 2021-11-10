package com.koscom.stockdiary.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Builder
@Getter
public class News {
    private String title;
    private String link;
}

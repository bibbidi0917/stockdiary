package com.koscom.stockdiary.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class News {
    private String title;
    private String link;
}

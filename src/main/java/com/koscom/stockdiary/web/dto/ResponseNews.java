package com.koscom.stockdiary.web.dto;

import com.koscom.stockdiary.domain.News;
import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseNews {

    private List<Item> items;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Item {
        private String title;
        private String link;
    }
}
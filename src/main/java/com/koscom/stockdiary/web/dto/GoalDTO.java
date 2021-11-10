package com.koscom.stockdiary.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GoalDTO<T> {

    private T object;
    private int progress;

    @Builder
    private GoalDTO(T object, int progress) {
        this.object = object;
        this.progress = progress;
    }
}

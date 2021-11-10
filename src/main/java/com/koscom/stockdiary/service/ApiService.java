package com.koscom.stockdiary.service;

import com.koscom.stockdiary.domain.ApiRepository;
import com.koscom.stockdiary.web.dto.ResponseStock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiService {
    private final ApiRepository apiRepository;

    public String getPrice(final String marketcode, final String issuecode) {
        return apiRepository.findByQuery(marketcode, issuecode);
    }
}

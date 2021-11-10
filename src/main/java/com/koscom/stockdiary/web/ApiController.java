package com.koscom.stockdiary.web;

import com.koscom.stockdiary.domain.News;
import com.koscom.stockdiary.service.ApiService;
import com.koscom.stockdiary.web.dto.ResponseStock;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/koscom")
@RequiredArgsConstructor
public class ApiController {

    private final ApiService apiService;

    @GetMapping("/price")
    public String getPriceByQuery(@RequestParam(name = "mc") String marketcode, @RequestParam(name = "ic") String issuecode) {

        return apiService.getPrice(marketcode, issuecode);
    }
}

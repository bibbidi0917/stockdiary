package com.koscom.stockdiary.web;

import com.koscom.stockdiary.domain.News;
import com.koscom.stockdiary.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/search")
@RequiredArgsConstructor
public class SearchController {

    private final NewsService newsService;

    @GetMapping("/news")
    public List<News> getNewsByQuery(@RequestParam(name = "q") String query) {
        return newsService.search(query);
    }
}

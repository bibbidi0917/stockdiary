package com.koscom.stockdiary.service;

import com.koscom.stockdiary.domain.News;
import com.koscom.stockdiary.web.dto.ResponseNews;
import com.koscom.stockdiary.domain.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsService {
    private final NewsRepository newsRepository;

    public List<News> search(final String query) {
        return newsRepository.findByQuery(query);
    }
}

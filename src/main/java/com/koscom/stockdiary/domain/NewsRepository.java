package com.koscom.stockdiary.domain;

import java.util.List;

public interface NewsRepository {
    List<News> findByQuery(String query);
}

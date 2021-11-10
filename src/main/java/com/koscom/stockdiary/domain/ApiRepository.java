package com.koscom.stockdiary.domain;

import com.koscom.stockdiary.web.dto.ResponseStock;

public interface ApiRepository {

    String findByQuery(String marketcode, String issuecode);
}


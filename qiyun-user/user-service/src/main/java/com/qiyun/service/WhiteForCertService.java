package com.qiyun.service;

import com.qiyun.model2.WhiteForCert2;

import java.util.List;

public interface WhiteForCertService {
    WhiteForCert2 getByCert(String certNo);

    void update(WhiteForCert2 byCert);

    List<WhiteForCert2> getWhiteCertByStatus(int page, int pageSize, int i);

    void add(WhiteForCert2 byCert);
}

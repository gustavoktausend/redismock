package com.teste.redismock.redismock.service;

import com.teste.redismock.redismock.model.Util;
import com.teste.redismock.redismock.repository.UtilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilService {

    @Autowired
    private UtilRepository utilRepository;

    public void insert(Util newUtil) {
        utilRepository.save(
                Util.builder()
                    .id(newUtil.getId())
                    .page_title(newUtil.getPage_title())
                    .play_button(newUtil.getPlay_button())
                    .ranking_title(newUtil.getRanking_title())
                    .rules_button(newUtil.getRules_button())
                    .logo_top(newUtil.getLogo_top())
                    .meta_description(newUtil.getMeta_description())
                    .build()
        );
    }

    public Util getById(String id) throws Exception {
        return utilRepository.findById(id).orElseThrow(Exception::new);
    }

}

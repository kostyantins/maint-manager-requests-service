package com.example.requestsservice.service;

import com.example.requestsservice.domain.MaintCopy;
import com.example.requestsservice.domain.MaintCopyDto;
import com.example.requestsservice.feigns.MaintRequestFeign;
import com.example.requestsservice.repository.MaintCopyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MaintClientService {

    public final MaintRequestFeign maintRequestFeign;
    public final MaintCopyRepository maintCopyRepository;

    @Transactional
    public void synchronizeRequestById(Long maintId) {
        MaintCopy maintCopy = maintRequestFeign.getMaintCopy(maintId);

        maintCopyRepository.save(MaintCopy.builder()
                .maintId(maintId)
                .maintIdentifier(maintCopy.getMaintIdentifier())
                .build());
    }
}

package com.rootnite.fastdelivery.microwsdms.service.dms;

import com.rootnite.fastdelivery.microwsdms.controller.dto.ClientDto;
import com.rootnite.fastdelivery.microwsdms.model.entity.dms.Client;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Edy Huiza
 * @since 05/30/2020
 */
public interface ClientService {
    @Transactional(readOnly = true)
    List<Client> findAll();

    @Transactional(readOnly = true)
    Optional<Client> findByEmail(String email);

    @Transactional(readOnly = true)
    Optional<Client> get(Long id);

    @Transactional
    Client persist(ClientDto clientDto);

    @Transactional
    void update(Client client);

    @Transactional
    void disableAccount(Client client);
}

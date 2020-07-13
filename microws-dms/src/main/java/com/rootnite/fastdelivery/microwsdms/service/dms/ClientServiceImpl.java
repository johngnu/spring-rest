package com.rootnite.fastdelivery.microwsdms.service.dms;

import com.rootnite.fastdelivery.microwsdms.controller.dto.ClientDto;
import com.rootnite.fastdelivery.microwsdms.model.entity.dms.Client;
import com.rootnite.fastdelivery.microwsdms.model.repository.dms.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Edy Huiza
 * @since 05/30/2020
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> findByEmail(String email) {
        return clientRepository.findByEmail(email.trim());
    }

    @Override
    public Optional<Client> get(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Client persist(ClientDto clientDto) {
        Client client = new Client();
        client.setEmail(clientDto.getEmail().trim().toLowerCase());
        client.setCompleteName(clientDto.getCompleteName().trim().toUpperCase());
        client.setAuthType(clientDto.getAuthType());
        client.setAuthId(clientDto.getAuthId());
        clientRepository.save(client);
        return client;
    }

    @Override
    public void update(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void disableAccount(Client client) {
        client.setEnabled(false);
        clientRepository.save(client);
    }
}

package com.rootnite.fastdelivery.microwsdms.controller.v1;

import com.rootnite.fastdelivery.microwsdms.controller.dto.ClientDto;
import com.rootnite.fastdelivery.microwsdms.model.entity.dms.Client;
import com.rootnite.fastdelivery.microwsdms.service.dms.ClientService;
import com.rootnite.fastdelivery.microwsdms.util.RestConstant;
import com.rootnite.fastdelivery.microwsdms.util.ResultResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Log4j2
@CrossOrigin
@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    @Autowired
    ClientService parameterService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(ResultResponse.builder().status(true).message(RestConstant.RESPONSE_FIND_SUCCESSFULLY).data(parameterService.findAll()).build(),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") long id) {
        Optional<Client> client = parameterService.get(id);
        return client.map(value -> new ResponseEntity<>(ResultResponse.builder().status(true).message(RestConstant.RESPONSE_FIND_SUCCESSFULLY).data(value).build(), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(ResultResponse.builder().status(false).message(RestConstant.RESPONSE_NOT_FOUND_RECORD + id).data(null).build(), HttpStatus.OK));
    }

    @PostMapping
    public ResponseEntity<?> persist(@RequestBody ClientDto clientDto) {
        if (!parameterService.findByEmail(clientDto.getEmail()).isPresent()) {
            Client client = parameterService.persist(clientDto);
            log.info(RestConstant.LOG_PERSIST, client.getId());
            return new ResponseEntity<>(ResultResponse.builder().status(true).message(RestConstant.RESPONSE_PERSIST_SUCCESSFULY).data(client.getId()).build(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(ResultResponse.builder().status(false).message("Cliente con email ya registrado").data(null).build(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody ClientDto clientDto) {
        Optional<Client> client = parameterService.get(id);
        if (client.isPresent()) {
            client.get().setCompleteName(clientDto.getCompleteName());
            client.get().setBirthday(clientDto.getBirthday());
            client.get().setGender(clientDto.getGenero());
            client.get().setNit(clientDto.getNit());
            client.get().setBusinessName(clientDto.getBusinessName());
            parameterService.update(client.get());
            log.info(RestConstant.LOG_UPDATE, id);
            return new ResponseEntity<>(ResultResponse.builder().status(true).message(RestConstant.RESPONSE_UPDATE_SUCCESSFULY).data(client.get().getId()).build(), HttpStatus.OK);
        }
        return new ResponseEntity<>(ResultResponse.builder().status(false).message(RestConstant.RESPONSE_NOT_FOUND_RECORD + id).data(null).build(), HttpStatus.OK);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<?> updateStatus(@PathVariable("id") Long id) {
        Optional<Client> client = parameterService.get(id);
        if (client.isPresent()) {
            if (client.get().getEnabled())
                client.get().setEnabled(false);
            else
                client.get().setEnabled(true);
            parameterService.update(client.get());
            log.info(RestConstant.LOG_UPDATE, id);
            return new ResponseEntity<>(ResultResponse.builder().status(true).message(RestConstant.RESPONSE_UPDATE_SUCCESSFULY).data(client.get().getId()).build(), HttpStatus.OK);
        }
        return new ResponseEntity<>(ResultResponse.builder().status(false).message(RestConstant.RESPONSE_NOT_FOUND_RECORD + id).data(null).build(), HttpStatus.OK);
    }

    /* john commit */
    /* john commit 2 */
}

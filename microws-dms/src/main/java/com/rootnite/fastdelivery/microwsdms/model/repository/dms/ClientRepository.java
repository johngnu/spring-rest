package com.rootnite.fastdelivery.microwsdms.model.repository.dms;

import com.rootnite.fastdelivery.microwsdms.model.entity.dms.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Edy Huiza
 * @since 05/29/2020
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByEmail(String email);
}

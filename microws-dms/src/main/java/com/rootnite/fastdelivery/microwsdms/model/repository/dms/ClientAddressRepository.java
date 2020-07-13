package com.rootnite.fastdelivery.microwsdms.model.repository.dms;

import com.rootnite.fastdelivery.microwsdms.model.entity.dms.ClientAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Edy Huiza
 * @since 05/29/2020
 */
@Repository
public interface ClientAddressRepository extends JpaRepository<ClientAddress, Long> {
}
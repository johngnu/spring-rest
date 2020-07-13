package com.rootnite.fastdelivery.microwsdms.model.repository.config;

import com.rootnite.fastdelivery.microwsdms.model.entity.config.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Edy Huiza
 * @since 05/08/2020
 */
@Repository
public interface ParameterRepository extends JpaRepository<Parameter, Long> {
}

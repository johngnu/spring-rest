package com.rootnite.fastdelivery.microwsdms.model.repository.config;

import com.rootnite.fastdelivery.microwsdms.model.entity.config.ParameterItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Edy Huiza
 * @since 05/08/2020
 */
@Repository
public interface ParameterItemRepository extends JpaRepository<ParameterItem, Long> {

    List<ParameterItem> findAllByParameterId(long parameterId);
}

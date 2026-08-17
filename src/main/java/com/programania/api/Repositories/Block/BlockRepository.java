package com.programania.api.Repositories.Block;

import com.programania.api.Models.Block.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BlockRepository extends JpaRepository <Block, Long> {

    Optional<Block> findByUuid(UUID uuid);

}

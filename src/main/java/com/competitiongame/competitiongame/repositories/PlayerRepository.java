package com.competitiongame.competitiongame.repositories;

import com.competitiongame.competitiongame.entities.Player;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaSpecificationExecutor<Player>,
        PagingAndSortingRepository<Player, Integer>, CrudRepository<Player,Integer> {

    @Query("select e from Player e where e.playerName =:playerName ")
    Player checkExist(@Param("playerName") String playerName);

    @Query("select e from Player e")
    List<Player> playerList ();

}

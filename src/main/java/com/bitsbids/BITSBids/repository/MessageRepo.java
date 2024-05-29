package com.bitsbids.BITSBids.repository;

import com.bitsbids.BITSBids.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@EnableJpaRepositories
public interface MessageRepo extends JpaRepository<Message,Long> {
//    @Query(value = "SELECT * FROM messages WHERE sender_name LIKE %:sname% AND receiver_name LIKE %:rname%",nativeQuery = true)
    List<Message>findMessagesBySenderNameAndReceiverName(String sname,String rname);
    @Query(value = "SELECT * FROM messages WHERE sender_name LIKE %:name%", nativeQuery = true)
    List<Message> findMessagesBySenderName(@Param("name")String name);
    @Query(value = "SELECT * FROM messages WHERE receiver_name LIKE %:name%", nativeQuery = true)
    List<Message> findMessagesByReceiverName(@Param("name")String name);


}

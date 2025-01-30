package com.management.VMS.repo;

import com.management.VMS.entity.Flat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlatRepo extends JpaRepository<Flat, Long> {
    Flat findByNumber(String number);
}

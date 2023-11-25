package com.example.spring.repository;

import com.example.spring.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface MemoRepository extends JpaRepository<Memo, Long>{
    List<Memo> findByMnoBetweenOrderByMnoDesc(Long from, Long to);
}

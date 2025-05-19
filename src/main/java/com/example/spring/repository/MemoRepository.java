package com.example.spring.repository;

import com.example.spring.entity.Memo;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long>{
    List<Memo> findByMnoBetweenOrderByMnoDesc(Long from, Long to);
    Page<Memo> findByMnoBetween(Long from, Long to, Pageable pageable);
    void deleteMemoByMnoLessThan(Long num);

    @Query("select m from Memo m order by m.mno desc")
    List<Memo> getListDesc();
    // ?1, ?2, :xxx, .#{} 을 사용해서 쿼리에 where문 대신 사용가능
    @Transactional
    @Modifying
//    @Query("update Memo m set m.memoText = :memoText where m.mno = :mno ")
    @Query("update Memo m set m.memoText = :#{#param.memoText} where m.mno = :#{#param.mno}")
    int updateMemoText(@Param("mno") Long mno, @Param("memoText") String memoText);

    @Query(value= "select m from Memo m where m.mno > :mno", countQuery = "select count(m) from Memo m where m.mno >:mno")
    Page<Memo> getListWithQuery(Long mno, Pageable pageable);

    @Query(value = "select m.mno, m.memoText, CURRENT_DATE from Memo m where m.mno > :mno",
    countQuery = "select count(m) from Memo m where m.mno>:mno")
    Page<Object[]> getListWithQueryObject(Long mno, Pageable pageable);

    
}

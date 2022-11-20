package com.org.accountbook.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.accountbook.domain.enntity.AccountBook;

/**
 * @author jhkim
 * @since 2022-10-29
 *
 */
@Repository
public interface AccountBookRepository extends JpaRepository<AccountBook, Long> {
	Optional<AccountBook> findByAccountBookName(String accountBookName);
	Optional<AccountBook> findByAccountBookNoAndDeleteYn(Long accountBookNo, Character deleteYn);
	Optional<AccountBook> findByAccountBookNo(Long accountBookNo);


}

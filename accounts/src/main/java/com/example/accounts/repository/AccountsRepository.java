package com.example.accounts.repository;

import com.example.accounts.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {
    Optional<Accounts> findByCustomerId(Long customerId);


    /*
     * @Transactional :@Transactional, bir işlem (transaction) başlatmak için kullanılan bir anotasyondur.
     *  Bu anotasyon, özellikle
     * veritabanı üzerinde yapılan işlemlerin, işlemler (transactions) şeklinde yönetilmesini sağlar.
     * @Modifying :@Modifying, Spring Data JPA ile kullanılan ve veritabanı üzerinde değişiklik yapmayı amaçlayan (INSERT, UPDATE, DELETE) sorgularda kullanılan bir anotasyondur.
     *  Bu anotasyon, veritabanı işlemlerini değiştiren (modifying) sorgular için gereklidir
     *  ve genellikle @Query anotasyonu ile birlikte kullanılır.
     */
    @Transactional
    @Modifying
    void deleteByCustomerId(Long customerId);
}
package com.example.neo.repository

import com.example.neo.entity.CRUDEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CRUDRepository : JpaRepository<CRUDEntity, Long>
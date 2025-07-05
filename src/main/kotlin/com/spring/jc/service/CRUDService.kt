package com.example.neo.service

import com.example.neo.dto.CRUDDto
import com.example.neo.entity.CRUDEntity
import com.example.neo.repository.CRUDRepository
import org.springframework.stereotype.Service

@Service
class CRUDService (
    private val crudRepository: CRUDRepository
){

    private fun toEntity(crudDto: CRUDDto): CRUDEntity{
        return CRUDEntity(
            title = crudDto.title,
            content = crudDto.content
        )
    }

    private fun toDto(crudEntity: CRUDEntity): CRUDDto{
        return CRUDDto(
            id = crudEntity.id!!,
            title = crudEntity.title,
            content = crudEntity.content
        )
    }

    fun create(
        body: CRUDDto
    ){
        crudRepository.save(toEntity(body))
    }

    fun readAll(): List<CRUDDto> {
        return crudRepository.findAll().map {
            toDto(it)
        }
    }

    fun readById(id: Long): CRUDDto {
        return toDto(crudRepository.findById(id).get())
    }

    fun update(dto: CRUDDto){
        val crudEntity = crudRepository.findById(dto.id).get()


        crudEntity.update(
            title = dto.title,
            content = dto.content
        )

        crudRepository.save(crudEntity)
    }

    fun deleteById(id: Long){
        crudRepository.deleteById(id)
    }

}
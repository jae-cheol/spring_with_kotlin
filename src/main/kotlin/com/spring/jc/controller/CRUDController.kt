package com.example.neo.controller

import com.example.neo.dto.CRUDDto
import com.example.neo.service.CRUDService
import org.springframework.web.bind.annotation.*


@RestController
class CRUDController(
    private val crudService: CRUDService
) {

    // localhost:8080/test | POST
    @PostMapping("/test")
    fun test(){
        println("Test")
    }


    // REST API에서 클라이언트가 서버에 데이터를 생성(Create)하기 위해 요청 본문에 담아 보내는 데이터를 받으려면 Controller 메소드 인자에 어떤 어노테이션을 사용해야 할까요? @RequestBody
    // localhost:8080/create | POST
    @PostMapping("/create")
    fun create(
        @RequestBody body: CRUDDto
    ){
        crudService.create(body)
    }

    // 데이터 조회(Read) 기능을 구현할 때 REST API 컨벤션에 따라 주로 사용되는 HTTP 메소드는 무엇인가요? GET
    @GetMapping("/read/all")
    fun readAll(): List<CRUDDto> {
        return crudService.readAll()
    }

    // localhost:8080/read/{id} = 1 or 2
    // localhost:8080/read/2
    @GetMapping("/read/{id}")
    fun readById(
        @PathVariable id: Long
    ): CRUDDto {
        return crudService.readById(id)
    }

    // 데이터 수정(Update) 시 사용되는 PUT과 PATCH HTTP 메소드의 주요 차이점은 무엇인가요? PUT은 전체 교체, PATCH는 부분 수정
    // localhost:8080/update
    @PatchMapping("/update")
    fun update(
        @RequestBody dto: CRUDDto
    ) {
        crudService.update(dto)
    }

    // localhost:8080/delete/{id}
    // localhost:8080/delete/1
    @DeleteMapping("/delete/{id}")
    fun delete(
        @PathVariable id: Long
    ) {
        crudService.deleteById(id)
    }


}
package com.example.neo.entity

import jakarta.persistence.*

@Entity
@Table(name = "crud")
class CRUDEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    var title: String,

    @Column(nullable = false)
    var content: String,

) {
    fun update(title: String, content: String){
        this.title = title
        this.content = content
    }
}
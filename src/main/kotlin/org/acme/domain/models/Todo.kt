package org.acme.domain.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import net.bytebuddy.asm.Advice.AllArguments

@Entity
data class Todo(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,
        var title: String,
        var completed: Boolean = false
){
        constructor() : this(0, "", false)
}

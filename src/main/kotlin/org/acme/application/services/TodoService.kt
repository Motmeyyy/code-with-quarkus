package org.acme.application.services

import jakarta.enterprise.context.ApplicationScoped
import jakarta.transaction.Transactional
import org.acme.domain.models.Todo
import org.acme.domain.repositories.TodoRepository

@ApplicationScoped
class TodoService (private val todoRepository: TodoRepository) {
    fun findAll(): List<Todo> = todoRepository.listAll()

    fun findById(id: Long): Todo? = todoRepository.findById(id)
    @Transactional
    fun create(todo: Todo): Todo {
        todoRepository.persist(todo)
        return todo
    }

    @Transactional
    fun update(id: Long, todo: Todo): Todo? {
        val entity = todoRepository.findById(id) ?: return null
        entity.title = todo.title
        entity.completed = todo.completed
        return entity
    }

    @Transactional
    fun delete(id: Long): Boolean {
        return todoRepository.deleteById(id)
    }
}
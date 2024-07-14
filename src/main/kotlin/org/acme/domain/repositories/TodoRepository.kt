package org.acme.domain.repositories

import jakarta.enterprise.context.ApplicationScoped
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import org.acme.domain.models.Todo

@ApplicationScoped
class TodoRepository : PanacheRepository<Todo> {
}